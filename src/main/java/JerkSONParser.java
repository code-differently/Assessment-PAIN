import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {

    private String input;
    private String[] inputObjectStrings;
    private final Map<String, Integer> inputObjectOccurs = new HashMap<>();
    private final List<Item> inputObjects = new ArrayList<>();
    private int errors = 0;

    public JerkSONParser(String input) {
        this.input = input;
        inputObjectStrings = input.split("##");
    }

    public String getInput() {
        return input;
    }

    public void setInput(String newInput) {
        input = newInput;
        inputObjectStrings = input.split("##");
    }

    public String[] getInputObjectStrings() {
        return inputObjectStrings;
    }

    public String getName(String input) {
        Pattern namePattern = Pattern.compile("name:\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = namePattern.matcher(input);
        if(matcher.find())
            return matcher.group();
        return null;
    }

    public String getPrice(String input) {
        Pattern pricePattern = Pattern.compile("price:\\d+.\\d+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pricePattern.matcher(input);
        if(matcher.find())
            return matcher.group();
        return null;
    }

    public String getType(String input) {
        Pattern typePattern = Pattern.compile("type:\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = typePattern.matcher(input);
        if(matcher.find())
            return matcher.group();
        return null;
    }

    public String getExpDate(String input) {
        Pattern expPattern = Pattern.compile("expiration:\\w+/\\w+/\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = expPattern.matcher(input);
        if(matcher.find())
            return matcher.group();
        return null;
    }

    public Item buildItem(String input){
        String name;
        String price;
        String type;
        String expDate;
        try {
            name = getName(input).substring(5);
            price = getPrice(input).substring(6);
            type = getType(input).substring(5);
            expDate = getExpDate(input).substring(11);
        } catch(NullPointerException e) {
            errors++;
            return null;
        }
        return new Item(name, price, type, expDate);
    }

    public void makeInputObjects() {
        for (String inputObjectString : inputObjectStrings) {
            Item newItem = buildItem(inputObjectString);
            String name = "";
            if(newItem != null) {
                if(newItem.getName().equalsIgnoreCase("co0kies")) {
                    name = "Cookies";
                } else {
                    name = Character.toUpperCase(newItem.getName().charAt(0)) + newItem.getName().substring(1).toLowerCase();
                }
            }
            if (newItem != null && !inputObjectOccurs.containsKey(name)) {
                inputObjectOccurs.put(name, 1);
                inputObjects.add(newItem);
            } else if(newItem != null) {
                inputObjectOccurs.replace(name, inputObjectOccurs.get(name) + 1);
                inputObjects.add(newItem);
            }
        }
    }

    public Map<String, Integer> getInputObjectOccurs() {
        return inputObjectOccurs;
    }

    public List<Item> getInputObjects() {
        return inputObjects;
    }

    public int getErrors() {
        return errors;
    }

    public String getOutput() {
        StringBuilder ret = new StringBuilder();
        for(Map.Entry<String, Integer> entry : inputObjectOccurs.entrySet()) {
            ret.append(String.format("%-20s %-10s", "\nname: " + entry.getKey(), "seen: " + entry.getValue() + " times\n"));
            ret.append(String.format("%-19s %-10s", "=============", "=============\n"));
        }
        ret.append("\nErrors\t\t\t\tseen: ").append(errors).append(" times");
        return ret.toString().trim();
    }

    /*private final String input;
    private String[] entries;
    private final ArrayList<String[]> namePrice = new ArrayList<>();
    private int numOfExceptions;
    private final HashMap<String, Integer> foodOccurrences = new HashMap<>();
    private final HashSet<Food> foodContained = new HashSet<>();

    public JerkSONParser(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void parseInputForEntries() {
        entries = input.split("##");
    }

    public String[] getEntries() {
        return entries;
    }

    public void parseEntriesForNamePrice() {
        for(String current : entries) {
            String[] currentEntry = current.split("[;@^*%!]");
            namePrice.add(currentEntry);
        }
    }

    public ArrayList<String[]> getNamePrice() {
        return namePrice;
    }

    public void countExceptions() throws NoKeyOrValueException {
        for (String[] current : namePrice) {
            for (String s : current) {
                String[] keyValue = s.split(":");
                if(keyValue.length != 2) {
                    numOfExceptions++;
                }
            }
        }
    }

    public void countOccurrencesOfFood() {
        for (int i = 0; i < namePrice.size(); i++) {
            String[] current = namePrice.get(i);
            String[] foodValue = current[0].split(":");
            String[] priceValue = current[1].split(":");
            if(foodValue.length == 2 && priceValue.length == 2) {
                String food = foodValue[1].toLowerCase();
                if(!foodOccurrences.containsKey(food))
                    foodOccurrences.put(food, 1);
                else
                    foodOccurrences.replace(food, foodOccurrences.get(food) + 1);
            }
        }
    }

    public void createFood() {
        for(Map.Entry<String, Integer> entry : foodOccurrences.entrySet()) {
            Food food = new Food(entry.getKey());
            foodContained.add(food);
        }
    }

    public void countPriceOccurrences() {
        for (int i = 0; i < namePrice.size(); i++) {
            String[] current = namePrice.get(i);
            String[] foodValue = current[0].split(":");
            String[] priceValue = current[1].split(":");
            if(foodValue.length == 2 && priceValue.length == 2) {
                for(Food food : foodContained) {
                    if(food.getName().equalsIgnoreCase(foodValue[1])) {
                        double price = Double.parseDouble(priceValue[1]);
                        food.addPriceOccurrence(price);
                        System.out.println(food.getName() + ": " + price);
                    }
                }
            }
        }
    }

    public String getOutput() {
        StringBuilder ret = new StringBuilder();
        for(Food current : foodContained) {
            String name = current.getName().substring(0,1).toUpperCase() + current.getName().substring(1);
            ret.append(String.format("%-20s %-10s", "\nname: " + name, "seen: " + foodOccurrences.get(current.getName()) + " times\n"));
            ret.append(String.format("%-19s %-10s", "=============", "=============\n"));
            for(Map.Entry<Double, Integer> entry : current.getPriceOccurrences().entrySet()) {
                ret.append(String.format("%-19s %-10s", "Price: " + entry.getKey(), "seen: " + entry.getValue() + " times\n"));
                if (current.getPriceOccurrences().size() > 1) {
                    ret.append("-------------\n");
                }
            }
        }
        ret.append("\nErrors\t\t\t\tseen: ").append(numOfExceptions).append(" times");
        return ret.toString().trim();
    }
    */
}
