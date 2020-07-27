import org.apache.commons.io.IOUtils;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {

    public String readRawDataToStringForMain() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String[] matches = result.split("[##;]");
        int items = 0;
        HashMap<String, Integer> foodCount = new HashMap<>();
        for(int i = 0; i < matches.length; i++)
        {
            if(matches[i].equalsIgnoreCase("name:milk")){
                items++;
            }
        }
        foodCount.put("milk", items);
        return result;
    }

    public Integer readRawDataToStringForTestItem(String userInput) throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream(userInput));
        String[] matches = result.split("[##;]");
        int items = 0;
        HashMap<String, Integer> foodCount = new HashMap<>();
        for(int i = 0; i < matches.length; i++)
        {
            if(matches[i].equalsIgnoreCase("name:milk")){
                items++;
            }
        }
        foodCount.put("milk", items);
        return foodCount.get("milk");
    }
    public Integer readRawDataToStringForTestPrice(String userInput) throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream(userInput));
        String[] matches = result.split("[##;]");
        int items = 0;
        HashMap<String, Integer> foodCount = new HashMap<>();
        for(int i = 0; i < matches.length; i++)
        {
            if(matches[i].equalsIgnoreCase("price:1.23")){
                items++;
            }
        }
        foodCount.put("milk", items);
        return foodCount.get("milk");
    }
    public Integer readRawDataToStringForTestType(String userInput) throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream(userInput));
        String[] matches = result.split("[##;]");
        int items = 0;
        HashMap<String, Integer> foodCount = new HashMap<>();
        for(int i = 0; i < matches.length; i++)
        {
            if(matches[i].equalsIgnoreCase("type:Food")){
                items++;
            }
        }
        foodCount.put("milk", items);
        return foodCount.get("milk");
    }
    public Integer readRawDataToStringForTestExpiration(String userInput) throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream(userInput));
        String[] matches = result.split("[##;]");
        int items = 0;
        HashMap<String, Integer> foodCount = new HashMap<>();
        for(int i = 0; i < matches.length; i++)
        {
            if(matches[i].equalsIgnoreCase("expiration:2/25/2016")){
                items++;
            }
        }
        foodCount.put("milk", items);
        return foodCount.get("milk");
    }



    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToStringForMain();
        System.out.println(output);
    }
}