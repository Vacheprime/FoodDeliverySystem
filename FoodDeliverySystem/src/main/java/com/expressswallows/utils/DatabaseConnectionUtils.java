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
public class DatabaseConnectionUtils {
    private static DatabaseConnectionUtils instance;
    private static final String DATABASE_FILENAME = "FoodDeliveryData.db";
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
    public Client fetchClientWithCredentials(String email, String passwd) {
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
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * Get the address by ID.
     *
     * @param id the ID of the address.
     * @return the address object associated with the ID.
     */
    private Address fetchAddressById(int id) {
        final String SQL = """
                            SELECT * FROM address WHERE id = ?;
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    public Employee fetchEmployeeWithCredentials(String email, String passwd) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    /**
     * Fetch all restaurant locations.
     *
     * @return a list of all restaurant locations
     */
    public List<Restaurant> fetchRestaurantLocations() {
        final String SQL = """
                            SELECT RestaurantID FROM restaurant;
                            """;
        List<Restaurant> restaurants = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(SQL)) {
                while (rs.next()) {
                    int restaurantID = rs.getInt("RestaurantID");
                    Restaurant restaurant = fetchRestaurantById(restaurantID);
                    List<Order> orders = fetchRestaurantOrdersInProgress(restaurantID);

                    // Add orders to the restaurant
                    for (Order order : orders) {
                        try {
                            restaurant.addOrder(order);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Add to all restaurants
                    restaurants.add(restaurant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    /**
     * Get the restaurant orders that are in progress.
     * @return
     */
    private List<Order> fetchRestaurantOrdersInProgress(int restaurantID) {
        final String SQL = """
                            SELECT * FROM order WHERE restaurantID = ?;
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
                    // Add food items to oder
                    for (Food d: fetchOrderFoods(order.getOrderId())) {
                        order.addFoodToOrder(d);
                    }
                    // Add order to orders
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Sort by oldest to newest
        Collections.sort(orders, (o1, o2) -> {
            return o1.getOrderDateTime().compareTo(o2.getOrderDateTime());
        });
        return orders;
    }

    /**
     * Get a client by his ID.
     * @param clientId
     * @return
     */
    private Client fetchClientById(int clientId) {
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
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * Get a restaurant by its ID.
     * @param restaurantId
     * @return
     */
    private Restaurant fetchRestaurantById(int restaurantId) {
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
                restaurant = new Restaurant(fetchAddressById(rs.getInt("AddressID")), rs.getString("name"),
                        rs.getDouble("balance"));
                // TODO: add orders
                restaurant.setRestaurantId(restaurantId);
                List<Order> orders = fetchRestaurantOrdersInProgress(restaurantId);
                for (Order order : orders) {
                    try {
                        restaurant.addOrder(order);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    private List<Food> fetchOrderFoods(int orderID) {
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
                    String[] type = rs.getString("Type").split(":");
                    FoodFactoryCreator creator = new FoodFactoryCreator();
                    AbstractFactory factory = creator.getFoodFactory(type[0]);
                    Food food = null;
                    switch (type[0]) {
                        case "Pizza" -> {
                            food = factory.createPizza(type[1]);
                        }

                        case "Burger" -> {
                            food = factory.createBurger(type[1]);
                        }

                        case "Hotdog" -> {
                            food = factory.createHotdog(type[1]);
                        }

                        case "Drink" -> {
                            food = factory.createDrink(type[1], rs.getString("Size"));
                        }

                        case "Fries" -> {
                            food = factory.createFries(type[1]);
                        }
                    }
                    foods.add(food);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    /**
     * Get orders by client ID.
     * @param clientId the client ID of the order.
     * @return the orders made by the client with the specified client ID.
     */
    public List<Order> fetchOrdersByClientId(int clientId) {
        final String SQL = """
                           SELECT * FROM order WHERE ClientID = ?;
                           """;
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // TODO
    public void insertOrder(Order order) {

    }

    // TODO
    private void insertOrderFood(int orderId, int foodId) {

    }

    // TODO
    public void insertPayment(Payment payment) {

    }

    // TODO
    public void insertClient(Client client) {

    }

    // TODO: CREATE TRIGGER FOR PAYMENT
    
    /**
     * Create the client table.
     * 
     * @throws DatabaseInitializationException exception thrown when the client
     * table could not be created.
     */
    private synchronized void createClientTable() throws DatabaseInitializationException {
        final String SQL = """
                     CREATE TABLE IF NOT EXISTS clients (
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
                                DateOfBirth TEXT NOT NULL
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
                                PaymentMethod TEXT NOT NULL
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
                           CREATE TABLE IF NOT EXISTS order (
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
                                CONSTRAINT fk_OrderID FOREIGN KEY (OrderID) REFERENCES order(OrderID),
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
                                Type TEXT NOT NULL UNIQUE,
                                CookTime INTEGER NOT NULL,
                                Price REAL NOT NULL,
                                Size TEXT,
                                SugarContent INTEGER,
                                Bun TEXT,
                                Spiciness INTEGER,
                                Sauce TEXT,
                                CONSTRAINT chk_CookTime CHECK (CookTime > 0),
                                CONSTRAINT chk_Price CHECK (Price > 0),
                                CONSTRAINT chk_Size CHECK (Size IN ('S', 'M', 'L')),
                                CONSTRAINT chk_SugarContent CHECK (SugarContent >= 0),
                                CONSTRAINT chk_Bun CHECK (Bun IN 'Soggy', 'White', 'WholeWheat'),
                                CONSTRAINT chk_Spiciness CHECK (Spiciness BETWEEN 1 AND 5)
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
    private synchronized void createFoodTopping() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS foodtopping (
                                ToppingID INTEGER NOT NULL,
                                FoodID INTEGER NOT NULL,
                                CONSTRAINT fk_ToppingID FOREIGN KEY (ForeignID) REFERENCES topping(ToppingID),
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
}