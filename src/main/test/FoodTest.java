import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FoodTest
{
    Food food;
    @Before
    public void intialize()
    {
      food = new Food("Applin",2.1);
    }

    @Test
    public void nameTest()
    {
        String expected = "Applin";

       Assert.assertEquals(expected,food.getFoodName());
    }

    @Test
    public void priceTest()
    {
        Double expected = 2.1;

        Assert.assertEquals(expected,food.getFoodPrice());
    }
}
