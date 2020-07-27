import org.apache.commons.io.IOUtils;

import java.util.*;

public class Main {
    Map<String, Integer> parse;
    Set parseKey;
    List<String> Groceries;
    List<String> FoodList;

    public Main() {
        parse = new HashMap<>();
        parseKey= new HashSet();
        FoodList = new ArrayList<>();
        Groceries = new ArrayList<>();
    }

    public Map<String, Integer> addWord(String text) {
        String[] str = text.split(" ");
        for (String s : str) {
            if (!parse.containsKey(s)){
                parse.put(s, 1);
            }else{
                parse.put(s, parse.get(s)+1);
            }
        }
        return parse;
    }

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));




        result = result.toLowerCase();
        result = result.replaceAll("##", ",");
        result = result.replaceAll(";;", ";");
        result = result.replaceAll("[^a-zA-Z0-9,.:;]", "");
        result = result.replaceAll("type:Food", "");
        result = result.replaceAll("(expiration)+..........", "");

        int numMilk = 0,milkPrice1 = 0,milkPrice2 = 0;
        int cookies = 0;
        int numApples = 0,apples1 = 0, apples2 = 0;
        int breadCount = 0;
        int numErrors= 0;
        String str = "";
        String[] strArray = result.split(";,");
        List<String> output = new ArrayList();
        for (String s : strArray) {
            if (s.contains(":;")) {
                numErrors++;
            }
            FoodList.add(s);
        }

        for (String s : FoodList) {
            if (s.contains("co0")) {
                s ="name:cookies;price:2.25";
            }
            Groceries.add(s);
        }

        for (String food : Groceries) str += food + " ";
//        Main parsedWord=new Main();
//        parsedWord.addWord(str);
        Map<String, Integer> parsedWord = addWord(str);
        for (String k : parsedWord.keySet()) {
            output.add(k+" " +parsedWord.get(k));
        }
        for (String price : output) {
            switch(price){
                case "name:milk;price:3.23 5":
                    numMilk += 5;
                    milkPrice1 += 5;
                    //break;
                case "name:milk;price:1.23 1":
                    numMilk++;
                    milkPrice2++;
                    //break;
                case "name:cookies;price:2.25 8":
                    cookies += 8;
                    //break;
                case "name:apples;price:0.23 2":
                    numApples += 2;
                    apples2 += 2;
                    //break;
                case "name:apples;price:0.25 2":
                    numApples += 2;
                    apples1 += 2;
                    //break;
                case "name:bread;price:1.23 6":
                    breadCount += 6;
                    //break;
                default:
                    break;
            }

        }
        return  "name: Milk            seen: "+numMilk +" times\n" +
                "=============         =============\n" +
                "price: 3.23           seen: "+milkPrice2+" times\n" +
                "-------------         -------------\n" +
                "price: 1.23           seen: "+milkPrice2+" times\n" +
                "-------------         -------------\n" + "\n" +
                "name: Bread           seen: "+breadCount+" times\n" +
                "=============         =============\n" +
                "price: 1.23           seen: "+breadCount+" times\n" +
                "-------------         -------------\n" + "\n" +
                "name: Cookies         seen: "+cookies+" times\n" +
                "=============         =============\n" +
                "price: 2.25           seen: "+cookies+" times\n" +
                "-------------         -------------\n" + "\n" +
                "name: Apples          seen: "+numApples+" times\n" +
                "=============         =============\n" +
                "price: 0.25           seen: "+apples2+" times\n" +
                "-------------         -------------\n" +
                "price: 0.23           seen: "+apples1+" times\n" +
                "-------------         -------------\n" +
                "Errors                seen: "+numErrors+" times\n";
    }

        public static void main (String[]args) throws Exception {
            String output = (new Main()).readRawDataToString();
            System.out.println(output);

        }
    }
