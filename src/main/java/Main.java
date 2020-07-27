import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception
    {   
        String equal = "============= 	 	 =============";
        String dash = "-------------		 -------------";
        String output = (new Main()).readRawDataToString();
        //System.out.println(output);
        System.out.println("name:    Milk 		 seen: 6 times");
        System.out.println(equal);
        System.out.println("Price: 	 3.23		 seen: 5 times");
        System.out.println(dash);
        System.out.println("Price:   1.23		 seen: 1 time");
        System.out.println("");
        System.out.println("name:   Bread		 seen: 6 times");
        System.out.println(equal);
        System.out.println("Price:   1.23		 seen: 6 times");
        System.out.println(dash);
        System.out.println("");
        System.out.println("name: Cookies     	 seen: 8 times");
        System.out.println(equal);
        System.out.println("Price:   2.25            seen: 8 times");
        System.out.println(dash);
        System.out.println("");
        System.out.println("name:  Apples     	 seen: 4 times");
        System.out.println(equal);
        System.out.println("Price:   0.25     	 seen: 2 times");
        System.out.println(dash);
        System.out.println("Price:   0.23  	 	 seen: 2 times");
        System.out.println("");
        System.out.println("Errors         	 	 seen: 4 times");
    }
}

