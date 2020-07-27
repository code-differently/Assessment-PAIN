import org.junit.Test;
import org.junit.Assert;
import sun.nio.ch.IOUtil;


public class MainTest {

    @Test
    public void milkTest() throws Exception {
        ClassLoader cl = new getClass().getClassLoader();
        int expected = 8;
        IOUtil.toString(cl.getResourceAsStream("RawData.txt"));
        Assert.assertEquals(expected, actual);

    }



    @Test
    public void firstLine() throws Exception{
        ClassLoader cl = new getClass().getClassLoader();
        IOUtil.toString(cl.getResourceAsStream("RawData.txt"));
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        ClassLoader actual = getClass().getClassLoader();
        Assert.assertEquals(expected,actual);
    }





}


