import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroceryParserTest {
    GroceryParser gp;

    @Before
    public void initialize(){
        gp = new GroceryParser();
    }

    @Test
    public void getNameParsTest(){
        String actual = gp.getNamePars("Name:Milk");
        String expected = "Milk";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceParsTest(){
        String actual = gp.getPricePars("Price:3.23");
        String expected = "3.23";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeParsTest(){
        String actual = gp.getTypePars("Type:Food");
        String expected = "Food";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExpirationParsTest(){
        String actual = gp.getExpirationPars("Expiration:9/25/2020");
        String expected = "9/25/2020";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseDataTest(){
        gp.parseData("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
        "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
        "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");

        int actual = gp.getGroceries().size();
        int expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameOccTest(){
        gp.parseData("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");

        int actual = gp.getNameOcc("bread");
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceOccTest(){
        gp.parseData("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");

        int actual = gp.getPriceOcc("bread", "1.23");
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    /*@Test
    public void printGroceriesTest(){
        gp.parseData("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##" +
                "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##");

        String actual = gp.printGroceries();
        String expected = "MilkBread";

        Assert.assertEquals(expected, actual);
    }*/
}