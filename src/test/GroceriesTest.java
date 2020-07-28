import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroceriesTest {
    Groceries g;

    @Before
    public void initialize(){
        g = new Groceries();
    }   

    @Test
    public void setNameTest(){
        g.setName("Apples");

        String actual = g.getName();
        String expected = "Apples";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPriceTest(){
        g.setPrice("3.23");

        String actual = g.getPrice();
        String expected = "3.23";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTypeTest(){
        g.setType("Food");

        String actual = g.getType();
        String expected = "Food";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExpirationTest(){
        g.setExpiration("9/25/2020");

        String actual = g.getExpiration();
        String expected = "9/25/2020";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest(){
        String actual = g.getName();
        String expected = "";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest(){
        String actual = g.getPrice();
        String expected = "0.00";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest(){
        String actual = g.getType();
        String expected = "";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExpirationTest(){
        String actual = g.getExpiration();
        String expected = "";

        Assert.assertEquals(expected, actual);
    }
}