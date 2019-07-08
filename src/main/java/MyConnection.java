import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DIO
 */
public class MyConnection {
    static Connection conn;

    public static Connection getConnection(){
        try {
            conn= DriverManager.getConnection("jdbc:sqlite:db_test");

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
