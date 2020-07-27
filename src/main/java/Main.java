import org.apache.commons.io.IOUtils;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public static HashMap groceries(String groceryList) throws Exception {
        HashMap<String, Double> grocery = new HashMap<String, Double>();
        String[] kVPair = (new Main()).readRawDataToString().split(":");

        for (String item: kVPair) {
            String[] list = item.split(":");
            grocery.put("/([:])\w+/gi",(?=[0-9.0-9]));
        }
    }
}
