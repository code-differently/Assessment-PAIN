
import java.util.ArrayList;

public class Parser 
{
    public ArrayList < String > parseRawData(String rawData)
    {
        String pattern = "##";
        ArrayList < String > result = parseString( pattern , rawData );
        return result;
    }

    private ArrayList < String > parseString(String pattern, String rawData)
    {
        return null;
    }

}