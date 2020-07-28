import org.apache.commons.io.IOUtils;

import java.util.Objects;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream("RawData.txt")));
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JerkSONParser jsp = new JerkSONParser(output);

        jsp.makeInputObjects();

        System.out.println(jsp.getOutput());

        /*JerkSONParser jsp = new JerkSONParser(output);

        jsp.parseInputForEntries();
        jsp.getEntries();

        jsp.parseEntriesForNamePrice();

        jsp.countExceptions();

        jsp.countOccurrencesOfFood();

        jsp.createFood();
        jsp.countPriceOccurrences();
        System.out.println(jsp.getOutput()); */

    }
}
