import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JerkSONParser jsp = new JerkSONParser(output);

        jsp.parseInputForEntries();
        jsp.getEntries();

        System.out.println();

        jsp.parseEntriesForNamePrice();
        jsp.getNamePrice();

        System.out.println();

        jsp.countExceptions();

        System.out.println();

        jsp.countOccurrencesOfFood();

        jsp.createFood();
        System.out.println(jsp.getOutput());

    }
}
