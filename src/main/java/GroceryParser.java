import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class GroceryParser {
    private Main main;
    private Groceries item;
    private ArrayList<Groceries> groceries;
    private int occ;
    private int errors = 0;

    public void parseData(String input) {
        String[] lines = input.split("##");
        groceries = new ArrayList<>();

        int i = 0;
        while(i < lines.length){
            String currentLine = lines[i];
            String[] sections = currentLine.split(";");

            String name = getNamePars(sections[0]);
            String price = getPricePars(sections[1]);
            String type = getTypePars(sections[2]);
            String expiration = getExpirationPars(sections[3]);

            item = new Groceries(name, price, type, expiration);
            groceries.add(item);
            i++;
        }
    }

    public ArrayList<Groceries> getGroceries(){
        return groceries;
    }

    public String getNamePars(String input) {
        String[] nameDirec =  input.split(":");
        if(nameDirec.length == 1) {
            errors++;
            return "";
        }

        return nameDirec[1];
    }

    public String getPricePars(String input){
        String[] priceDirec = input.split(":");
        if(priceDirec.length == 1) {
            errors++;
            return "0.00";
        }

        return priceDirec[1];
    }

    public String getTypePars(String input){
        String[] typeDirec = input.split(":");
        if(typeDirec.length == 1) {
            errors++;
            return "";
        }

        return typeDirec[1];
    }

    public String getExpirationPars(String input){
        String[] expirationDirec = input.split(":");
        if(expirationDirec.length == 1) {
            errors++;
            return "";
        }

        return expirationDirec[1];
    }

    public int getNameOcc(String name){
        occ = 0;

       for(Groceries g: groceries){
           if(g.getName().equalsIgnoreCase(name))
               occ++;
       }

       return occ;
    }

    public int getPriceOcc(String name, String price){
        occ = 0;

        for(Groceries g: groceries){
            if(g.getName().equalsIgnoreCase(name))
                if(g.getPrice().equalsIgnoreCase(price))
                    occ++;
        }

        return occ;
    }

    /*public String printGroceries(){
        PriorityQueue<String> que = new PriorityQueue<>();
        String output = "";

        for(Groceries g: groceries){
            if(!(que.contains(g.getName().equalsIgnoreCase(g.getName())))){
                String name = g.getName();
                Character firstLetter = name.charAt(0);
                firstLetter = Character.toUpperCase(firstLetter);
                que.add(name);
                output += name;
            }
        }

        return output;
    }*/
}