import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    @Test
    public void constructorTest() {
        // Given
        String expectedName = "Milk";
        String expectedPrice = "1.25";
        String expectedType = "Food";
        String expectedExp = "1/25/2019";

        // When
        Item myItem = new Item(expectedName, expectedPrice, expectedType, expectedExp);
        String actualName = myItem.getName();
        String actualPrice = myItem.getPrice();
        String actualType = myItem.getType();
        String actualExp = myItem.getExpiration();

        // Then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(expectedExp, actualExp);
    }

    Item myItem;
    @Before
    public void initialize() {
        myItem = new Item("Milk", "1.25", "Food", "1/25/2019");
    }

    @Test
    public void getNameTest() {
        // Given
        String expected = "Milk";

        // When
        String actual = myItem.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        // Given
        String expected = "1.25";

        // When
        String actual = myItem.getPrice();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        // Given
        String expected = "Food";

        // When
        String actual = myItem.getType();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExpTest() {
        // Given
        String expected = "1/25/2019";

        // When
        String actual = myItem.getExpiration();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
