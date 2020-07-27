import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String[] matches = result.split("[##;]");
        int names = 0;

        HashMap<String, Integer> foodCount= new HashMap<String, Integer>();
        for(String count : matches){
            if(count.equalsIgnoreCase("name:milk")) {
                names++;
            }
//            }else if(matches[i].equalsIgnoreCase("price:3.23")){
//               price++;
//            }else if(matches[i].equalsIgnoreCase("price:1.23")){
//                price++;
//            }else if(matches[i].equalsIgnoreCase("name:bread")) {
//                price++;
//            }else if(matches[i].equalsIgnoreCase("price:3.23")){
//                price++;
//            }else if(matches[i].equalsIgnoreCase("price:3.23")){
//              price++;
//            }
        }
        foodCount.put("milk", names);
        return result;
    }




    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
