import java.sql.Connection;


public class App {
    public static void main(String[] args) throws Exception {
        Connection connection = DataBase.setConnection();
        DataBase.getDetails(connection);
        connection.close();
    }
}