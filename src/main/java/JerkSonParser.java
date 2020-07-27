
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class JerkSonParser {

  Map<String, String> nameMap = new TreeMap<String, String>();
  Map<String, Integer> map = new TreeMap<String, Integer>();
  
  //remove all Types from String
  public String removeType(String s){
    s = s.replaceAll("type:Food", "");
    return s; 
  }

  //remove all expiration mappings 
  public String removeExpirationMappings(String s){
    s = s.replaceAll("(expiration)+..........", "");
    return s; 
  }

  //split the string into an array of strings deliminated by ## 
  public String[] splitByHashTags(String s ){ //ex: ##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##
    //return array = {"NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016" , naMe:;price:3.23;type:Food^expiration:1/04/2016 }
    String[] arr = s.split("##"); 
    return arr;
  
  }

  //make another array split by the ;
  public String[] splitBySemiColon(String s){ //ex:array = {"NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016" , naMe:;price:3.23;type:Food^expiration:1/04/2016 } 
  //firstly remove extra semicolons:
    s = s.replaceAll(";;", ";");
    String[] a = s.split(";"); 
    return a; 

  }

  //then map the individual elements to a tree map separated by (:, @, ^, *, %)
  public void addToMap(String [] str){

    for(String s : str){
      String[] pairs = s.split(":@^*%", 2);
      pairs[0] = pairs[0].toLowerCase().replaceAll("0", "o"); 
      nameMap.put(pairs[0], pairs[1]);
    }

    //counting the errors in the map (meaning no matches)


  }


  
}