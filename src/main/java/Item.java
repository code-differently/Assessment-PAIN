import java.time.LocalDate;

public class Item {

    private String name;
    private double price;
    private String food;
    private LocalDate expeiration;

    public Item(String name, double price, String food, LocalDate expeiration) {
        this.name = name;
        this.price = price;
        this.food = food;
        this.expeiration = expeiration;
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public LocalDate getExpeiration() {
        return expeiration;
    }

    public void setExpeiration(LocalDate expeiration) {
        this.expeiration = expeiration;
    }
}
