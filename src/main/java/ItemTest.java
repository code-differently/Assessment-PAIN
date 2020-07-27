import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void setName(){
        // Given
        Item anItem = new Item();
        String expected = "Milk";

        // When
        anItem.setName("Milk");
        String actual = anItem.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPrice(){
        // Given
        Item anItem = new Item();
        String expected = "3.05";

        // When
        anItem.setPrice("3.05");
        String actual = anItem.getPrice();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setType(){
        // Given
        Item anItem = new Item();
        String expected = "Food";

        // When
        anItem.setType("Food");
        String actual = anItem.getType();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExpirationDate(){
        // Given
        Item anItem = new Item();
        String expected = "2/20/2020";

        // When
        anItem.setExpirationDate("2/20/2020");
        String actual = anItem.getExpirationDate();

        // Then
        Assert.assertEquals(expected, actual);
    }
}


