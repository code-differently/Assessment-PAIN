import java.util.*;

public class JerkSONParser {

    private final String input;
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
                String food = foodValue[1].toLowerCase();
                if(!foodOccurrences.containsKey(food))
                    foodOccurrences.put(food, 1);
                else
                    foodOccurrences.replace(food, foodOccurrences.get(food) + 1);
            }
        }
    }

    public String getOutput() {
        StringBuilder ret = new StringBuilder();
        for(Food current : foodContained) {
            String name = current.getName().substring(0,1).toUpperCase() + current.getName().substring(1);
            ret.append("name: ").append(name).append("\t\t\t");
            ret.append("seen: ").append(foodOccurrences.get(current.getName())).append(" times\n");
        }
        ret.append("\nErrors\t\t\tseen: ").append(numOfExceptions).append(" times");
        return ret.toString().trim();
    }

}
