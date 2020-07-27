
import org.apache.commons.io.IOUtils;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadFile {

    private String data;
    private ArrayList<String> subStrings;
    private ArrayList<String> name;
    private HashMap<String, Integer> timesSeenTotal;
    private int errCount;

    public ReadFile() {
        subStrings = new ArrayList<>();
        timesSeenTotal = new HashMap<String, Integer>();

        errCount = 0;

        try {

            readRawDataToString();
            parseStringsForSubs();
            findRemoveErrors();
        } catch (Exception e) {

            System.out.println("failed read");
        }

    }

    private void readRawDataToString() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        data = result.toLowerCase();
    }

    public String getData() {
        return data;
    }

    private void addToList(String x) {

        subStrings.add(x);

    }
    private void removeFromList(String x) {

        subStrings.remove(x);

    }


    private void parseStringsForSubs (){

        String temp = "";
        for(int i = 0; i < getData().length()-1; i++) {

            if(getData().charAt(i)!= '#'){

                temp += getData().charAt(i);

            } else {
                temp += getData().charAt(i);
                addToList(temp);
                if(i+2 < getData().length()) {

                    i += 1;
                }
                temp = "";
            }

        }
    }

    public ArrayList<String> getSubStrings() {
        return subStrings;
    }

    private void findRemoveErrors () {

        for(int i = 0; i < getSubStrings().size(); i++){

           if (Pattern.compile("\\w[:@^*%][;]").matcher(getSubStrings().get(i)).find()) {

                removeFromList(getSubStrings().get(i));
                errCount++;
           }
        }
    }

    public int getErrCount() {
        return errCount;
    }

    public void fixMissSpells(){

        for(int i = 0; i < getSubStrings().size(); i++) {

            if(Pattern.compile("c..kies").matcher(getSubStrings().get(i)).find()){

                getSubStrings().set(i, getSubStrings().get(i).replaceAll("c..kies", "cookies"));
            }
        }
    }


    public void createNameList() {

    }




}
