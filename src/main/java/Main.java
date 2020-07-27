import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        String groceryList = output;
        Integer errorCount = 0;
        // Cleans out the grocery list
        groceryList = groceryList.toLowerCase();
        groceryList = groceryList.replaceAll(":", " ");
        groceryList = groceryList.replaceAll(";", " ");
        groceryList = groceryList.replaceAll("##", "");
        groceryList = groceryList.replaceAll("type", "");
        groceryList = groceryList.replaceAll("food", "");
        groceryList = groceryList.replaceAll("expiration", "");

        ArrayList<String> lst = new ArrayList<String>();

        String[] cleanerGroceryList = groceryList.split(" ");

        String priceCatcher = ".2";
        String milkCatcher = "m";
        String cookieCatcher = "co";
        String breadCatcher = "b";

        Map<String, String> myMap = new HashMap<String, String>();

        for (String item : cleanerGroceryList) {

            for (int i = 1; i < cleanerGroceryList.length-2; i++) {
                System.out.println("i = " + cleanerGroceryList[i]);

                System.out.println("i + 2 = " + cleanerGroceryList[i + 2]);
                if (item.startsWith(milkCatcher)){
                    if(cleanerGroceryList[i + 2].contains(priceCatcher)){
                        myMap.put(item, cleanerGroceryList[i + 2]);
                    }
                }
                if (item.startsWith(cookieCatcher)){
                    if (cleanerGroceryList[i + 2].contains(priceCatcher)){
                        myMap.put(item, cleanerGroceryList[i + 2]);
                    }
                }
                if (item.startsWith(breadCatcher)){
                    if (cleanerGroceryList[i + 2].contains(priceCatcher)){
                        myMap.put(item, cleanerGroceryList[i+2]);
                    }
                }

            }

        }

        System.out.println(myMap);
    }
}
