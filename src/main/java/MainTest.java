import org.junit.Assert;
import org.junit.Test;

public class MainTest
{

    @Test
    public void replaceDemLetters()
    {
        String s = "b000babababa";

        String expected = "booobabababa";

        Assert.assertEquals(expected, new Main().replaceDemLetters(s));
    }

    @Test
    public void readData() throws Exception
    {
        Assert.assertFalse(new Main().readRawDataToString().isEmpty());
    }
}