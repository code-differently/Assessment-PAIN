import org.apache.commons.io.IOUtils;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public String readRawDataString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String[] matches = result.split("[##;]");
        int items = 0;

        HashMap<String, Integer> Count = new HashMap<String, Integer>();

        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }


}
