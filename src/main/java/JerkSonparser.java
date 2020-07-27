import java.util.HashMap;

public class JerkSonparser {

    public String parser(String input)
    {
        String parsed = "";
        for (int i = 0; i < input.length(); i++) 
        {
            if (input.charAt(i) == ';') 
            {
                parsed += ",";
            }
            else if (input.charAt(i) == '@') 
            {
                parsed += ",";
            }
            else if(input.charAt(i)== '^')
            {
                parsed += ",";
            }
            else if(input.charAt(i)=='%')
            {
                parsed += ",";
            }
            else if(input.charAt(i)== '#')
            {
                parsed+= ",";
            }
            else if(input.charAt(i)== '*')
            {
                parsed += ",";
            }
            else if(input.charAt(i)== '!')
            {
                parsed += ",";
            }
            else
            {
                parsed += input.charAt(i);
            }
        }
        return parsed;
    }

    public String checkCommas (String input)
    {
        String checked = " ";
        for (int i = 0; i < input.length() - 1; i++) 
        {
            if(input.charAt(i) == ',' && input.charAt(i+1)== ',')
            {
                 checked += "";
            }
            else
            {
                checked += input.charAt(i);
            }
            
        }
        return checked;

    }

    public HashMap<String, String> mapping(String input)
    {
        HashMap<String,String> hashMap = new HashMap<String,String>();
        String [] arry = input.split(":");
        
        for (int i = 0; i < arry.length-1; i++) 
        {
             hashMap.put(arry[i], arry[i+1]);
        }
        return hashMap;
    }

    public void mapCheck(HashMap<String,String> hashMap)
    {
        

    }
    
}