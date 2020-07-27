import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

        String groceryList [] = output.split("##");
        List<String>groceryList2 = new ArrayList<String>();
        groceryList2 = Arrays.asList(groceryList);
        for (String s: groceryList2){
            System.out.println(s); 
        }

        
    }
}
