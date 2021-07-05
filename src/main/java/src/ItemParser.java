package src;

import org.apache.commons.io.IOUtils;

import java.util.*;
import java.util.logging.Logger;

public class ItemParser {

    private int numExceptions = 0;
    private TreeMap<String, Integer> occurrences = new TreeMap<>();
    private HashMap<String, TreeMap<Double, Integer>> prices = new HashMap<>();
    private static final Logger myLogger = Logger.getLogger("src.app");
    private static ItemDetail detail = new ItemDetail();
    private static ItemParser parser = new ItemParser();
    private static IndexOfDifferentItems indexes = new IndexOfDifferentItems();

    public static void main(String[] args) throws Exception{
        List<Item> listOfItems = new ArrayList<Item>();

        String output = parser.readRawDataToString();
        String[] linesOfOutput = parser.formatStringAndPutIntoLines(output);
        parser.createGroceryList(linesOfOutput, listOfItems);

        myLogger.info(parser.endResults());
    }

    public void createGroceryList(String[] linesOfOutput, List<Item> listOfItems) {
        for(String item: linesOfOutput) {
            indexes.populateIndexes(item);

            parser.populateDetail(item);
            parser.occurrences.merge(detail.name, 1, Integer::sum);

            parser.setPriceOccurrenceOfItem(detail.name, detail.price);

            Item groceryItem = new Item(detail);
            listOfItems.add(groceryItem);
        }
    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public void populateDetail(String item) {
        String potentialName = parser.getSpecificItem(item, indexes.getIndexOfName());
        detail.name =  parser.replaceMisspellingInCookies(potentialName);;
        String priceString = parser.getSpecificItem(item, indexes.getIndexOfPrice());
        detail.price = parser.setPrice(priceString);
        detail.type = parser.getSpecificItem(item, indexes.getIndexOfType());
        detail.expirationDate = parser.getSpecificItem(item, indexes.getIndexOfExpiration());
    }

    //cookies seemed to be the only different word
    private String replaceMisspellingInCookies(String potentialName) {
        if(potentialName.length() > 0 && potentialName.substring(0, 1).equals("c")) {
            potentialName = potentialName.replaceAll("0", "o");
        }
        return potentialName;
    }

    public void setPriceOccurrenceOfItem(String itemName, double price) {
        String noName = "";
        if(!itemName.equals(noName)) {
            if(!prices.containsKey(itemName)) {
                //price is sorted in descending order
                prices.put(itemName, new TreeMap<Double, Integer>(Collections.reverseOrder()));
            }
            prices.get(itemName).merge(price, 1, Integer::sum);
        }
    }

    public String getSpecificItem(String item, int indexOfDetail) {
        int endIndexOfDetail = item.indexOf(':', indexOfDetail);
        int endOfLine = -1;
        String specificItem = endIndexOfDetail != endOfLine ? populateString(item, indexOfDetail, endIndexOfDetail) : item.substring(indexOfDetail);
        numExceptions = specificItem.equals("") ? numExceptions++ : numExceptions;
        return specificItem;
    }

    private String populateString(String item, int indexOfDetail, int endIndexOfDetail) {
        String potentialItem = item.substring(indexOfDetail, endIndexOfDetail);
        switch(potentialItem) {
            case "name":
            case "price":
            case "type":
            case "expiration":
                return "";
            default:
                return potentialItem;
        }
    }


    public String [] formatStringAndPutIntoLines(String output) {
        output = output.toLowerCase();
        output = output.replaceAll("[:!;@^*%][^a-z0-9]?", ":");
        return output.split("##");
    }


    public double setPrice(String price) {
        return price.equals("") ? 0.0 : Double.parseDouble(price);
    }

    public String endResults() {
        StringBuilder result = new StringBuilder();
        occurrences.forEach((grocery, numTimesOfGrocery) -> {
            if(!grocery.equals("")) {
                appendResults(grocery, result, numTimesOfGrocery);
            }
            result.append("\n");
        });
        result.append("Number of exceptions is: " + numExceptions);
        return result.toString();
    }

    private void appendResults(String grocery, StringBuilder result, int numTimesOfGrocery) {
        grocery = Character.toUpperCase(grocery.charAt(0)) + grocery.substring(1);
        result.append(grocery + " occurred " + numTimesOfGrocery + " times.\n");
        result.append("==========================\n");
        grocery = grocery.toLowerCase();
        prices.get(grocery).forEach((groceryPrice, numOccurencesOfPrice) -> {
            if(groceryPrice != 0.0) {
                result.append("Price: " + groceryPrice + " seen: " + numOccurencesOfPrice + " times.\n");
                result.append("--------------------------\n");
            }
        });
    }

    public HashMap<String, TreeMap<Double, Integer>> getPrices() {
        return this.prices;
    }
}
