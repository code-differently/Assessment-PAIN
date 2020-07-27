import java.time.LocalDate;

public class Item {

    private String name;
    private double price;
    private String type;
    private LocalDate expiration;

    public Item(String name, double price, String type, LocalDate expiration) {
        this.setName(name);
        this.setPrice(price);
        this.setType(type);
        this.setExpiration(expiration);
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

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public String[] getLine(String nextLine){
        String[] line = nextLine.split(" "); //split words into a string array
        return line; //string array
    }
}
