package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.ItemParser;

import java.util.Collections;
import java.util.TreeMap;

public class ItemParserTest {
    private ItemParser itemParser;
    private final double DELTA = 0.0;

    @Before
    public void setup() {
        itemParser = new ItemParser();
    }

    @Test
    public void getSpecificItemTest() {
        String expected = "mac-and-cheese";
        String lineOfText = "name:mac-and-cheese:";

        String actual = itemParser.getSpecificItem(lineOfText, 5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void formatStringAndPutIntoLinesTest() {
        String expectedLineOne = "name:milk:price:3.23:type:food:expiration:1/25/2016";
        String expectedLineTwo = "name:bread:price:1.23:type:food:expiration:1/02/2016";

        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        String [] actualLines = itemParser.formatStringAndPutIntoLines(input);

        Assert.assertEquals(expectedLineOne, actualLines[0]);
        Assert.assertEquals(expectedLineTwo, actualLines[1]);
    }



    @Test
    public void setPriceWithNothingTest() {
        double expectedPrice = 0.0;

        String input = "";
        double actualPrice = itemParser.setPrice(input);

        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void setPriceWithRealPriceTest() {
        double expectedPrice = 12.5;

        String input = "12.5";
        double actualPrice = itemParser.setPrice(input);

        Assert.assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void endResultsTest() {
        String expected = "Number of exceptions is: 0";

        String actual = itemParser.endResults();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPriceOccurrenceOfItem() {
        int expectedOccurrences = 1;

        itemParser.getPrices().put("apples", new TreeMap<Double, Integer>(Collections.reverseOrder()));
        itemParser.setPriceOccurrenceOfItem("apples", 13.5);
        int actualOccurrences = itemParser.getPrices().get("apples").get(13.5);

        Assert.assertEquals(expectedOccurrences, actualOccurrences);
    }
}
