package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.IndexOfDifferentItems;
import static org.junit.Assert.*;

public class IndexOfDifferentItemsTest {
    IndexOfDifferentItems indexOfDifferentItems;
    @Before
    public void setup() {
        indexOfDifferentItems = new IndexOfDifferentItems();
    }

    @Test
    public void getIndexOfNameTest() {
        int expected = 0;

        int actual = indexOfDifferentItems.getIndexOfName();

        assertEquals(expected, actual);
    }

    @Test
    public void setIndexOfNameTest() {
        int expected = 12;

        indexOfDifferentItems.setIndexOfName(12);
        int actual = indexOfDifferentItems.getIndexOfName();

        assertEquals(expected, actual);
    }

    @Test
    public void getIndexOfPriceTest() {
        int expected = 0;

        int actual = indexOfDifferentItems.getIndexOfPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void setIndexOfPriceTest() {
        int expected = 12;

        indexOfDifferentItems.setIndexOfPrice(12);
        int actual = indexOfDifferentItems.getIndexOfPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void getIndexOfTypeTest() {
        int expected = 0;

        int actual = indexOfDifferentItems.getIndexOfType();

        assertEquals(expected, actual);
    }

    @Test
    public void setIndexOfTypeTest() {
        int expected = 12;

        indexOfDifferentItems.setIndexOfType(12);
        int actual = indexOfDifferentItems.getIndexOfType();

        assertEquals(expected, actual);
    }

    @Test
    public void getIndexOfExpirationTest() {
        int expected = 0;

        int actual = indexOfDifferentItems.getIndexOfExpiration();

        assertEquals(expected, actual);
    }

    @Test
    public void setIndexOfExpirationTest() {
        int expected = 12;

        indexOfDifferentItems.setIndexOfExpiration(12);
        int actual = indexOfDifferentItems.getIndexOfExpiration();

        assertEquals(expected, actual);
    }

    @Test
    public void populateIndexesTest() {
        String expected = "5 18 29 45";

        indexOfDifferentItems.populateIndexes("name:peanut:price:12.50:type:food:expiration:12-21-2020");
        String actual = indexOfDifferentItems.toString();

        assertEquals(expected, actual);
    }
}
