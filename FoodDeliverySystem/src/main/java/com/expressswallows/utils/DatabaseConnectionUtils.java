package com.expressswallows.utils;

import com.expressswallows.exceptions.*;
import com.expressswallows.model.menu.factories.AbstractFactory;
import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.Payment;
import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The DatabaseConnectionUtils class is used to interact with the database.
 * It stores the database connection throughout the execution of the program, 
 * and allows database operations such as inserting rows into tables, and
 * fetching data.
 * 
 * @author Danat
 */
public class DatabaseConnectionUtils implements AutoCloseable {
    private static DatabaseConnectionUtils instance;
    private static final String DATABASE_FILENAME = "src/main/resources/FoodDeliveryData.db";
    private static final String DATABASE_URL = "jdbc:sqlite:" + DATABASE_FILENAME;
    private Connection connection;

    /**
     * Singleton design pattern. Get the instance of the DatabaseConnectionUtils.
     * 
     * @return the instance of the DatabaseConnectionUtils.
     * @throws DatabaseException exceptions that can happen during connection or
     * initialization of the database.
     */
    public static DatabaseConnectionUtils getInstance() throws DatabaseException {
        if (instance == null) {
            synchronized (DatabaseConnectionUtils.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionUtils();
                }
            }
        }
        return instance;
    } 
    
    /**
     * Singleton design pattern. Private constructor to disallow instantiation
     * of this class.
     * 
     * @throws DatabaseException exceptions that can happen during connection or
     * initialization of the database.
     */
    private DatabaseConnectionUtils() throws DatabaseException {
        if (existsDatabase()) {
            connect();
        } else {
            initializeDatabase();
        }
        
    }
    
    /**
     * Connect to the database.
     * 
     * @throws DatabaseConnectionException exception thrown when the connection
     * could not be established.
     */
    private void connect() throws DatabaseConnectionException {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Error: could not connect to the database '" 
                    + DATABASE_URL + "': " + e.getMessage());
        }
    }

    /**
     * Close the connection to the database.
     * @throws SQLException Exception thrown when an error occurs while
     */
    public void closeConnection() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            instance = null;
        }
    }
    
    /**
     * Check whether the database exists.
     * 
     * @return a boolean indicating whether the database exists.
     */
    private boolean existsDatabase() {
        Path path = Paths.get(DATABASE_FILENAME);
        return Files.exists(path);
    }
    
    /**
     * Initialize (create) the database.
     * 
     * @throws DatabaseInitializationException exception thrown when the database
     * could not be created.
     * @throws DatabaseConnectionException exception thrown when the connection
     * could not be established.
     */
    private void initializeDatabase() throws DatabaseInitializationException, DatabaseConnectionException {
        try {
            // Create the database file
            Path path = Paths.get(DATABASE_FILENAME);
            Files.createFile(path);
            // Connect to the database
            connect();
            // Create the tables
            createEmployeeTable();
            createAddressTable();
            createClientTable();
            createRestaurantTable();
            createPaymentTable();
            createOrderTable();
            createFoodTable();
            createOrderFoodTable();
            createToppingTable();
            createFoodToppingTable();
        } catch (IOException e) {
            throw new DatabaseInitializationException("Error: could not initialize database '"
                    + DATABASE_FILENAME + "': " + e.getMessage());
        }
    }

    /**
     * Get the client with the specified email and password.
     *
     * @param email the email of the client to fetch.
     * @param passwd the password of the client to fetch.
     * @return the client with the email and password specified. Null if the Client
     * with such credentials does not exist.
     */
    public Client fetchClientWithCredentials(String email, String passwd) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM client WHERE Email = ? AND Password = ?;
                            """;
        Client client = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setString(1, email);
            pstmt.setString(2, passwd);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                client = new Client(rs.getString("FirstName"), rs.getString("LastName"),
                        email, passwd, LocalDate.parse(rs.getString("DateOfBirth")),
                        rs.getString("PhoneNumber"), fetchAddressById(rs.getInt("AddressID")));
                // Set the client id
                client.setClientId(rs.getInt("ClientID"));
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet of client: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the client with credentials: " + e.getMessage());
        }
        return client;
    }

    /**
     * Get the address by ID.
     *
     * @param id the ID of the address.
     * @return the address object associated with the ID.
     */
    private Address fetchAddressById(int id) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM address WHERE AddressID = ?;
                            """;
        Address address = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                address = new Address(rs.getString("Street"), rs.getString("StreetNo"),
                        rs.getString("PostalCode"), Address.City.valueOf(rs.getString("City")));
                // Set the address ID
                address.setAddressId(rs.getInt("AddressID"));
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet of addresses: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the address with the specified ID: " + e.getMessage());
        }
        return address;
    }

    /**
     * Get the employee with the specified email and password.
     *
     * @param email the email of the employee.
     * @param passwd the password of the employee.
     * @return the employee with the specified email and password.
     */
    public Employee fetchEmployeeWithCredentials(String email, String passwd) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM employee WHERE Email = ? AND Password = ?;
                            """;
        Employee employee = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setString(1, email);
            pstmt.setString(2, passwd);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                employee = new Employee(rs.getString("FirstName"), rs.getString("LastName"),
                        email, passwd, LocalDate.parse(rs.getString("DateOfBirth")),
                        rs.getString("PhoneNumber"));
                // Set the employeeid
                employee.setEmployeeId(rs.getInt("EmployeeID"));
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet of employee: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the employee with credentials: " + e.getMessage());
        }
        return employee;
    }

    /**
     * Fetch all restaurant locations.
     * @return a list of all restaurant locations.
     */
    public List<Restaurant> fetchRestaurantLocations() throws DatabaseFetchException {
        final String SQL = """
                            SELECT RestaurantID FROM restaurant;
                            """;
        List<Restaurant> restaurants = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                int restaurantID = rs.getInt("RestaurantID");
                Restaurant restaurant = fetchRestaurantById(restaurantID);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the list of restaurants: " + e.getMessage());
        }
        return restaurants;
    }

    /**
     * Get the restaurant orders that are in progress.
     * @param restaurantID the restaurant ID.
     * @return a list of the ongoing orders of the restaurant specified.
     */
    private List<Order> fetchRestaurantOrdersInProgress(int restaurantID) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM "order" WHERE restaurantID = ?;
                            """;
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setInt(1, restaurantID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    if (rs.getString("Status").equals("DELIVERED")) {
                        continue;
                    }
                    // Create the order
                    Order order = new Order(restaurantID, fetchClientById(rs.getInt("ClientID")));
                    // Set the order id
                    order.setOrderId(rs.getInt("OrderID"));
                    // Set the order time
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    order.setOrderDateTime(LocalDateTime.parse(rs.getString("OrderTime"), formatter));
                    // Add food items to oder
                    for (Food d: fetchOrderFoods(order.getOrderId())) {
                        order.addFoodToOrder(d);
                    }
                    // Add order to orders
                    orders.add(order);
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet while fetching restaurant orders: " +
                        e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the list of restaurant orders: " + e.getMessage());
        }
        // Sort by oldest to newest
        Collections.sort(orders, (o1, o2) -> o1.getOrderDateTime().compareTo(o2.getOrderDateTime()));
        return orders;
    }

    /**
     * Get a client by his ID.
     * @param clientId the client ID of the client to fetch.
     * @return the Client with the specified ID.
     */
    private Client fetchClientById(int clientId) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM client WHERE ClientID = ?;
                            """;
        Client client = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setInt(1, clientId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                client = new Client(rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("Email"), rs.getString("Password"),
                        LocalDate.parse(rs.getString("DateOfBirth")), rs.getString("PhoneNumber"),
                        fetchAddressById(rs.getInt("AddressID")));
                // Set the client id
                client.setClientId(clientId);
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet while fetching client: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the client: " + e.getMessage());
        }
        return client;
    }

    /**
     * Get a restaurant by its ID.
     * @param restaurantId the restaurant with the ID specified.
     * @return the restaurant with the specified ID.
     */
    private Restaurant fetchRestaurantById(int restaurantId) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM restaurant WHERE restaurantID = ?;
                            """;
        Restaurant restaurant = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setInt(1, restaurantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                // Create a new order
                restaurant = new Restaurant(fetchAddressById(rs.getInt("AddressID")),
                        rs.getString("name"), rs.getDouble("balance"));
                // Set the restaurant ID
                restaurant.setRestaurantId(restaurantId);
                // Get the list of orders and add it to the restaurant
                List<Order> orders = fetchRestaurantOrdersInProgress(restaurantId);
                for (Order order : orders) {
                    try {
                        restaurant.addOrder(order);
                    } catch (InterruptedException e) {
                        throw new DatabaseFetchException("Error: could not fetch the restaurant because adding an order" +
                                "to the restaurant's queue was interrupted: " + e.getMessage());
                    }
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet while fetching restaurant: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the restaurant by ID: " + e.getMessage());
        }
        return restaurant;
    }

    // TODO: TEST WITH ALL FOODS
    // TODO: DON'T USE FACTORY, MANUALLY SET VALUES FROM QUERY
    /**
     * Fetch the list of foods contained in an order.
     * @param orderID the order ID of the order.
     * @return a list of foods contained in the order specified.
     * @throws DatabaseFetchException Exception thrown when the list of foods could not be fetched.
     */
    private List<Food> fetchOrderFoods(int orderID) throws DatabaseFetchException {
        final String SQL = """
                            SELECT * FROM food f
                            JOIN orderfood of ON f.FoodID = of.FoodID
                            WHERE OrderID = ?;
                            """;
        List<Food> foods = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setInt(1, orderID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    foods.add(getFoodFromFoodQuery(rs));
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet while fetching food: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch order foods: " + e.getMessage());
        }
        return foods;
    }

    /**
     * Get a single food item from a result set that executed a query that includes all columns of the
     * food table.
     * @param rs the ResultSet of the executed query
     * @throws SQLException Exception thrown when an error occurs during database operations.
     */
    private Food getFoodFromFoodQuery(ResultSet rs) throws SQLException {
        // Type of format: CATEGORY:FOODITEM
        String[] type = rs.getString("Type").split(":");

        FoodFactoryCreator creator = new FoodFactoryCreator();
        AbstractFactory factory = creator.getFoodFactory(type[0]);

        Food food = null;
        // Switch for every food item and create the appropriate food item
        switch (type[0].toUpperCase()) {
            case "PIZZA" -> {
                food = factory.createPizza(type[1]);
            }

            case "BURGER" -> {
                food = factory.createBurger(type[1]);
            }

            case "HOTDOG" -> {
                food = factory.createHotdog(type[1]);
            }

            case "DRINK" -> {
                int drinkNumber = Utils.drinkNameToNumber.get(type[1].toUpperCase());
                int sizeNumber = Utils.sizeToNumber.get(rs.getString("Size").toUpperCase());
                food = factory.createDrink(drinkNumber, sizeNumber);
            }

            case "FRIES" -> {
                int sizeNumber = Utils.sizeToNumber.get(rs.getString("Size").toUpperCase());
                food = factory.createFries(sizeNumber);
            }
        }
        return food;
    }

    /**
     * Get orders by client ID.
     * @param clientId the client ID of the order.
     * @return the orders made by the client with the specified client ID.
     */
    public List<Order> fetchOrdersByClientId(int clientId) throws DatabaseFetchException {
        final String SQL = """
                           SELECT * FROM "order" WHERE ClientID = ?;
                           """;
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            // Form the SQL
            pstmt.setInt(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Create the order
                    Order order = new Order(rs.getInt("RestaurantID"), fetchClientById(clientId));
                    // Set the order ID
                    order.setOrderId(rs.getInt("OrderID"));
                    // Add the foods
                    List<Food> foods = fetchOrderFoods(order.getOrderId());
                    for (Food f : foods) {
                        order.addFoodToOrder(f);
                    }
                    // Add order to orders
                    orders.add(order);
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet while fetching order: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not fetch the orders made by client: " + e.getMessage());
        }
        return orders;
    }

    /**
     * Insert an order.
     * @param order the order to insert.
     */
    public void insertOrder(Order order) throws DatabaseInsertException, DatabaseFetchException {
        final String SQL = """
                            INSERT INTO "order" (OrderTime, Status, ClientID, RestaurantID)
                            VALUES (?, ?, ?, ?);
                            """;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            // Form the SQL statement
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            pstmt.setString(1, order.getOrderDateTime().format(formatter));
            pstmt.setString(2, order.getStatus().toString());
            pstmt.setInt(3, order.getOrderedBy().getClientId());
            pstmt.setInt(4, order.getRestaurantId());
            pstmt.executeUpdate();
            // Get the primary key
            int id = -1;
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not fetch the primary key of the order: " + e.getMessage());
            }
            if (id == -1) {
                throw new DatabaseFetchException("Error: could not get the order ID of the order inserted.");
            }
            // Set the order ID
            order.setOrderId(id);
            // Insert the food items into the orderfood table
            for (Food food : order.getFoods()) {
                insertOrderFood(order.getOrderId(), food);
            }
        } catch (SQLException e) {
            throw new DatabaseInsertException("Error: could not insert order: " + e.getMessage());
        }
    }

    /**
     * Insert an order's food item into the orderfood table.
     * @param orderId the order ID.
     * @param food the order's food item.
     * @throws DatabaseInsertException Exception thrown when an error occurs while inserting the into the orderfood table.
     * @throws DatabaseFetchException Exception thrown when an error occurs while getting the food ID of the order's
     * food item.
     */
    private void insertOrderFood(int orderId, Food food) throws DatabaseInsertException, DatabaseFetchException {
        final String FOOD_SQL = """
                                 SELECT FoodID FROM food
                                 WHERE Type = ?;
                                 """;
        final String INSERT_SQL = """
                                   INSERT INTO orderfood (OrderID, FoodID)
                                   VALUES (?, ?);
                                   """;
        try (PreparedStatement foodIdQuery = connection.prepareStatement(FOOD_SQL);
        PreparedStatement insertStmt = connection.prepareStatement(INSERT_SQL)) {
            // Form the SQL for the food ID query
            foodIdQuery.setString(1, food.getDatabaseType());
            int foodId = -1;
            // Fetch the FoodID of the food item
            try (ResultSet rs = foodIdQuery.executeQuery()) {
                if (rs.next()) {
                    foodId = rs.getInt("FoodID");
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not fetch the food ID of the item '" + food +
                        "': " + e.getMessage());
            }
            // Check if the foodID has been found
            if (foodId == -1) {
                throw new DatabaseFetchException("Error: the database does not contain a food entry for the item '" + food +
                        "' contained in the order with ID: " + orderId);
            }
            // Form the SQL for the insert statement
            insertStmt.setInt(1, orderId);
            insertStmt.setInt(2, foodId);
            // Execute the insert statement
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseInsertException("Error: could not insert the food item of the order: " + e.getMessage());
        }
    }

    /**
     * Insert a payment into the payment table.
     * @param payment the payment to insert.
     * @param restaurantId the restaurant ID to which the payment is going to go.
     * @throws DatabaseInsertException Exception thrown when an error occurs while inserting the payment.
     */
    public void insertPayment(Payment payment, int restaurantId) throws DatabaseInsertException {
        final String SQL = """
                            INSERT INTO payment (PaymentAmount, PaymentMethod, ClientID, RestaurantID)
                            VALUES (?, ?, ?, ?);
                            """;
        final String UPDATE_SQL = """
                                   UPDATE restaurant
                                   SET Balance = Balance + ?
                                   WHERE RestaurantID = ?;
                                   """;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL);
             PreparedStatement updatePstmt = connection.prepareStatement(UPDATE_SQL)) {
            // Form the SQL statement
            pstmt.setDouble(1, payment.getPaymentAmount());
            pstmt.setString(2, "CREDIT");
            pstmt.setInt(3, payment.getPayedBy().getClientId());
            pstmt.setInt(4, restaurantId);
            // Execute the insert statement.
            pstmt.executeUpdate();
            // Update the value of the restaurant's balance
            updatePstmt.setDouble(1, payment.getPaymentAmount());
            // Execute the update balance
            updatePstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseInsertException("Error: could not insert payment: " + e.getMessage());
        }
    }

    /**
     * Insert a client into the client table.
     * @param client the client to insert.
     * @throws DatabaseInsertException Exception thrown when an error occurs while inserting the client into
     * the database.
     */
    public void insertClient(Client client) throws DatabaseInsertException, DatabaseFetchException {
        final String SQL = """
                            INSERT INTO client (FirstName, LastName, Email, Password, DateOfBirth, PhoneNumber, AddressID)
                            VALUES (?, ?, ?, ?, ?, ?, ?);
                            """;

        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            // Insert the client's address
            insertAddress(client.getAddress());
            // Form the SQL statement
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            pstmt.setString(1, client.getFirstName());
            pstmt.setString(2, client.getLastName());
            pstmt.setString(3, client.getEmail());
            pstmt.setString(4, client.getPassword());
            pstmt.setString(5, client.getDob().format(formatter));
            pstmt.setString(6, client.getPhoneNumber());
            pstmt.setInt(7, client.getAddress().getAddressId());
            // Execute the insert
            pstmt.executeUpdate();
            int id = -1;
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not fetch the client ID of the client: " + e.getMessage());
            }
            if (id == -1) {
                throw new DatabaseFetchException("Error: could not get the client ID of the client inserted.");
            }
            // Set the Id
            client.setClientId(id);
        } catch (SQLException e) {
            throw new DatabaseInsertException("Error: could not insert client: " + e.getMessage());
        }
    }

    /**
     * Insert an address.
     * @param addr the address to insert.
     * @throws DatabaseInsertException Exception thrown when an error occurs while inserting the address or client.
     * @throws DatabaseFetchException Exception thrown when fetching the primary key of the address or client.
     */
    private void insertAddress(Address addr) throws DatabaseInsertException, DatabaseFetchException {
        final String SQL = """
                            INSERT INTO address (Street, City, PostalCode, StreetNo)
                            VALUES (?, ?, ?, ?);
                            """;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            // Form the SQL statement
            pstmt.setString(1, addr.getStreet());
            pstmt.setString(2, addr.getCity().toString().toUpperCase());
            pstmt.setString(3, addr.getPostalCode());
            pstmt.setString(4, addr.getStreetNo());
            // Execute the statement
            pstmt.executeUpdate();
            // Get the primary key
            int id = -1;
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                id = rs.getInt(1);
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read the ResultSet of the address ID: " + e.getMessage());
            }
            if (id == -1) {
                throw new DatabaseFetchException("Error: could not get the address ID of the address inserted.");
            }
            // Set the ID of the address
            addr.setAddressId(id);
        } catch (SQLException e) {
            throw new DatabaseInsertException("Error: could not insert address: " + e.getMessage());
        }
    }

    /**
     * Count the amount of orders made to the restaurant.
     * @param restaurantId the restaurant ID.
     * @return the amount of orders made to the restaurant.
     * @throws DatabaseFetchException Exception thrown when an error occurs while counting the number of orders.
     */
    public int countRestaurantOrders(int restaurantId) throws DatabaseFetchException {
        final String SQL = """
                            SELECT COUNT(*) AS NbrOrders FROM "order"
                            WHERE RestaurantID = ?;
                            """;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            // Form the SQL
            pstmt.setInt(1, restaurantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.getInt("NbrOrders");
            } catch (SQLException e) {
                throw new DatabaseFetchException("Error: could not read ResultSet while counting orders: " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new DatabaseFetchException("Error: could not count the amount of orders of the restaurant: " +
                    e.getMessage());
        }
    }

    /**
     * Create the client table.
     * 
     * @throws DatabaseInitializationException exception thrown when the client
     * table could not be created.
     */
    private synchronized void createClientTable() throws DatabaseInitializationException {
        final String SQL = """
                     CREATE TABLE IF NOT EXISTS client (
                        ClientID INTEGER PRIMARY KEY,
                        FirstName TEXT NOT NULL,
                        LastName TEXT NOT NULL,
                        Email TEXT UNIQUE NOT NULL,
                        Password TEXT NOT NULL,
                        DateOfBirth TEXT NOT NULL,
                        PhoneNumber TEXT NOT NULL,
                        AddressID INTEGER,
                        CONSTRAINT chk_Email CHECK (Email LIKE '%_@__%.__%'),
                        CONSTRAINT chk_DateOfBirth CHECK (DateOfBirth LIKE '____-__-__'),
                        CONSTRAINT fk_AddressID FOREIGN KEY (AddressID) REFERENCES address(AddressID)
                     );
                     """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the client table: " + e.getMessage());
        }
    }
    
    /**
     * Create the address table.
     * 
     * @throws DatabaseInitializationException exception thrown when the address
     * table could not be created.
     */
    private synchronized void createAddressTable() throws DatabaseInitializationException {
        final String SQL = """
                    CREATE TABLE IF NOT EXISTS address (
                       AddressID INTEGER PRIMARY KEY,
                       Street TEXT NOT NULL,
                       City TEXT NOT NULL,
                       PostalCode TEXT NOT NULL,
                       StreetNo TEXT NOT NULL,
                       CONSTRAINT chk_PostalCode CHECK (PostalCode LIKE '___-___')
                    );
                    """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the address table: " + e.getMessage());
        }
    }
    
    /**
     * Create the employee table.
     * 
     * @throws DatabaseInitializationException exception thrown when the employee
     * table could not be created.
     */
    private synchronized void createEmployeeTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS employee (
                                EmployeeID INTEGER PRIMARY KEY,
                                FirstName TEXT NOT NULL,
                                LastName TEXT NOT NULL,
                                Email TEXT UNIQUE NOT NULL,
                                Password TEXT NOT NULL,
                                DateOfBirth TEXT NOT NULL,
                                PhoneNumber TEXT NOT NULL,
                                CONSTRAINT chk_Email CHECK (Email LIKE '%_@__%.__%'),
                                CONSTRAINT chk_DateOfBirth CHECK (DateOfBirth LIKE '____-__-__'),
                                CONSTRAINT chk_PhoneNumber CHECK (PhoneNumber LIKE '(___) ___-____')
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the employee table: " + e.getMessage());
        }
    }
    
    /**
     * Create the payment table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createPaymentTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS payment (
                                PaymentID INTEGER PRIMARY KEY,
                                PaymentAmount REAL NOT NULL,
                                PaymentMethod TEXT NOT NULL,
                                ClientID INTEGER NOT NULL,
                                RestaurantID INTEGER NOT NULL,
                                CONSTRAINT positive_PaymentAmount CHECK (PaymentAmount > 0),
                                CONSTRAINT chk_PaymentMethod CHECK (PaymentMethod IN ('CREDIT')),
                                CONSTRAINT fk_ClientID FOREIGN KEY (ClientID) REFERENCES client(ClientID),
                                CONSTRAINT fk_RestaurantID FOREIGN KEY (RestaurantID) REFERENCES restaurant(RestaurantID)
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the payment table: " + e.getMessage());
        }
    }
    
    /**
     * Create the restaurant table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createRestaurantTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS restaurant (
                                RestaurantID INTEGER PRIMARY KEY,
                                Name TEXT NOT NULL,
                                Balance REAL NOT NULL,
                                AddressID INTEGER NOT NULL,
                                CONSTRAINT chk_Balance CHECK (Balance >= 0),
                                CONSTRAINT fk_AddressID FOREIGN KEY (AddressID) REFERENCES address(AddressID)
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the restaurant table: " + e.getMessage());
        }
    }
    
    /**
     * Create the order table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createOrderTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS "order" (
                                OrderID INTEGER PRIMARY KEY,
                                OrderTime TEXT NOT NULL,
                                Status TEXT NOT NULL,
                                ClientID INTEGER NOT NULL,
                                RestaurantID INTEGER NOT NULL,
                                CONSTRAINT chk_OrderTime CHECK (OrderTime LIKE '____-__-__ __:__:__'),
                                CONSTRAINT chk_Status CHECK (Status IN ('IN_PROGRESS', 'DELIVERING', 'DELIVERED')),
                                CONSTRAINT fk_ClientID FOREIGN KEY (ClientID) REFERENCES client(ClientID),
                                CONSTRAINT fk_RestaurantID FOREIGN KEY (RestaurantID) REFERENCES restaurant(RestaurantID)
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the order table: " + e.getMessage());
        }
    }
    
    /**
     * Create the orderfood table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createOrderFoodTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS orderfood (
                                OrderID INTEGER NOT NULL,
                                FoodID INTEGER NOT NULL,
                                CONSTRAINT fk_OrderID FOREIGN KEY (OrderID) REFERENCES "order"(OrderID),
                                CONSTRAINT fk_FoodID FOREIGN KEY (FoodID) REFERENCES food(FoodID)
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the orderfood table: " + e.getMessage());
        }
    }
    
    /**
     * Create the food table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createFoodTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS food (
                                FoodID INTEGER PRIMARY KEY,
                                Type TEXT NOT NULL,
                                CookTime INTEGER NOT NULL,
                                Price REAL NOT NULL,
                                Size TEXT,
                                SugarContent INTEGER,
                                Bun TEXT,
                                Spiciness INTEGER,
                                Sauce TEXT,
                                CONSTRAINT chk_CookTime CHECK (CookTime > 0),
                                CONSTRAINT chk_Price CHECK (Price > 0),
                                CONSTRAINT chk_Size CHECK (Size IN ('SMALL', 'MEDIUM', 'LARGE')),
                                CONSTRAINT chk_SugarContent CHECK (SugarContent >= 0),
                                CONSTRAINT chk_Bun CHECK (Bun IN ('Soggy', 'White', 'WholeWheat')),
                                CONSTRAINT chk_Spiciness CHECK (Spiciness BETWEEN 0 AND 10)
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the orderfood table: " + e.getMessage());
        }
    }
    
    /**
     * Create the foodtopping table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createFoodToppingTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS foodtopping (
                                ToppingID INTEGER NOT NULL,
                                FoodID INTEGER NOT NULL,
                                CONSTRAINT fk_ToppingID FOREIGN KEY (ToppingID) REFERENCES topping(ToppingID),
                                CONSTRAINT fk_FoodID FOREIGN KEY (FoodID) REFERENCES food(FoodID)
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the orderfood table: " + e.getMessage());
        }
    }
    
    /**
     * Create the topping table.
     * 
     * @throws DatabaseInitializationException exception thrown when the 
     * employee table could not be created.
     */
    private synchronized void createToppingTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS topping (
                                ToppingID INTEGER PRIMARY KEY,
                                Name TEXT NOT NULL UNIQUE
                           );
                           """;
        try {
            executeSQL(SQL);
        } catch (SQLException e) {
            throw new DatabaseInitializationException("Error: could not create"
                    + " the orderfood table: " + e.getMessage());
        }
    }
    
    /**
     * Helper method used to execute SQL statements.
     * 
     * @param sql the SQL statement to execute.
     * @throws SQLException exception thrown when the statement fails to 
     * execute. 
     */
    private synchronized void executeSQL(String sql) throws SQLException {
        // Create the statement
        try (Statement stmt = connection.createStatement()) {
            // Execute the SQL
            stmt.execute(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Auto close the database connection when exiting the try-with-resources block.
     * @throws Exception Exception thrown by body of close method.
     */
    @Override
    public void close() throws Exception {
        closeConnection();
    }
}