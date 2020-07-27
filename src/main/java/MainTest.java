import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class MainTest {
    Item item;

    @Test
    public void getLineOneTest() throws FileNotFoundException {
        //Given
        Scanner sc = new Scanner(new File("RawData.txt"));
        //ClassLoader classLoader = getClass().getClassLoader();
        //IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String expectedLine = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";

        //When
        String[] actualLine = item.getLine(sc.nextLine());
        //Class<?> actualLine = item.getLine(result);
        System.out.println(actualLine);

        //Then
        Assert.assertEquals(expectedLine, actualLine);
    }

    @Test
    public void getLineTest() throws IOException {
        //Given
        ClassLoader classLoader = getClass().getClassLoader();
        IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String expectedLine = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";

        //When
        ClassLoader actualLine = getClass().getClassLoader();
        System.out.println(actualLine);

        //Then
        Assert.assertEquals(expectedLine, actualLine);
    }

    @Test
    public void outputTest() throws FileNotFoundException {
        //Given
        File expectedOutput = (new File("output.txt"));

        //When
        File actualOutput = (new File("output.txt"));
        System.out.println(actualOutput);

        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkCharactersTest(){
        //Given

        //When

        //Then
    }

    @Test
    public void splitStringTest(){
        //Given

        //When

        //Then
    }
}
