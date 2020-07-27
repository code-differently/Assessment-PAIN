import java.util.HashMap;
import java.util.Map;

public class JerkSON {

     static String cleanData(String input) {
        String formatted = input.replaceAll("##","/n");
         formatted=formatted.replaceAll("[;^]",",");
         formatted=formatted.replaceAll("[^\\w\\n,./:]",":");
         formatted=formatted.replaceAll("[:]expiration",",expiration");
         return formatted;
    }

     static String getOccurences(String cleanOutput) {
    
}
