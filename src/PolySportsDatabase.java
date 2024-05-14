public class PolySportsDatabase extends MYSQLDatabase {

    private static PolySportsDatabase instance;

    private PolySportsDatabase(){
        super("localhost", 3306, "poly_sports", "lilian", "esirem");
        instance = null;
    }

    public static PolySportsDatabase getInstance(){
        if(instance == null){
            instance = new PolySportsDatabase();
        }
        return instance;
    }

}
