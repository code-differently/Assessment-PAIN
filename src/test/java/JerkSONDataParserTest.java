import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class JerkSONDataParserTest {
    @Test
    public void cleanTest(){
        // Given
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expected="naMe:Milk,price:3.23,type:Food,expiration:1/25/2016\n";

        // When
        String actual=JerkSONDataParser.cleanData(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void cleanTest2(){
        // Given
        String fix="naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##";
        String expected="naMe:CoOkieS,price:2.25,type:Food,expiration:1/25/2016\n";

        // When
        String actual=JerkSONDataParser.cleanData(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void cleanTest3(){
        // Given
        String fix="naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD";
        String expected="naMe:CoOkieS,price:2.25,type:Food,expiration:1/25/2016\nnaMe:apPles,price:0.23,type:Food,expiration:5/02/2016\nNAMe:BrEAD";

        // When
        String actual=JerkSONDataParser.cleanData(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void cleanTest4(){
        // Given
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
            "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:" +
            "BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;" +
            "price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:" +
            "Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe" +
            ":COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;" +
            "expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:" +
            "1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/20" +
            "16##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Foo" +
            "d;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:" +
            "3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:" +
            "BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
            "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##";
        String expected="naMe:Milk,price:3.23,type:Food,expiration:1/25/2016\n" +
            "naME:BreaD,price:1.23,type:Food,expiration:1/02/2016\n" +
            "NAMe:BrEAD,price:1.23,type:Food,expiration:2/25/2016\n" +
            "naMe:MiLK,price:3.23,type:Food,expiration:1/11/2016\n" +
            "naMe:Cookies,price:2.25,type:Food,expiration:1/25/2016\n" +
            "naMe:CoOkieS,price:2.25,type:Food,expiration:1/25/2016\n" +
            "naMe:COokIes,price:2.25,type:Food,expiration:3/22/2016\n" +
            "naMe:COOkieS,price:2.25,type:Food,expiration:1/25/2016\n" +
            "NAME:MilK,price:3.23,type:Food,expiration:1/17/2016\n" +
            "naMe:MilK,price:1.23,type:Food,expiration:4/25/2016\n" +
            "naMe:apPles,price:0.25,type:Food,expiration:1/23/2016\n" +
            "naMe:apPles,price:0.23,type:Food,expiration:5/02/2016\n" +
            "NAMe:BrEAD,price:1.23,type:Food,expiration:1/25/2016\n" +
            "naMe:,price:3.23,type:Food,expiration:1/04/2016\n" +
            "naMe:Milk,price:3.23,type:Food,expiration:1/25/2016\n" +
            "naME:BreaD,price:1.23,type:Food,expiration:1/02/2016\n" +
            "NAMe:BrEAD,price:1.23,type:Food,expiration:2/25/2016\n" +
            "naMe:MiLK,priCe:,type:Food,expiration:1/11/2016\n" +
            "naMe:Cookies,price:2.25,type:Food,expiration:1/25/2016\n" +
            "naMe:Co0kieS,pRice:2.25,type:Food,expiration:1/25/2016";

        // When
        String actual=JerkSONDataParser.cleanData(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void spellCheckTest(){
        // Given
        String fix="c00Kie";
        String expected="cooKie";

        // When
        String actual=JerkSONDataParser.spellCheck(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void spellCheckTest2(){
        // Given
        String fix="c00Ki3";
        String expected="cooKie";

        // When
        String actual=JerkSONDataParser.spellCheck(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void spellCheckTest3(){
        // Given
        String fix="ApPL3";
        String expected="ApPLe";

        // When
        String actual=JerkSONDataParser.spellCheck(fix);

        // Then
        Assert.assertEquals(expected,actual);

    }
}
