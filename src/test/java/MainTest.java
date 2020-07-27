import org.junit.Assert;
import org.junit.Test;
import sun.security.util.IOUtils;

import java.util.Scanner;

public class MainTest {
    @Test
    public void milkTest() throws Exception{
        Main tester = new Main();
        int expected = 1;
        int actual = tester.readRawDataString();
    }

    @Test
    public void firstlineTest() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##\n";
    }

    @Test
    public void finalOutputTest() throws Exception{
        Scanner scan = new Scanner(new File("MainTest.txt"));
        File
    }
}
