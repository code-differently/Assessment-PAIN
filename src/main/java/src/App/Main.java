package src.App;

import org.apache.commons.io.IOUtils;
import src.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        output = output.toLowerCase();
        output.replaceAll(":", "");
        String[] linesOfOutput = output.split("##");
        List<Item> items = new ArrayList<Item>();
        for(String item: linesOfOutput) {
            int indexOfName = item.indexOf("name");
            int indexOfPrice = item.indexOf("price");
            int indexOfFood = item.indexOf("food");
            int indexOfExpiration = item.indexOf("expiration");
            System.out.println(item);
            if(indexOfName == -1 || indexOfPrice == -1 || indexOfFood == -1 || indexOfExpiration == -1) {
                System.out.println("name index: " + indexOfName + " price index: " + indexOfPrice + " food index: " + indexOfFood + " expiration index: " + indexOfExpiration);
            }
            System.out.println();
        }

        //loop through the item objects
        //print out information
    }
}
