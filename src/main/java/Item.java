//import java.util.HashMap;

public class Item {

    private final String name;
    private final String price;
    private final String type;
    private final String expiration;

    public Item(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getExpiration() {
        return expiration;
    }

    /*public void addPriceOccurrence(double price) {
        if(!priceOccurrences.containsKey(price))
            priceOccurrences.put(price, 1);
        else
            priceOccurrences.replace(price, priceOccurrences.get(price) + 1);
    }

    public HashMap<Double, Integer> getPriceOccurrences() {
        return priceOccurrences;
    } */
}
