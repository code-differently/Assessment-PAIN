import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ReadFileTest {

    String expected;
    String actual;
    ReadFile temp;
    @Before
    public void setUp() {
        temp = new ReadFile();
        expected = "";
        actual = "";
    }

    @Test
    public void getDataToString(){
        expected = "name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:3.23;type:food^expiration:1/11/2016##name:cookies;price:2.25;type:food%expiration:1/25/2016##name:cookies;price:2.25;type:food*expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:1.23;type:food!expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food@expiration:1/02/2016##name:bread;price:1.23;type:food@expiration:2/25/2016##name:milk;price:;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:co0kies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food^expiration:1/04/2016##";
        actual = temp.getData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSubStringsTest(){

        expected = "[name:milk;price:3.23;type:food;expiration:1/25/2016#, name:bread;price:1.23;type:food;expiration:1/02/2016#, name:bread;price:1.23;type:food;expiration:2/25/2016#, name:milk;price:3.23;type:food^expiration:1/11/2016#, name:cookies;price:2.25;type:food%expiration:1/25/2016#, name:cookies;price:2.25;type:food*expiration:1/25/2016#, name:cookies;price:2.25;type:food;expiration:3/22/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:milk;price:3.23;type:food;expiration:1/17/2016#, name:milk;price:1.23;type:food!expiration:4/25/2016#, name:apples;price:0.25;type:food;expiration:1/23/2016#, name:apples;price:0.23;type:food;expiration:5/02/2016#, name:bread;price:1.23;type:food;expiration:1/25/2016#, name:;price:3.23;type:food;expiration:1/04/2016#, name:milk;price:3.23;type:food;expiration:1/25/2016#, name:bread;price:1.23;type:food@expiration:1/02/2016#, name:bread;price:1.23;type:food@expiration:2/25/2016#, name:milk;price:;type:food;expiration:1/11/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:co0kies;price:2.25;type:food;expiration:1/25/2016#, name:cookies;price:2.25;type:food;expiration:3/22/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:milk;price:3.23;type:food;expiration:1/17/2016#, name:milk;price:;type:food;expiration:4/25/2016#, name:apples;price:0.25;type:food;expiration:1/23/2016#, name:apples;price:0.23;type:food;expiration:5/02/2016#, name:bread;price:1.23;type:food;expiration:1/25/2016#, name:;price:3.23;type:food^expiration:1/04/2016#]\n";
        actual = temp.getSubStrings().toString() + "\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getErrCountTest(){

        Assert.assertEquals(4, temp.getErrCount());

    }

    @Test
    public void fixMissSpellsTest() {
        expected = "[name:milk;price:3.23;type:food;expiration:1/25/2016#, name:bread;price:1.23;type:food;expiration:1/02/2016#, name:bread;price:1.23;type:food;expiration:2/25/2016#, name:milk;price:3.23;type:food^expiration:1/11/2016#, name:cookies;price:2.25;type:food%expiration:1/25/2016#, name:cookies;price:2.25;type:food*expiration:1/25/2016#, name:cookies;price:2.25;type:food;expiration:3/22/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:milk;price:3.23;type:food;expiration:1/17/2016#, name:milk;price:1.23;type:food!expiration:4/25/2016#, name:apples;price:0.25;type:food;expiration:1/23/2016#, name:apples;price:0.23;type:food;expiration:5/02/2016#, name:bread;price:1.23;type:food;expiration:1/25/2016#, name:milk;price:3.23;type:food;expiration:1/25/2016#, name:bread;price:1.23;type:food@expiration:1/02/2016#, name:bread;price:1.23;type:food@expiration:2/25/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:cookies;price:2.25;type:food;expiration:3/22/2016#, name:cookies;price:2.25;type:food;expiration:1/25/2016#, name:milk;price:3.23;type:food;expiration:1/17/2016#, name:apples;price:0.25;type:food;expiration:1/23/2016#, name:apples;price:0.23;type:food;expiration:5/02/2016#, name:bread;price:1.23;type:food;expiration:1/25/2016#]\n";
        temp.fixMissSpells();
        actual = temp.getSubStrings().toString() + "\n";
        Assert.assertEquals(expected, actual);
    }


}
