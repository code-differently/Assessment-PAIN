import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONParser;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        
        File file = new File(classLoader.getResource(result).getFile());
        
        return result;
    }

    public static void main(String[] args) throws Exception{
        String text = "";
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        Pattern pt = Pattern.compile(result)
        Matcher mt = pt.matcher(text);
        boolean res = mt.matches();
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
        JSONParser parser = new JSONParser();
        String name = "\\w";
        String price = "\\d+";
        String type = "\\w";
        String expiration = "\\w\\d\\s\\D\\W"; 

        try {
            FileReader reader = new FileReader(file.getAbsolutePath());
            Object obj = parser.parse(reader);
            JSONObject jsonObj = (JSONObject) obj;
            jsonObj.get("");
        }
            catch (Exception e){
                e.printStackTrace();
            }

    }
}
