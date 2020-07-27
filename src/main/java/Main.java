import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    // Idea: split up the grocery items by  "##"
    // Idea: add only the words that aren't "name", "price", "type" or "expiration"
    // Idea: 2 Hashmaps: one for "name" occurences, "price" - doesn't work because
    // there's no way to keep track of the "price" that went with the "name"

    // BACKGROUND: didnt get far because of spending so much time figuring
    // out the logic for this assessment... kept running into dead ends/holes
    // in my pseudocode
    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("testf.txt"));
        String[] arr = result.split("##");
        for (String item : arr){
            for (int idx = 0; idx < item.length(); idx++){

            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
