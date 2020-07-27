public class foodItem
{
    private String name;
    private double price;
    private String type;
    private String expDate;


    public foodItem(String name, double price, String type, String expDate){
        this.name = name;
        this.price = price;
        this.type = type;
        this.expDate = expDate;
    }

    //Getters
    public String getName()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getType()
    {
        return this.type;
    }

    public String getExpDate()
    {
        return this.name;
    }

    @Override
    public String toString(){
        return "name:" + name + " price:" + price + " type:" + type + " expDate:" + expDate;
    }

}