import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        JerkSonparser jerkSonparser = new JerkSonparser();
        String output = (new Main()).readRawDataToString();
        String parsed = jerkSonparser.parser(output);
        String checked = jerkSonparser.checkCommas(parsed);
        HashMap<String,String> hashMap = jerkSonparser.mapping(checked);
        System.out.println(hashMap);

    }
}
