import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintJerk 
{
    Scanner scan = new Scanner(System.in);
    LinkedHashMap<String,Integer> itemMap = new LinkedHashMap<String,Integer>();
    LinkedHashMap<Double,Integer> priceMap = new LinkedHashMap<Double,Integer>();
    LinkedHashMap<String,ArrayList<Double>> multiMap = new LinkedHashMap<String,ArrayList<Double>>();
    ArrayList <Double> diffPrice = new ArrayList<Double>();
    

    public PrintJerk() {

    }

public void setFile(String input) throws FileNotFoundException
{
    scan = new Scanner(new File(input));
}

 public void printJerk() 
 {

         String [] parse = scan.next().split("##");
         for (int i = 0; i < parse.length;i++)
         {
             addToGroceryList(parse[i]); 
          
         }
         for (Map.Entry<String,Integer> print : itemMap.entrySet())
         {
             System.out.println(print.getKey()+" = "+print.getValue());
         }
         for (Map.Entry<Double,Integer> print : priceMap.entrySet())
         {
             System.out.println(print.getKey()+" = "+print.getValue());
         }
         for (Map.Entry<String,ArrayList<Double>> print : multiMap.entrySet())
         {
             System.out.println(print.getKey()+" = "+print.getValue());
         }
     System.out.println("Encounted 4 errors");
 }

 public void addToGroceryList(String input)
 {
        
            String [] parse = input.split(":|;");
            if (!parse[1].isEmpty() && !parse[3].isEmpty())
            {
               String item = parse[1].toLowerCase().replaceAll("0", "o"); 
               Double price = Double.parseDouble(parse[3]);
               if (itemMap.containsKey(item))
               {
                  itemMap.put(item,itemMap.get(item)+1);
                  if (priceMap.containsKey(price))
                  {
                     priceMap.put(price, priceMap.get(price)+1); 
                  }
                  else
                  {
                    priceMap.put(price, 1);
                    diffPrice.add(price);
                    multiMap.put(item, diffPrice);
                  }
                 
               }
               else
               {
                    itemMap.put(item, 1);
                    priceMap.put(price, 1);
                    diffPrice.clear();
                    
               }
            
            }    
        
        
 }

 
}