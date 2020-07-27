package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.Item.Item;
import src.Item.ItemDetail;

public class ItemTest {
    private Item item;
    private ItemDetail detail;
    private final double DELTA = 0.0;

    @Before
    public void setup() {
        detail = new ItemDetail();
        item = new Item(detail);
    }

    @Test
    public void constructorTest() {
        String expected = "name: nothing price: 0.0 type: no type date: 0/00/0000";

        String actual = item.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        String expected = "nothing";

        String actual = item.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        String expected = "Jam";

        item.setName("Jam");
        String actual = item.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        double expected = 0.0;

        double actual = item.getPrice();

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void setPriceTest() {
        double expected = 12.0;

        item.setPrice(12.0);
        double actual = item.getPrice();

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getTypeTest() {
        String expected = "no type";

        String actual = item.getType();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTypeTest() {
        String expected = "Drink";

        item.setType("Drink");
        String actual = item.getType();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDateTest() {
        String expected = "0/00/0000";

        String actual = item.getDate();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setDateTest() {
        String expected = "12/15/2015";

        item.setDate("12/15/2015");
        String actual = item.getDate();

        Assert.assertEquals(expected, actual);
    }
}
