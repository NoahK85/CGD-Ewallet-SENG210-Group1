import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseWriter {

    public static void insertExpense(
            String source,
            double amount,
            int yearlyFrequency) {

        String sql = """
                INSERT INTO Expense
                (source, amount, yearlyfrequency)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
        	
            statement.setString(1, source);
            statement.setDouble(2, amount);
            statement.setInt(3, yearlyFrequency);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertWage(
            String source,
            double amount,
            int month) {

        String sql = """
                INSERT INTO Wage
                (source, amount, month)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, source);
            statement.setDouble(2, amount);
            statement.setInt(3, month);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadFromDatabase(User u) { 
    	String strExpense = "SELECT * FROM EXPENSE";
    	String strWage    = "SELECT * FROM WAGE";
    	
		//import expenses
    	try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(strExpense)) {
               Object expenseList = statement.executeQuery();
               System.out.println(expenseList);
               
               ResultSet results = statement.executeQuery();
   				while(results.next())
   				{
   					String source      = results.getString(1);
   					double amount      = results.getDouble(2);
   					int    yearlyfreq  = results.getInt(3);
   					u.importSpending(new Expense(source, amount, yearlyfreq));
   				}
   				results.close();

           } catch (SQLException e) {
               e.printStackTrace();
           }
    	
    	//import wages
    	try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(strWage)) {
               Object expenseList = statement.executeQuery();
               System.out.println(expenseList);
               
               ResultSet results = statement.executeQuery();
   				while(results.next())
   				{
   					String source      = results.getString(1);
   					double amount      = results.getDouble(2);
   					int    month       = results.getInt(3);
   					u.importIncome(new Wage(source, amount, month));
   				}
   				results.close();

           } catch (SQLException e) {
               e.printStackTrace();
           }
    }
}