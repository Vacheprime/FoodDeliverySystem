package com.expressswallows.utils;

import com.expressswallows.exceptions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

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
     * Create the client table.
     * 
     * @throws DatabaseInitializationException exception thrown when the client
     * table could not be created.
     */
    private void createClientTable() throws DatabaseInitializationException {
        final String SQL = """
                     CREATE TABLE IF NOT EXISTS clients (
                        ClientID INTEGER PRIMARY KEY,
                        FirstName TEXT NOT NULL,
                        LastName TEXT NOT NULL,
                        Email TEXT NOT NULL,
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
    private void createAddressTable() throws DatabaseInitializationException {
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
    private void createEmployeeTable() throws DatabaseInitializationException {
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
    private void createPaymentTable() throws DatabaseInitializationException {
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
    private void createRestaurantTable() throws DatabaseInitializationException {
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
    private void createOrderTable() throws DatabaseInitializationException {
        final String SQL = """
                           CREATE TABLE IF NOT EXISTS order (
                                OrderID INTEGER PRIMARY KEY,
                                OrderTime TEXT NOT NULL,
                                Status TEXT NOT NULL,
                                ClientID INTEGER NOT NULL,
                                RestaurantID INTEGER NOT NULL,
                                CONSTRAINT chk_OrderTime CHECK (OrderTime LIKE '____-__-__ __:__:__'),
                                CONSTRAINT chk_Status CHECK (Status IN ('Preparing', 'Delivering', 'Completed')),
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
    private void createOrderFoodTable() throws DatabaseInitializationException {
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
    private void createFoodTable() throws DatabaseInitializationException {
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
    private void createFoodTopping() throws DatabaseInitializationException {
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
    private void createToppingTable() throws DatabaseInitializationException {
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
    private void executeSQL(String sql) throws SQLException {
        // Create the statement
        try (Statement stmt = connection.createStatement()) {
            // Execute the SQL
            stmt.execute(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
}