package src.Item;

public class Item {
    private String name;
    private double price;
    private String type;
    private String expirationDate;

    public Item(ItemDetail detail) {
        name = detail.name;
        price = detail.price;
        type = detail.type;
        expirationDate = detail.expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String toString() {
        return "name: " + getName() + " price: " + getPrice() + " type: " + getType() + " date: " + getExpirationDate();
    }
}
