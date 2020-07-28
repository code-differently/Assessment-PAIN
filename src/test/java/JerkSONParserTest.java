import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JerkSONParserTest {

    @Test
    public void constructorTest() {
        // Given
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

        // When
        JerkSONParser jsp = new JerkSONParser(expected);
        String actual = jsp.getInput();
        String[] actualArray = jsp.getInputObjectStrings();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", actualArray[0]);
    }

    JerkSONParser jsp;
    @Before
    public void initialize() {
        jsp = new JerkSONParser("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##");
    }

    @Test
    public void getInputTest() {
        // Given
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

        // When
        String actual = jsp.getInput();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setInputTest() {
        // Given
        String expected = "naMe:cookies;price:1.23;type:Food;expiration:7/25/2016##";

        // When
        jsp.setInput(expected);
        String actual = jsp.getInput();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getInputObjectsTest() {
        // Given
        String[] expected = {"naMe:cookies;price:1.23;type:Food;expiration:7/25/2016", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016"};

        // When
        jsp.setInput("naMe:cookies;price:1.23;type:Food;expiration:7/25/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        String[] actual = jsp.getInputObjectStrings();

        // Then
        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
    }

    @Test
    public void getNameTest() {
        // Given
        String expected = "naMe:Milk";

        // When
        String actual = jsp.getName("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        // Given
        String expected = "price:3.23";

        // When
        String actual = jsp.getPrice("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        // Given
        String expected = "type:Food";

        // When
        String actual = jsp.getType("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExpTest() {
        // Given
        String expected = "expiration:1/25/2016";

        // When
        String actual = jsp.getExpDate("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void buildItemTest() {
        // Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedName = "Milk";
        String expectedPrice = "3.23";
        String expectedType = "Food";
        String expectedExp = "1/25/2016";

        // When
        Item newItem = jsp.buildItem(input);
        String actualName = newItem.getName();
        String actualPrice = newItem.getPrice();
        String actualType = newItem.getType();
        String actualExp = newItem.getExpiration();

        // Then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(expectedExp, actualExp);
    }

    @Test
    public void makeInputObjectsTest() {
        // Given
        String expected = "{cookies=1, Milk=1}";
        jsp.setInput("naMe:cookies;price:1.23;type:Food;expiration:7/25/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");

        // When
        jsp.makeInputObjects();
        String actual = jsp.getInputObjectOccurs().toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getErrorsTest() {
        // Given
        int expected = 1;
        jsp.setInput("naMe:;price:3.23;type:Food;expiration:1/25/2016");
        jsp.makeInputObjects();

        // When
        int actual = jsp.getErrors();

        // Then
        Assert.assertEquals(expected, actual);
    }

    /*@Test
    public void getOutputTest() {
        // Given
        String exepcted = "name:    Milk \t\t seen: 6 times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: 5 times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: 1 time\n" +
                "\n" +
                "name:   Bread\t\t seen: 6 times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: 6 times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name: Cookies     \t seen: 8 times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: 8 times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:  Apples     \t seen: 4 times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: 2 times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: 2 times\n" +
                "\n" +
                "Errors         \t \t seen: 4 times\n";

        // When
        String actual = jsp.getOutput();

        // Then
        Assert.assertEquals(exepcted, actual);
    } */
}
