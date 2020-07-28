package src;

import org.apache.commons.io.IOUtils;

import java.util.*;
import java.util.logging.Logger;

public class ItemParser {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    private int numExceptions = 0;
    private TreeMap<String, Integer> occurrences = new TreeMap<>();
    private HashMap<String, TreeMap<Double, Integer>> prices = new HashMap<>();
    private static final Logger myLogger = Logger.getLogger("src.app");

    public static void main(String[] args) throws Exception{
        List<Item> listOfItems = new ArrayList<Item>();
        String name = "name:";
        String price = "price:";
        String type = "type:";
        String expiration = "expiration:";

        ItemParser parser = new ItemParser();

        String output = parser.readRawDataToString();

        String[] linesOfOutput = parser.formatStringAndPutIntoLines(output);

        for(String item: linesOfOutput) {
            int indexOfName = parser.calculateIndex(item, name);
            int indexOfPrice = parser.calculateIndex(item, price);
            int indexOfType = parser.calculateIndex(item, type);
            int indexOfExpiration = parser.calculateIndex(item, expiration);

            ItemDetail detail = new ItemDetail();
            String potentialName = parser.getSpecificItem(item, indexOfName);
            //cookies seemed to be the only different word
            if(potentialName.length() > 0 && potentialName.substring(0, 1).equals("c")) {
                potentialName = potentialName.replaceAll("0", "o");
            }
            parser.occurrences.merge(potentialName, 1, Integer::sum);
            detail.name = potentialName;
            String priceString = parser.getSpecificItem(item, indexOfPrice);
            detail.price = parser.setPrice(priceString);
            detail.type = parser.getSpecificItem(item, indexOfType);
            detail.expirationDate = parser.getSpecificItem(item, indexOfExpiration);

            parser.setPriceOccurrenceOfItem(potentialName, detail.price);

            Item groceryItem = new Item(detail);
            listOfItems.add(groceryItem);
        }

        myLogger.info(parser.endResults());
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
        String specificItem = "";
        boolean thereIsAValue = true;
        if(endIndexOfDetail != endOfLine) {
            String potentialWord = item.substring(indexOfDetail, endIndexOfDetail);
            switch(potentialWord) {
                case "name":
                case "price":
                case "type":
                case "expiration":
                    thereIsAValue = false;
                    break;
                default:
                    specificItem = item.substring(indexOfDetail, endIndexOfDetail);
                    break;
            }
        }
        //there is a value and it is at the end of the line
        else if(thereIsAValue){
            specificItem = item.substring(indexOfDetail);
        }
        //specific item was not populated
        if(specificItem.equals("")) {
            numExceptions++;
        }
        return specificItem;
    }

    public String [] formatStringAndPutIntoLines(String output) {
        output = output.toLowerCase();
        output = output.replaceAll("[:!;@^*%][^a-z0-9]?", ":");
        return output.split("##");
    }

    public int calculateIndex(String individualLine, String whatToLookFor) {
        return individualLine.indexOf(whatToLookFor) + whatToLookFor.length();
    }

    public double setPrice(String price) {
        if(price.equals("")) {
            return 0.0;
        }
        else {
            return Double.parseDouble(price);
        }
    }

    public String endResults() {
        StringBuilder result = new StringBuilder();
        occurrences.forEach((grocery, numTimesOfGrocery) -> {
            switch(grocery) {
                case "":
                    break;
                default:
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
            result.append("\n");
        });
        result.append("Number of exceptions is: " + numExceptions);
        return result.toString();
    }

    public HashMap<String, TreeMap<Double, Integer>> getPrices() {
        return this.prices;
    }
}
