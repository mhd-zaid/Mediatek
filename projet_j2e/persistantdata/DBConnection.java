package persistantdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URI = "jdbc:mysql://localhost:3306/projet_j2e?serverTimezone=GMT";
    private static final String user = "root";
    private static final String pwd = "1234";

    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance(){
        if(connection == null)
            connection = getConnection();
        return connection;
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URI, user, pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
