public class Items {
    
    private String name;
    private double price;
    private String type;
    private String expDate;

    public Items(String name, double price, String type, String expDate) {
    }

    public void items(String name, double price, String type, String expDate) {
        this.setName(name);
        this.setPrice(price);
        this.setType(type);
        this.setExpDate(expDate);
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

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
