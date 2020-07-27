import org.apache.commons.io.IOUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<Item, String> map = new HashMap<>();
    //JSON.parse();
    //String JerkSon = new JsonBuilder();


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
    }
}
