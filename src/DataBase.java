import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    /**
     * The `connect` function establishes a connection to a MySQL database using the
     * provided host,
     * port, user, password, and database name.
     * 
     * @param Host     The `Host` parameter in the `connect` method represents the
     *                 hostname or IP address
     *                 of the database server to which you want to connect.
     * @param Port     The `Port` parameter in the `connect` method refers to the
     *                 port number on which the
     *                 MySQL database server is running. This is the port that the
     *                 application will use to establish a
     *                 connection to the database server.
     * @param User     The `User` parameter in the `connect` method refers to the
     *                 username used to
     *                 authenticate and connect to the MySQL database. This username
     *                 should have the necessary
     *                 permissions to access the specified database.
     * @param Password The `Password` parameter in the `connect` method is the
     *                 password used to
     *                 authenticate and connect to the database specified by the
     *                 `Host`, `Port`, and `DataBase`
     *                 parameters. It is a sensitive piece of information that
     *                 should be kept secure and not shared
     *                 publicly. It is used along with the
     * @param DataBase The `DataBase` parameter in the `connect` method refers to
     *                 the name of the
     *                 database you want to connect to. This parameter specifies the
     *                 database within the MySQL server
     *                 that you want to establish a connection with.
     * @return The `connect` method returns a `Connection` object if the connection
     *         is successful, and
     *         `null` if there is an error during the connection process.
     */
    private static Connection connect(String Host, int Port, String User, String Password, String DataBase) {
        // Paths and auths
        // Format : jdbc:sqlserver://serverName:portNumber/databaseName
        final String HOST = String.format("jdbc:mysql://%s:%d/%s", Host, Port, DataBase);
        final String USER = User;
        final String PASS = Password;
        try {
            // Register Driver
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            // Connection Creation
            Connection connection = DriverManager.getConnection(HOST, USER, PASS);
            if (connection.isValid(5)) {
                System.out.println("Connection Successful");
                return connection;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error 420");
            return null;
        }
    }

    /**
     * The function sets up a connection to a MySQL database with the specified
     * parameters.
     * 
     * @param DEFAULT "localhost",3306,"root","","javalogin";
     * @return A Connection object is being returned with default properties.
     */
    public static Connection setConnection() {
        return connect("localhost", 3306, "root", "daaaa12321", "javalogin");
    }

    /**
     * The function `setConnection` establishes a connection to a MySQL database
     * using the provided
     * host, port, username, password, and database name.
     * 
     * @param Host The `Host` parameter in the `setConnection` method is the
     *             hostname or IP address of
     *             the database server to which you want to establish a connection.
     * @return The method `setConnection` is returning a `Connection` object.
     */
    public static Connection setConnection(String Host) {
        return connect(Host, 3306, "root", "", "javalogin");
    }

    /**
     * The function sets up a database connection using the provided host, port, and
     * database name.
     * 
     * @param Host     The host parameter typically refers to the hostname or IP
     *                 address of the database
     *                 server where the database is hosted.
     * @param Port     Port is the port number on which the database server is
     *                 running. It is used to
     *                 establish a connection to the database server.
     * @param DataBase The `DataBase` parameter in the `setConnection` method refers
     *                 to the name of the
     *                 database to which you want to establish a connection.
     * @return A Connection object is being returned.
     */
    public static Connection setConnection(String Host, int Port, String DataBase) {
        return connect(Host, Port, "root", "", DataBase);
    }

    /**
     * The function `setConnection` establishes a connection to a database using the
     * provided host,
     * port, user credentials, and database name.
     * 
     * @param Host     The host parameter typically refers to the address of the
     *                 server where the database
     *                 is hosted. This could be an IP address or a domain name.
     * @param Port     Port is the port number used for the connection to the
     *                 database server. It is a
     *                 numerical value that specifies the communication endpoint for
     *                 the connection.
     * @param User     The `User` parameter typically refers to the username used to
     *                 authenticate and
     *                 access a database. It is usually associated with a specific
     *                 user account that has been granted
     *                 certain privileges or permissions within the database
     *                 management system.
     * @param Password It seems like you might have missed providing the information
     *                 for the "Password"
     *                 parameter. Please make sure to include the password needed to
     *                 establish the database connection
     *                 in the method call. If you have any specific questions or
     *                 need further assistance, feel free to
     *                 ask!
     * @param DataBase The `DataBase` parameter refers to the name of the database
     *                 that you want to
     *                 connect to. It is typically used to specify the specific
     *                 database within the database server
     *                 that you want to interact with.
     * @return The method `setConnection` is returning a `Connection` object.
     */
    public static Connection setConnection(String Host, int Port, String User, String Password, String DataBase) {
        return connect(Host, Port, User, Password, DataBase);
    }

    /**
     * The function `run` executes a SQL query using the provided connection and
     * returns a boolean
     * indicating the success of the query execution.
     * 
     * @param connection The `connection` parameter is an object representing a
     *                   connection to a database.
     *                   It allows you to communicate with the database to perform
     *                   operations like executing queries,
     *                   updates, inserts, etc.
     * @param query      The `query` parameter in the `run` method is a String that
     *                   represents an SQL query that
     *                   you want to execute on the database connected through the
     *                   `connection` parameter. This query can be
     *                   any valid SQL statement such as SELECT, INSERT, UPDATE,
     *                   DELETE, etc.
     * @return The method `run` returns a boolean value. It returns `true` if the
     *         query was successfully
     *         executed, and `false` if an exception occurred during the execution
     *         of the query.
     */
    public static boolean run(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.execute(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     * The function takes a SQL query, executes it using a provided database
     * connection, and returns the
     * result set as a list of lists of strings.
     * 
     * @param connection The `connection` parameter is an object representing a
     *                   connection to a database.
     *                   It is used to create a statement for executing SQL queries
     *                   and retrieving results from the database.
     * @param query      The `query` parameter in the `run` method is a String that
     *                   represents the SQL query to
     *                   be executed on the database. This query is used to retrieve
     *                   data from the database using a
     *                   `Statement` object.
     * @param resultSet  The `resultSet` parameter in the `run` method is used to
     *                   store the result set
     *                   obtained from executing the SQL query. It is a reference to
     *                   a `ResultSet` object that will hold the
     *                   results of the query executed on the database.
     * @return The method `run` returns a `List` of `List` of `String` containing
     *         the results of the query
     *         executed on the database.
     * @Danny-Wits
     */
    public static List<List<String>> run(Connection connection, String query, ResultSet resultSet) {
        List<List<String>> result = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            result = resultSetToList(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println(result.toString());
        return result;
    }

    /**
     * The function retrieves and prints the database product name using the
     * provided database
     * connection.
     * 
     * @param connection The `connection` parameter in the `getDetails` method is of
     *                   type `Connection`,
     *                   which is used to establish a connection to a database. This
     *                   connection is then used to retrieve
     *                   metadata about the database using the `DatabaseMetaData`
     *                   class.
     */
    public static void getDetails(Connection connection) {
        try {
            DatabaseMetaData details = connection.getMetaData();
            System.out.println("TYPE : " + details.getDatabaseProductName());
            ResultSet tables = details.getTables(null, null, null,new String[]{"TABLE"});
            System.out.println("TABLES : ");
            for (var i : resultSetToList(tables)) {
                    System.out.println("|" + i.get(2)+"|"); 
            }
            System.out.println("\nUSER:"+details.getUserName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * This function convert a resultset instance created by jdbc to a Java list object.
     * @param resultSet Result set is returned by JDBC queries
     * @return A List(List(String)) 
     */
    public static List<List<String>> resultSetToList(ResultSet resultSet) {
        List<List<String>> result = new ArrayList<>();
        try {
            ResultSetMetaData meta = resultSet.getMetaData();
            int columns = meta.getColumnCount();
            while (resultSet.next()) {
                result.add(new ArrayList<>());
                for (int i = 1; i <= columns; i++) {
                    result.get(resultSet.getRow() - 1).add(resultSet.getString(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }

}
