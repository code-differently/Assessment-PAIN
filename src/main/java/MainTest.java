import org.junit.Assert;
import org.junit.Test;
public class MainTest {
    @Test
    public void nameTest() throws Exception {
        Main tester = new Main();
        int expected = 1;
        int actual = tester.readRawDataToStringForTestItem("MainTestDate.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void priceTest() throws Exception {
        Main tester = new Main();
        int expected = 2;
        int actual = tester.readRawDataToStringForTestPrice("MainTestDate.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void typeTest() throws Exception {
        Main tester = new Main();
        int expected = 3;
        int actual = tester.readRawDataToStringForTestType("MainTestDate.txt");

        Assert.assertEquals(expected, actual);


    }
    @Test
    public void ExpirationTest() throws Exception {
        Main tester = new Main();
        int expected = 1;
        int actual = tester.readRawDataToStringForTestExpiration("MainTestDate.txt");

        Assert.assertEquals(expected, actual);
    }
}