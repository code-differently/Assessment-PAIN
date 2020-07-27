import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    // public String readRawDataToString() throws Exception{
    //     ClassLoader classLoader = getClass().getClassLoader();
    //     String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
       

        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

    //alphabetical order 

    public Integer wordCount (String file){

        String[] words = file.split(" ");
        Integer wordCount = 0;
        for(String word : words){
            
            //storing a new word in the hashmap
            if(hashMap.containsKey(word) == false){
                hashMap.put(word , 1);
            }

            else{

                // create a variable to keep count of the values for the given key..?
                wordCount =hashMap.get(word);


                //updates the wordcount(value)
                hashMap.replace(word,wordCount++);
            }

    }

    // public static void main(String[] args) throws Exception{
    //     String output = (new Main()).readRawDataToString();
    //     System.out.println(output);

    // }

    return null;
}
}

///i really give uppppppp
