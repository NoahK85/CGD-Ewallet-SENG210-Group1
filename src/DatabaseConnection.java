import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;


public class DatabaseConnection {

    private static final String URL =
            "jdbc:derby:c:/Users/noaht/MyDB102";
    
    
    public static Connection getConnection() throws SQLException {
    	try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DriverManager.getConnection(URL);
    }
}