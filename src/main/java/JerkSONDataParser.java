import java.util.HashMap;
import java.util.Map;

public class JerkSONDataParser {

    /**
     * @param input A string parsed in JerkSON
     * @return A string converted to JSON
     */
    static String cleanData(String input){
        String formatted=input.replaceAll("##","\n");
        formatted=formatted.replaceAll("[;^]",",");
        formatted=formatted.replaceAll("[^\\w\\n,./:]",":");
        formatted=formatted.replaceAll("[:,]expiration.+",",expiration");
        return formatted;
    }

    /**
     * @param input A string in parsed in JSON to be turned into a HashMap
     * @return A string displaying the occurences of the products and errors
     */
    static String getOccurences(String input) {
        HashMap<String, HashMap<Double, Integer>> products = new HashMap<String, HashMap<Double, Integer>>();
        int errors = 0;
        input = input.replaceAll(",type.+", "");
        String[] splitInput = input.split("\n");
        for (String line :
            splitInput) {
            String currentLine=line.toLowerCase();
            String name=currentLine.substring(0,currentLine.indexOf(","));
            String price=currentLine.substring(currentLine.indexOf(",")+1);
            name=name.substring(name.indexOf(":")+1);
            name=spellCheck(name);
            price=price.substring(price.indexOf(":")+1);
            if(name.isBlank())
                errors++;
            if(price.isBlank())
                errors++;
            if(!name.isBlank()&&!price.isBlank()) {
                String firstLetter=name.substring(0,1).toUpperCase();
                name=firstLetter+name.substring(1);
                if (!products.containsKey(name))
                    products.put(name,new HashMap<Double, Integer>());
                HashMap<Double, Integer> prices=products.get(name);
                Double amount = Double.parseDouble(price);
                if (prices.containsKey(amount)) {
                    int newVal=prices.get(amount)+1;
                    prices.replace(amount,newVal);
                }
                else {
                    prices.put(amount, 1);
                }
                products.put(name, prices);

            }

        }
        return formatOccurences(products)+"Errors\t\t\t\tseen: "+errors+" times\n";
    }

    /**
     * @param input Replaces incorrect spelling that uses numbers
     * @return A string with correct letters
     */
    private static String spellCheck(String input){
        String formatted=input;
        if(formatted.matches(".*[\\d].*")) {
            formatted = formatted.replaceAll("0", "o");
            formatted = formatted.replaceAll("3", "e");
        }
        return formatted;
    }

    /**
     * @param products A HashMap that has been formatted correctly, name:{prices{price:count}}
     * @return A string displaying the occurences of the products and errors
     */
    private static String formatOccurences(HashMap<String,HashMap<Double, Integer>> products){
        StringBuilder output=new StringBuilder();
        for (Map.Entry <String,HashMap<Double,Integer>> entry:
             products.entrySet()) {
            int count=0;
            HashMap<Double,Integer> prices=entry.getValue();
            for (Integer priceCount:
                prices.values()) {
                count+=priceCount;
            }
            String top=String.format("name: %7s\t\tseen: %d times\n",entry.getKey(),count);
            output.append(top);
            output.append("=============\t\t=============\n");
            for (Map.Entry<Double,Integer> price:
                prices.entrySet()) {
                String bottom=String.format("Price:  %.2f\t\tseen: %d times\n",price.getKey(),price.getValue());
                output.append(bottom);
                output.append("-------------\t\t-------------\n");
            }
            output.append("\n");
        }
        return output.toString();

    }
}
