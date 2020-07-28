import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrintJerkTest
{
    PrintJerk printJerk;
    @Before
    public void initialize()
    {
        printJerk = new PrintJerk();
    }
    @Test
    public void createAppleFromString()
    {
       Food expected = new Food("apple",2.4);
       Food actual  = printJerk.createFoodFromString("food:apple;price:2.4");

        Assert.assertEquals(expected.getFoodName(),actual.getFoodName());
        Assert.assertEquals(expected.getFoodPrice(),actual.getFoodPrice());

    }
}