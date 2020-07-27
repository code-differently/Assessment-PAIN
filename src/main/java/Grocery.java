import org.apache.commons.io.IOUtils;

import java.util.HashMap;
import java.util.Scanner;

public class Grocery {
    //naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##
    private String name="";
    private Double price =0.0;
    private String type="";
    private String  expiration="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    HashMap<String ,Object> output= new HashMap<String, Object>();

    public String DataToString() throws Exception{
        ClassLoader cLoader = getClass().getClassLoader();
        String result = IOUtils.toString(cLoader.getResourceAsStream("RawData.txt"));
        return result;
    }
    // replace each special char to new line easiear to read
    public String EasyRead(String inList){ return "";}

}
