public class Groceries {
    private String name;
    private String price;
    private String type;
    private String expiration;

    public Groceries(){
        name = "";
        price = "0.00";
        type = "";
        expiration = "";    
    }

    public Groceries(String name, String price, String type, String expiration){
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setExpiration(String expiration){
        this.expiration = expiration;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public String getType(){
        return type;
    }

    public String getExpiration(){
        return expiration;
    }
}