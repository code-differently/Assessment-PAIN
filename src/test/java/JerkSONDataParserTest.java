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
            "naMe:Co0kieS,pRice:2.25,type:Food,expiration:1/25/2016\n";

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

    @Test
    public void occurencesTest(){
        // Given
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expected=String.format("name: %7s\t\tseen: %d times\n","Milk",1);
        expected+="=============\t\t=============\n";
        expected+=String.format("Price:  %.2f\t\tseen: %d times\n",3.23,1);
        expected+="-------------\t\t-------------\n\n";
        expected+="Errors\t\t\t\tseen: "+0+" times\n";

        // When
        String actual=JerkSONDataParser.getOccurences(JerkSONDataParser.cleanData(fix));

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void occurencesTest2(){
        // Given
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##";
        String expected=String.format("name: %7s\t\tseen: %d times\n","Milk",1);
        expected+="=============\t\t=============\n";
        expected+=String.format("Price:  %.2f\t\tseen: %d times\n",3.23,1);
        expected+="-------------\t\t-------------\n\n";
        expected+="Errors\t\t\t\tseen: "+1+" times\n";

        // When
        String actual=JerkSONDataParser.getOccurences(JerkSONDataParser.cleanData(fix));

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void occurencesTest3(){
        // Given
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naMe:MilK;priCe:100000.32;type:Food;expiration:4/25/2016##";
        String expected=String.format("name: %7s\t\tseen: %d times\n","Milk",2);
        expected+="=============\t\t=============\n";
        expected+=String.format("Price:  %.2f\t\tseen: %d times\n",3.23,1);
        expected+="-------------\t\t-------------\n";
        expected+=String.format("Price:  %.2f\t\tseen: %d times\n",100000.32,1);
        expected+="-------------\t\t-------------\n\n";
        expected+="Errors\t\t\t\tseen: "+0+" times\n";

        // When
        String actual=JerkSONDataParser.getOccurences(JerkSONDataParser.cleanData(fix));

        // Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void occurencesTest4(){
        // Given
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naMe:MilK;priCe:100000.32;type:Food;expiration:4/25/2016##"+
            "naMe:C00ki3S;pRice:2.25;type:Food;expiration:1/25/2016##naMe:;pRice:;type:Food;expiration:1/25/2016##"+
            "naMe:CookieS;pRice:2.25;type:Food;expiration:1/25/2016##";

        // When
        String actual=JerkSONDataParser.getOccurences(JerkSONDataParser.cleanData(fix));

        // Then
        Assert.assertTrue(actual.contains("Errors\t\t\t\tseen: "+2+" times\n"));
        Assert.assertTrue((actual.contains(String.format("name: %7s\t\tseen: %d times\n","Cookies",2))));
        Assert.assertTrue((actual.contains(String.format("Price:  %.2f\t\tseen: %d times\n",100000.32,1))));
        Assert.assertTrue((actual.contains(String.format("Price:  %.2f\t\tseen: %d times\n",2.25,2))));
        Assert.assertTrue((actual.contains(String.format("name: %7s\t\tseen: %d times\n=============\t\t=============\n","Milk",2))));
    }

    @Test
    public void occurencesTest5(){
        // Given
        String fix="##";
        String expected="Errors\t\t\t\tseen: "+0+" times\n";

        // When
        String actual=JerkSONDataParser.getOccurences(JerkSONDataParser.cleanData(fix));

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void occurencesFormatTest(){
        // Given
        HashMap<String, HashMap<Double, Integer>> test = new HashMap<String, HashMap<Double, Integer>>();
        HashMap<Double, Integer> prices= new HashMap<Double, Integer>();
        prices.put(3.23,1);
        test.put("Milk",prices);
        String fix="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expected=String.format("name: %7s\t\tseen: %d times\n","Milk",1);
        expected+="=============\t\t=============\n";
        expected+=String.format("Price:  %.2f\t\tseen: %d times\n",3.23,1);
        expected+="-------------\t\t-------------\n\n";

        // When
        String actual=JerkSONDataParser.formatOccurences(test);

        // Then
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void occurencesFormatTest2(){
        // Given
        HashMap<String, HashMap<Double, Integer>> test = new HashMap<String, HashMap<Double, Integer>>();
        HashMap<Double, Integer> prices= new HashMap<Double, Integer>();
        prices.put(9.11,1);
        prices.put(11.20,1);
        test.put("Pizza",prices);
        String fix="name:pizza;price:11.20;type:Food;expiration:1/25/2016##NAMe:PIZZA;price:9.11;type:Food;expiration:4/25/2016##"+
            "name:;prICe:999999.00;type:Food;expiration:05/11/1983##";

        // When
        String actual=JerkSONDataParser.formatOccurences(test);

        // Then
        Assert.assertTrue((actual.contains(String.format("name: %7s\t\tseen: %d times\n=============\t\t=============\n","Pizza",2))));
        Assert.assertTrue((actual.contains(String.format("Price:  %.2f\t\tseen: %d times\n",11.20,1))));
        Assert.assertTrue((actual.contains(String.format("Price:  %.2f\t\tseen: %d times\n-------------\t\t-------------\n\n",9.11,1))));

    }
}
