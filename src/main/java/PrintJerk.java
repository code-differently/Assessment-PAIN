import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PrintJerk 
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Food> foods = new ArrayList<Food>();
    LinkedHashMap<String,LinkedHashMap<Double,Integer>> groceries = new LinkedHashMap<String,LinkedHashMap<Double,Integer>>();
    

    public PrintJerk() 
    {

    }

public void setFile(String input) throws FileNotFoundException
{
    scan = new Scanner(new File(input));
}

public ArrayList getFood()
{
    return foods;
}

//Parses the input file and uses it as input to create food
private void getGroceries()
{

    String [] parse = scan.next().split("##");
    for (int i = 0; i < parse.length;i++)
    {

        Food food = createFoodFromString(parse[i]);
        if (food != null)
        {
            foods.add(food);
        }

    }
}
//Method to create a food object from a string input (Format: name:FoodName;price:FoodPrice
public Food createFoodFromString(String input)
{
    Food food = new Food();
    String [] parse = input.split(":|;");
    if (!parse[1].isEmpty() && !parse[3].isEmpty()) //Name of food and price
    {
       food.setFoodName(parse[1].toLowerCase().replaceAll("0", "o")); 
       food.setFoodPrice(Double.parseDouble(parse[3]));
    }

    return food;
}
//Method to fill hashmaps for amount seen
private void fillGroceries()
{
    getGroceries();
    for (Food food : foods)
    {
        if (!groceries.containsKey(food.getFoodName()))
        {
            groceries.put(food.getFoodName(),new LinkedHashMap<Double,Integer>());
        }
        if (groceries.get(food.getFoodName()).containsKey(food.getFoodPrice()))
        {
            groceries.get(food.getFoodName()).put(food.getFoodPrice(),groceries.get(food.getFoodName()).get(food.getFoodPrice())+1);
        }
        else
        {
            groceries.get(food.getFoodName()).put(food.getFoodPrice(),1);
        }

    }
}
//Prints the groceries
    public void printGroceries()
    {
        fillGroceries();
        for (Map.Entry<String, LinkedHashMap<Double, Integer>> nameEntry : groceries.entrySet()) {
            int amountSeen = 0;
            System.out.print("name: \t" + nameEntry.getKey());
            for (Map.Entry<Double, Integer> entry2 : nameEntry.getValue().entrySet()) {
                amountSeen += entry2.getValue();
            }
            System.out.println("\t\tseen: " + amountSeen + " times");


            for (Map.Entry<Double, Integer> priceEntry : nameEntry.getValue().entrySet()) {
                System.out.println("Price:\t" + priceEntry.getKey() + "\t\tSeen: " + priceEntry.getValue() + " times");
            }
            System.out.println("");
        }
    }
 
}