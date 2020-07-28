import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.*;

public class Main {
    private String result;
    private LinkedHashMap map = new LinkedHashMap<String, Double>();
    private Matcher m;
    private Pattern p;

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public String getData(){
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
