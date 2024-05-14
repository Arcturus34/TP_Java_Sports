import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        PolySportsDatabase Data = PolySportsDatabase.getInstance();
        Data.connect();
        SportsDAO sport = new SportsDAO(Data);
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        ArrayList<Sport> sports = sport.findByName(input);
        for(int i = 0; i < sports.size(); i++){
            System.out.println(sports.get(i).getName()+" : "+sports.get(i).getRequiredParticipants());
        }
    }
}
