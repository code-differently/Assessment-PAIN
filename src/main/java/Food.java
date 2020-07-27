import java.util.HashMap;

public class Food {

    private final String name;
    private final HashMap<Double, Integer> priceOccurrences = new HashMap<>();

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPriceOccurrence(double price) {
        if(!priceOccurrences.containsKey(price))
            priceOccurrences.put(price, 1);
        else
            priceOccurrences.replace(price, priceOccurrences.get(price) + 1);
    }
}
