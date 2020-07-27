import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Parser {

    private String str;
    private int error = 0;
    public Parser(String s){
        str = s.toLowerCase();
        splitToSentence();
        splitToWords();
        checkError();
    }
    private void splitToSentence(){
        str = str.replaceAll("[##@^*%!]", " ");
    }

    private void splitToWords(){
        str = str.replaceAll("[;]", " ");
    }

    private void checkError(){
        String[] p = str.split(" ");
        List<String> s = new ArrayList<String>(Arrays.asList(p));
        int i = 0;
        for(int j = 0; j < s.size(); j++) {
            char[] c = s.get(j).toCharArray();
            for (i = 0; i < c.length; i++) {
                try {
                    if (c[i] == ':' && c[i + 1] == ' ') {
                        error++;
                        s.remove(j);
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    if(c[i] == ':'){
                        s.remove(j);
                        error++;
                    }
                }
            }
        }
        str = "";
        for(String w: s){
            str+=w+" ";
        }
    }

    public String getStr(){
        return str;
    }

    public String createMap(){
        TreeMap<String, Integer> map = new TreeMap<>();
        String [] s = str.split(" ");

        for(String w: s){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else {
                map.put(w, 1);
            }
        }

       return getMap(map);
    }
    private String getMap(TreeMap<String, Integer> map){

        Object[] arr =  map.keySet().toArray();
        Arrays.sort(arr);
        String mapValues = "";
        for (int i = 0; i < arr.length-1; i++){
            mapValues+=arr[i] + " (Seen " + map.get(arr[i]) + ")\n";
        }
        mapValues += "Errors: " + error;
        return mapValues;
    }
/*
    public static void main(String [] args){
        Parser str = new Parser("Name:Milk;Price:3.23;type:;expiration:1/24/2016##");

        str.getStr();
        System.out.println(str.createMap());
    }

 */
}
