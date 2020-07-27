import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        //System.out.println(output);

        parse(output);

    }

    public static void parse(String data) {

        Map<String, Integer> shoppingList = new HashMap<String, Integer>();

        Map<String, Integer> milkPrices = new HashMap<String, Integer>();
        Map<String, Integer> cookiePrices = new HashMap<String, Integer>();
        Map<String, Integer> breadPrices = new HashMap<String, Integer>();
        Map<String, Integer> applePrices = new HashMap<String, Integer>();
            
        

        shoppingList.put("bread", 0);
        shoppingList.put("milk", 0);
        shoppingList.put("cookies", 0);
        shoppingList.put("apples", 0);

        String text = data.toLowerCase();

        text = text.replaceAll("[^a-zA-Z0-9]", " ");

        String[] words = text.split(" ");
        

        System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {

            if (shoppingList.containsKey(words[i])) {

                shoppingList.replace(words[i], shoppingList.get(words[i]) + 1); // increment value

                String price = words[i + 2] + "." + words[i + 3];

                if(words[i].equals("cookies")){

                    

                    if(!cookiePrices.containsKey(price)){

                        cookiePrices.put(price,1);
                        
                    }else{
                        cookiePrices.replace(price, (cookiePrices.get(price) + 1));
                    }
                    
                    

                    

                }

                if(words[i].equals("bread")){

                    if(breadPrices.containsKey(price)){

                        breadPrices.put(price,1);
                        
                    }else{
                        breadPrices.replace(price, (breadPrices.get(price) + 1));
                    }


                }

                if(words[i].equals("milk")){

                    if(milkPrices.containsKey(price)){

                        milkPrices.put(price,1);
                        
                    }else{
                        milkPrices.replace(price, (milkPrices.get(price) + 1));
                    }

                

                }

                if(words[i].equals("apples")){

                    if(applePrices.containsKey(price)){

                        applePrices.put(price,1);
                        
                    }else{
                        applePrices.replace(price, (applePrices.get(price) + 1));
                    }

                

                }


            }

        }


        System.out.print("name: Milk. Seen " + shoppingList.get(milk) + " times");
        System.out.print("name: Bread. Seen " + shoppingList.get(bread) + " times");
        System.out.print("name: Cookies. Seen " + shoppingList.get(cookies) + " times");
        System.out.print("name: Apples. Seen " + shoppingList.get(apples) + " times");
    }

    //Look I tried my best lol
    //I thought the point of assements were to test what we ALREADY learned though??
}
