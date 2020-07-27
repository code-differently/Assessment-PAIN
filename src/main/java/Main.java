import org.apache.commons.io.IOUtils;
import java.util.HashMap;
import java.util.Map;
/*

@Author: Pretty code, written by a prettier coder

 */
public class Main
{

    public String readRawDataToString() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        String output = (new Main()).readRawDataToString();
        String modifiedOutput = makeEasy(output);

        //if there is a blank price or a name we are going to want to increment this
        int countErrors = 0;
        //the map needs to be able to map the Name of the product, to a price, and that price is going to point to the
        //product's count
        HashMap<String, HashMap<Double, Integer>> hashy = new HashMap<String, HashMap<Double, Integer>>();
        //now the inputArr contains every line in the text file
        String[] inputArr = modifiedOutput.split("\n");

        for (String line : inputArr)
        {
            String lineInUse = line.toLowerCase();
            //tester to print out correct lines
//            System.out.println(lineInUse);


            String name = lineInUse.substring(0, lineInUse.indexOf(","));
            String price = lineInUse.substring(lineInUse.indexOf(",") + 1);

            name = name.substring(name.indexOf(":") + 1);
            name = new Main().replaceDemLetters(name);
            price = price.substring(price.indexOf(":")+1);


            if(name.isEmpty() || price.isEmpty())
            {
                countErrors++;
            }
            else if(!price.isEmpty() && !name.isEmpty())
            {
                //if the hash map contains the key of the food product then...
                if (!hashy.containsKey(name))
                {
                    //put that name of the product in the hashmap, and assign it's double and integer
                    hashy.put(name, new HashMap<Double, Integer>());
                }
                HashMap<Double, Integer> prices = hashy.get(name);
                Double amount = Double.parseDouble(price);
                prices.put(amount, prices.get(amount) == null ? 1 : prices.get(amount) + 1);

                hashy.put(name, prices);
            }

        }
        System.out.println(format(hashy) +  countErrors + " errors seen");
    }

    public String replaceDemLetters(String in)
    {
        //had to look up regex for finding certain strings within a string
        if(in.matches(".*[\\d].*"))
        {
            //assign numbers and their respective letters
            in = in.replaceAll("0", "o");
            in = in.replaceAll("3", "e");
            in = in.replaceAll("4","a");
            in = in.replaceAll("8", "b");
            in = in.replaceAll("6", "g");
        }
        return in;
    }


    public static String format(HashMap<String, HashMap<Double, Integer>> listOfItems)
    {
        //uses a stringbuilder to get the correct format as wanted by Baron Von Codem
        StringBuilder formatter = new StringBuilder("");
        for(Map.Entry<String, HashMap<Double, Integer>> entry : listOfItems.entrySet())
        {
            int itemCounter = 0;
            HashMap<Double, Integer> priceOccurence = entry.getValue();
            for(Integer priceCount : priceOccurence.values())
            {
                itemCounter += priceCount;
            }

            formatter.append(String.format(
                    "name: %7s\tseen: %d times\n", entry.getKey(), itemCounter));
            formatter.append("========\t\t========\n");

            for(Map.Entry<Double, Integer> pricesCounts : priceOccurence.entrySet())
            {
                formatter.append(String.format(
                        "Price: %.2f\t\tseen: %d times\n", pricesCounts.getKey(), pricesCounts.getValue()
                ));
                formatter.append("--------\t\t--------\n");
            }

            formatter.append("\n");
        }
        return formatter.toString();
    }

    public static String makeEasy(String jsonContent)
    {
        //replaces the seperators with a new line, and differentiates
        String format = jsonContent.replaceAll("##", "\n");
        format = format.replaceAll("[;^]", ",");
        format = format.replaceAll("[^\\w\\n,./:]",":");
        format = format.replaceAll(",type.+","");

        return format;
    }

}
