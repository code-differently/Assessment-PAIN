import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JerksonDataParser {
    private Map<String,String> elements = new HashMap<String,String>();

    public String readAsString() throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("RawData.txt")));
        return data;
    }
    public String[] parsePairJumble() throws Exception {
        String data = readAsString();
        String[] parsedPairs = data.split("#");
        return parsedPairs;
    }

    public String[] parseKeyValuePair() throws Exception {
        String[] parsedPairs = parsePairJumble();
        List<String> parsedKeyValue = new ArrayList<String>();
        for(int i = 0; i < parsedPairs.length; i++){
            String[] temp = parsedPairs[i].split("[;@^*%!]");
            for(int j = 0; j < temp.length; j++){
                parsedKeyValue.add(temp[j]);
            }
        }
        String[] stringKeyValue = new String[parsedKeyValue.size()];
        for(int k = 0; k < parsedKeyValue.size(); k++){
            stringKeyValue[k] = parsedKeyValue.get(k);
        }
        return stringKeyValue;

    }

    public String[] parseTopics() throws Exception {
        String[] parsedKeyValue = parseKeyValuePair();
        List<String> parseTopics = new ArrayList<String>();
        for(int i = 0; i < parsedKeyValue.length; i++){
            String[] temp = parsedKeyValue[i].split(":");
            for(int j = 0; j < temp.length; j++){
                parseTopics.add(temp[j]);
            }
        }
        String[] parsedTopics = new String[parseTopics.size()];
        for(int k = 0; k < parseTopics.size(); k++){
            parsedTopics[k] = parseTopics.get(k);
        }
        return parsedTopics;
    }

    public int countErrors() throws Exception {
        int counted = 0;
        int errors = 0;
        String[] array = parseTopics();
        for(int i = 0; i < array.length; i++){
            if(array[i].length()!=0){
                counted++;
            }
            else{
                if(counted != 8){
                    errors++;
                }
                counted = 0;
            }
        }
        if(counted != 8){
            errors++;
        }
        return errors;
    }

    public void sort() throws Exception {
        String[] array = parseTopics();
        String name = "";
        String product = "";
        String price = "";
        for(int i = 0; i < array.length; i++){
            for(int k = 0; k < array.length; k++) {
                if (array[k].equalsIgnoreCase("name")) {
                    String temp = array[k].toLowerCase();
                    name += temp.toUpperCase().charAt(0);
                    for (int j = 1; j < temp.length(); j++) {
                        name += temp.charAt(j);
                    }
                } else if (array[k].equalsIgnoreCase("milk") || array[k].equalsIgnoreCase("bread")) {
                    String temp = array[k].toLowerCase();
                    product += temp.toUpperCase().charAt(0);
                    for (int j = 1; j < temp.length(); j++) {
                        product += temp.charAt(j);
                    }
                }else if(array[k].matches("[A-Za-z0]")){
                    product = "Cookies";

                }
                else if(array[k].matches("#.##")){
                    price = array[k];
                }
            }
            if(product.length() != 0 && price.length() != 0){
                elements.put(name, product);
                elements.put(product, price);
            }
            product = "";
            price = "";
        }
    }




    public static void main(String... args) throws Exception {
        JerksonDataParser parser = new JerksonDataParser();
        System.out.println(parser.readAsString());
        /*
        String[] parsed = parser.parsePairJumble();
        for(int i = 0; i < parsed.length; i++){
            System.out.println(parsed[i]);
        }

         */
        /*
        String[] parsed = parser.parseKeyValuePair();
        for(int i = 0; i < parsed.length; i++){
            System.out.println(parsed[i]);
        }
         */
        /*
        String[] parsed = parser.parseTopics();
        System.out.println(parsed[8]);
        System.out.println(parsed[8].isBlank());
        int count = parser.countErrors();
        System.out.println(count);

        for(int i = 0; i < parsed.length; i++){
            System.out.println(parsed[i]);
        }

         */
        Map<String,String> elements = new HashMap<String,String>();
        String[] array = parser.parseTopics();
        String name = "Name";
        String product = "";
        String price = "";
        for(int i = 0; i < array.length; i++){
               if (array[i].equalsIgnoreCase("milk") || array[i].equalsIgnoreCase("bread") || array[i].equalsIgnoreCase("apples") || array[i].equalsIgnoreCase("cookies")) {
                    String temp = array[i].toLowerCase();
                    product += temp.toUpperCase().charAt(0);
                    for (int j = 1; j < temp.length(); j++) {
                        product += temp.charAt(j);
                    }
                }else if(array[i].matches("Co0kieS")){
                    product = "Cookies";
                }
                else if(array[i].matches("^[0-9]+([\\\\,\\\\.][0-9]+)?$")){
                    price = array[i];
                }
            System.out.println(product);
            System.out.println(price);
            if(product.length() != 0 && price.length() != 0){

                elements.put(name, product);
                elements.put(product, price);
            }
            product = "";
            price = "";
        }

        for (Map.Entry<String,String> entry: elements.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
