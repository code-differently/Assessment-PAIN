import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    Item item;
    public HashSet<String> lines = new HashSet<String>(28);

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public String readOutputDataToString() throws Exception {
        ClassLoader classLoader2 = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader2.getResourceAsStream("output.txt"));
        return result;
    }

    /*public String[] getLine(String nextLine) throws FileNotFoundException{
        String[] line=nextLine.split(" "); //split words into a string array
        return line; //string array
    }*/

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
        String results = (new Main()).readOutputDataToString();
        System.out.println(results);



    }
}
