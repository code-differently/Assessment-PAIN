import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    //#THANKS OBAMA
    //#MakeTheTestLessDifficultAgain

    public static String[] words(String paragraph) {
        HashMap<String, Integer> output = new HashMap<String,Integer>();
        String[] str = paragraph.split(" ");
        return str;
    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}

/**Notes from vid:
 * \. gets periods
 * \w any letter
 * \s gets any white space
 * \S anything not a whitespace
 * \W anything that isnt a character spaces and periods etc. 
 * \w{4} pr {4,5} 
 * [fc]at starts with f or c ends with at
 * [a-zA-Z]at some as above
 * (t|T)he their own group, looks for either t or T
 * ^beginning of paragraph
 * ^t/gn beginning of each line
 * \.$gets ending period of entire paragraph
 * (?<=) look behind [tT]he). the char after the which shows a white space
 * (?<![tT]he). Anything except what’s after the
 * .(?=at) look ahead. Shows the letter before at
 * .(?!at) looks at everything except what’s before at
 * /////////
 * Phone number:
 * \d digits
 * \d{10} 10 digits in a row
 * \d{3}-?\d{3}-?\d{4}/gm
 * (\d{3})-?(\d{3})-?(\d{4}) $1$2$3 combines the groups
 * ?<areacode> names the group
 * \(?(?<areacode>\d{3})\)?-?(\d{3})-?(\d{4}) with parenthesis in area code
 * (?: no space????
 * 
 */
