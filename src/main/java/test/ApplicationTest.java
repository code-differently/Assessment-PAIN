package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.App.Application;

public class ApplicationTest {
    private Application application;
    private final double DELTA = 0.0;

    @Before
    public void setup() {
        application = new Application();
    }

    @Test
    public void getSpecificItemTest() {
        String expected = "mac-and-cheese";
        String lineOfText = "name:mac-and-cheese:";

        String actual = application.getSpecificItem(lineOfText, 5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSpecificItemParsingError() {
        String expected = "";
        String individualLine = "name:bread:price:type:food:expiration:1/02/2016";

        int index = application.calculateIndex(individualLine, "price:");
        String actual = application.getSpecificItem(individualLine, index);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void formatStringAndPutIntoLinesTest() {
        String expectedLineOne = "name:milk:price:3.23:type:food:expiration:1/25/2016";
        String expectedLineTwo = "name:bread:price:1.23:type:food:expiration:1/02/2016";

        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        String [] actualLines = application.formatStringAndPutIntoLines(input);

        Assert.assertEquals(expectedLineOne, actualLines[0]);
        Assert.assertEquals(expectedLineTwo, actualLines[1]);
    }

    @Test
    public void calculateIndexTest() {
        int expectedIndexOfTheWordFood = 27;
        String individualLine = "name:bread:price:1.23:type:food:expiration:1/02/2016";

        int actualIndexOfTheWordFood = application.calculateIndex(individualLine, "type:");

        Assert.assertEquals(expectedIndexOfTheWordFood, actualIndexOfTheWordFood);
    }

    @Test
    public void setPriceWithNothingTest() {
        double expectedPrice = 0.0;

        String input = "";
        double actualPrice = application.setPrice(input);

        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void setPriceWithRealPriceTest() {
        double expectedPrice = 12.5;

        String input = "12.5";
        double actualPrice = application.setPrice(input);

        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void endResultsTest() {
        String expected = "Number of exceptions is: 0";

        String actual = application.endResults();

        Assert.assertEquals(expected, actual);
    }
}
