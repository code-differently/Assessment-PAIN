package src.App;

import org.apache.commons.io.IOUtils;
import src.Item.Item;
import src.Item.ItemDetail;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    private int numExceptions = 0;
    private TreeMap<String, Integer> occurrences = new TreeMap<>();
    private HashMap<String, TreeMap<Double, Integer>> prices = new HashMap<>();

    public static void main(String[] args) throws Exception{
        List<Item> listOfItems = new ArrayList<Item>();
        String name = "name:";
        String price = "price:";
        String type = "type:";
        String expiration = "expiration:";

        Application app = new Application();
        app.prices.put("apples", new TreeMap<Double, Integer>());
        app.prices.put("bread", new TreeMap<Double, Integer>());
        app.prices.put("cookies", new TreeMap<Double, Integer>());
        app.prices.put("milk", new TreeMap<Double, Integer>());

        String output = app.readRawDataToString();

        String[] linesOfOutput = app.formatStringAndPutIntoLines(output);

        for(String item: linesOfOutput) {
            int indexOfName = app.calculateIndex(item, name);
            int indexOfPrice = app.calculateIndex(item, price);
            int indexOfType = app.calculateIndex(item, type);
            int indexOfExpiration = app.calculateIndex(item, expiration);

            ItemDetail detail = new ItemDetail();
            String potentialName = app.getSpecificItem(item, indexOfName);
            if(potentialName.length() > 0 && potentialName.substring(0, 1).equals("c")) {
                potentialName = potentialName.replaceAll("0", "o");
            }
            detail.name = potentialName;
            app.occurrences.merge(potentialName, 1, Integer::sum);
            String priceString = app.getSpecificItem(item, indexOfPrice);
            detail.price = app.setPrice(priceString);
            detail.type = app.getSpecificItem(item, indexOfType);
            detail.expirationDate = app.getSpecificItem(item, indexOfExpiration);

            switch(potentialName) {
                case "apples":
                    app.prices.get("apples").merge(detail.price, 1, Integer::sum);
                    break;
                case "bread":
                    app.prices.get("bread").merge(detail.price, 1, Integer::sum);
                    break;
                case "cookies":
                    app.prices.get("cookies").merge(detail.price, 1, Integer::sum);
                    break;
                case "milk":
                    app.prices.get("milk").merge(detail.price, 1, Integer::sum);
                    break;
            }

            Item groceryItem = new Item(detail);
            listOfItems.add(groceryItem);
        }

//        for(Item item: listOfItems) {
//            System.out.println(item.toString());
//        }

        System.out.println(app.endResults());
    }

    public String getSpecificItem(String item, int indexOfDetail) {
        int endIndexOfDetail = item.indexOf(':', indexOfDetail);
        int endOfLine = -1;
        String specificItem = "";
        boolean doNotSkip = true;
        if(endIndexOfDetail != endOfLine) {
            String potentialWord = item.substring(indexOfDetail, endIndexOfDetail);
            switch(potentialWord) {
                case "name":
                case "price":
                case "type":
                case "expiration":
                    doNotSkip = false;
                    break;
                default:
                    specificItem = item.substring(indexOfDetail, endIndexOfDetail);
                    break;
            }
        }
        else if(doNotSkip){
            specificItem = item.substring(indexOfDetail);
        }
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
                    result.append("Nothing occured " + numTimesOfGrocery + " times.\n");
                    break;
                default:
                    grocery = Character.toUpperCase(grocery.charAt(0)) + grocery.substring(1);
                    result.append(grocery + " occured " + numTimesOfGrocery + " times.\n");
                    result.append("==========================\n");
                    grocery = grocery.toLowerCase();
                    prices.get(grocery).forEach((groceryPrice, numOccurancesOfPrice) -> {
                        if(groceryPrice != 0.0) {
                            result.append("Price: " + groceryPrice + " seen: " + numOccurancesOfPrice + " times.\n");
                            result.append("--------------------------\n");
                        }
                    });
            }
            result.append("\n");
        });
        result.append("Number of exceptions is: " + numExceptions);
        return result.toString();
    }
}
