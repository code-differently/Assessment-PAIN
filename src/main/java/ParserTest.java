import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    @Test
    public void parserTest(){
        Parser str = new Parser("Name:Milk;Price:3.23;type:;expiration:1/24/2016##");

        Assert.assertEquals("name:milk price:3.23 expiration:1/24/2016 ", str.getStr());
    }

    @Test
    public void getStrTest(){
        Parser str = new Parser("Name:Milk;Price:3.23;type:;expiration:1/24/2016##Name:Milk;Price:3.23;type:;expiration:1/24/2016##");

        Assert.assertEquals("name:milk price:3.23 expiration:1/24/2016  name:milk price:3.23 expiration:1/24/2016 ", str.getStr());
    }

    @Test
    public void createMapTest(){
        Parser str = new Parser("Name:Milk;Price:3.23;type:;expiration:1/24/2016##");

        Assert.assertEquals("expiration:1/24/2016 (Seen 1)\nname:milk (Seen 1)\nErrors: 1", str.createMap());
    }
}
