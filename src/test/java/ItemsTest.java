
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemsTest {

    String name;
    double price;
    String type;
    String expDate;

    Item item;

    @Before
    public void setUp(){

        item = new Item(name, price, type, expDate);
    }
    @Test
    public void milkTest(){
        //Given
        String expected = milk, price, expDate;
        //When

        //Then
        String actual = item.getItem(expected);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void BreadTest(){
        //Given
        String expected = bread, price, expDate;

        //When

        //Then
        String actual = item.getItem(expected);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void cookiesTest(){
        //Given
        String expected = cookies, price, expDate;
        //When

        //Then
        String actual = item.getItem(expected);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void applesTest(){
        //Given
        String expected = apples, price, expDate;
        //When

        //Then
        String actual = item.getItem(expected);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void errorsTest(){
        //Given
        Integer error = 4;
        Integer expected = error;
        //When

        //Then
        Assert.assertEquals();
    }
}

