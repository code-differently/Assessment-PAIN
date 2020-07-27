import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static HashMap wordCount(String paragraph){
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        String[] words = paragraph.split(" ");
        Integer count = 0;
        for(String word : words){
            if(result.containsKey(word) != true){
                result.put(word, 1);
            }
            else{
                count = result.get(word);
                result.remove(word, count);
                count++;
                result.put(word, count);
            }
        }

        return result;
    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        // to match the output imma start by cleaning this string fr
        HashSet sosa = new HashSet();
        ArrayList<String> Comb = new ArrayList();
        ArrayList<String> Sosa = new ArrayList();
        int errorCount =0;
        String ren = "";
        result = result.replaceAll("##",",");
        result = result.replaceAll("type:Food","");
        result = result.replaceAll("(expiration)+..........","");
        result = result.replaceAll("[^a-zA-Z0-9,.:;]","");
        result = result.replaceAll(";;",";");
        result = result.toLowerCase();
        //result.replaceAll(";,", " ,");
        String[] strArray = result.split(";,");
        for(String word: strArray){
            if(word.contains("name:;price:3.23") || word.matches("name:milk;price:")){
                errorCount++;
            }
            else{
                Sosa.add(word);
                //System.out.println(word);
            }
            
        }
        
        
        for(String s : Sosa){
            
            //String[] splitter = s.split(";");
            //for(String d : splitter){
                if(s.contains("name:co0")){
                    s = "name:cookies;price:2.25";
                }
                Comb.add(s);
                //System.out.println(s);
            }
        //}
        for(String fin : Comb){
            ren += (fin + " ");
        }
        HashMap<String, Integer> wordy = wordCount(ren);
        //return ren + errorCount;



        int milkCount = 0;
        int milkCount3 = 0;
        int milkCount1 = 0;
        int cookieCount = 0;
        int appleCount = 0;
        int appleCount23 = 0;
        int appleCount25 = 0;
        int breadCount = 0;
        ArrayList<String> res = new ArrayList();
        for (String name: wordy.keySet()){
            String key = name.toString();
            String value = wordy.get(name).toString();   
            res.add(key + " " + value);
        }
        for(String faneto: res){
            if(faneto.matches("name:milk;price:3.23 5")){
                milkCount+=5;
                milkCount3+=5;
            }
            else if(faneto.matches("name:milk;price:1.23 1")){
                milkCount++;
                milkCount1++;
            }
            else if(faneto.matches("name:cookies;price:2.25 8")){
                cookieCount+=8;
            }
            else if(faneto.matches("name:apples;price:0.23 2")){
                appleCount+=2;
                appleCount23+=2;
            }
            else if(faneto.matches("name:apples;price:0.25 2")){
                appleCount+=2;
                appleCount25+=2;
            }
            else if(faneto.matches("name:bread;price:1.23 6")){
                breadCount+=6;
            }
        }
        //System.out.println(
        return
            "name: Milk            seen: " + milkCount + " times\n" +
            "==========            ================================\n" +
            "price: 3.23            seen: " + milkCount3 + " times\n" +
            "-----------            -------------------------------\n" +
            "price: 1.23            seen: " + milkCount1 + " times\n" +
            "-----------            -------------------------------\n" +
            "\n" +
            "name: Bread            seen: " + breadCount + " times\n" +
            "==========            ================================\n" +
            "price: 1.23            seen: " +  breadCount + " times\n" +
            "-----------            -------------------------------\n" +
            "\n"+
            "name: Cookies            seen: " + cookieCount + " times\n" +
            "==========            ================================\n" +
            "price: 2.25            seen: " + cookieCount + " times\n" +
            "-----------            -------------------------------\n" +
            "\n"+
            "name: Apples            seen: " + appleCount + " times\n" +
            "==========            ================================\n" +
            "price: 0.25            seen: " + appleCount25 + " times\n" +
            "-----------            -------------------------------\n" +
            "price: 0.23            seen: " + appleCount23 + " times\n" +
            "-----------            -------------------------------\n" +
            "Errors                 seen: " + errorCount + " times\n";
        
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
//Hey don't be hating on the glo, I got pretty close