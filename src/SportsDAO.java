import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SportsDAO {
    private MYSQLDatabase database;

    public SportsDAO(MYSQLDatabase database){
        this.database = database;
    }

    public ArrayList<Sport> findAll(){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        Statement myStatement = database.createStatement();
        try{
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport;");

            while(results.next())
            {
                final int id = results.getInt("id");
                final String name = results.getString("name");
                final int participants = results.getInt("required_participants");

                Sport sport = new Sport(id, name, participants);
                sports.add(sport);
            }
            return sports;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    /*public Sport findById(int ID){
        Statement myStatement = database.createStatement();
        try{
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport WHERE id = "+ID+";");
            while(results.next())
            {
                final int id = results.getInt("id");
                final String name = results.getString("name");
                final int participants = results.getInt("required_participants");

                Sport sport = new Sport(id, name, participants);
                return sport;
            }
            return null;

        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    */

        public Sport findById(int ID){
        try{
            String requete = "SELECT * FROM sport WHERE id = ? ;";
            PreparedStatement myStatement = database.preparedStatement(requete);
            myStatement.setInt(1, ID);
            ResultSet results = myStatement.executeQuery();
            while(results.next())
            {
                final int id = results.getInt("id");
                final String name = results.getString("name");
                final int participants = results.getInt("required_participants");

                Sport sport = new Sport(id, name, participants);
                return sport;
            }
            return null;

        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Sport> findByName(String Name){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        String requete = "SELECT * FROM sport WHERE name LIKE ? ORDER BY name;";
        try{
            PreparedStatement myStatement = database.preparedStatement(requete);
            myStatement.setString(1, "%" + Name + "%");
            ResultSet results = myStatement.executeQuery();

            while(results.next())
            {
                final int id = results.getInt("id");
                final String name = results.getString("name");
                final int participants = results.getInt("required_participants");

                Sport sport = new Sport(id, name, participants);
                sports.add(sport);
            }
            return sports;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    

    /*public ArrayList<Sport> findByName(String Name){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        String query = "SELECT * FROM sport WHERE name LIKE ? ORDER BY name;";
        Statement myStatement = database.createStatement();
        try{
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport WHERE name LIKE '%"+Name+"%' ORDER BY name;");

            while(results.next())
            {
                final int id = results.getInt("id");
                final String name = results.getString("name");
                final int participants = results.getInt("required_participants");

                Sport sport = new Sport(id, name, participants);
                sports.add(sport);
            }
            return sports;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    */
}
