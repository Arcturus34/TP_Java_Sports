import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        
        PolySportsDatabase Data = PolySportsDatabase.getInstance();
        Data.connect();
        Statement myStatement = Data.createStatement();
        ResultSet results = myStatement.executeQuery("SELECT * FROM sport");

            while(results.next())
            {
                final String name = results.getString("name");
                final int participants = results.getInt("required_participants");

                System.out.println(name+", participants requis: "+participants);
            }

            
    }
}
