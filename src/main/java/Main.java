import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.*;

public class Main {
    static int origSize = 0;
    static int newSize = 0;
    static Map<String, Map<String, Integer>> products = new LinkedHashMap<>();


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        ArrayList<String> goodInput = removeBad(formatInfo(output));
        trustTheProcess(goodInput);
        forTheWin();
    }

    // formats the string into an array list
    public static ArrayList<String> formatInfo(String str) {
        // Removes special characters besides #, . and /
        str = str.replaceAll("[^0-9a-zA-Z-#./]+", " ");
        // changes to lower case
        str = str.toLowerCase();
        // puts them into an array separated by ##, the indicator in JerkSON
        ArrayList<String> all = new ArrayList<>(Arrays.asList(str.split("##")));
        for (int i = 0; i < all.size(); i++) {
            // removes "name" out of each element so the first element will actually be the name.
            all.set(i, all.get(i).substring(5));
        }
        // used for calculating error count
        origSize = all.size();
        return all;
    }

    // removes bad elements
    public static ArrayList<String> removeBad(ArrayList<String> arrL) {
        for (int i = 0; i < arrL.size(); i++) {
            // turns each element into a string array, separating them by spaces
            // serves as categories that can easily differentiate name, price, etc
            String[] checkCategories = arrL.get(i).split(" ");
            // if the first category is not an actual name of the product
            if (checkCategories[0].equals("price")) {
                arrL.remove(i);
                // if the third category does not have a number, but instead says "type"
            } else if (checkCategories[2].equals("type")) {
                arrL.remove(i);
            }

        }
        // used to calculating error count
        newSize = arrL.size();
        return arrL;
    }

    // puts the good information into the LinkedHashMap
    public static void trustTheProcess(ArrayList<String> arrL) {
        for (String s : arrL) {
            // splits the list into the categories
            String[] categories = s.split(" ");
            // the c00kie checker
            categories[0] = categories[0].replace('0', 'o');
            // storing into map logic
            if (products.containsKey(categories[0])) {
            } else {
                products.put(categories[0], new LinkedHashMap<String, Integer>());
            }
            if (products.get(categories[0]).containsKey(categories[2])){
                products.get(categories[0]).put(categories[2], products.get(categories[0]).get(categories[2]) + 1);
            } else {
                products.get(categories[0]).put(categories[2], 1);
            }
        }
    }

    // Formats the output for the information
    public static void forTheWin() {
        String separator = "=============";
        String separator2 = "-------------";
        for (Map.Entry<String, Map<String, Integer>> entry : products.entrySet()) {
            int seenCount = 0;
            System.out.print("name: \t" + entry.getKey());
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                seenCount += entry2.getValue();
            }
            System.out.println("\t\tseen: " + seenCount + " times");
            System.out.println(separator + "\t\t" + separator);
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                System.out.println("Price:\t" + entry2.getKey() + "\t\tSeen: " + entry2.getValue() + " times");
                System.out.println(separator2 + "\t\t" + separator2);
            }
            System.out.println();
        }
        System.out.println("Errors:\t\t\t\t" + "seen: " + (origSize - newSize));
    }

}
