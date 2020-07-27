import org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main 
{

    public static HashMap wordCount(String paragraph)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        String[] words = paragraph.split(" ");
        Integer count = 0;

        for(String word : words)
        {
            if(result.containsKey(word) != true)
            {
                result.put(word, 1);
            }
            else
            {
                count = result.get(word);
                result.remove(word, count);
                count++;
                result.put(word, count);
            }
        }

        return result;
    }

    public String readRawDataToString() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();

        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}