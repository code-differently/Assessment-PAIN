import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GroceryTest {

    Grocery groList;

    @Before
    public void setUp() {
        this.groList = new Grocery();
    }

    @Test
    public void setName() {
        // Arrange
        String expected = "Milk";
        // Act
        groList.setName("Milk");
        String actual = groList.getName();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void setPrice() {
        // Arrange
        Double expected = 6.6;
        // Act
        groList.setPrice(6.6);
        Double actual = groList.getPrice();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void setType() {
        // Arrange
        String expected = "Food";
        // Act
        groList.setType("Food");
        String actual = groList.getType();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void setExpiration() {
        // Arrange
        String expected = "2019-04-04";
        // Act
        groList.setName("2019-04-04");
        String actual = groList.getExpiration();

        // Assert
        assertEquals(expected, actual);
    }

}
