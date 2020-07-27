import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static <K,V> void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

        //Set up a HashMap
        HashMap<String, Double> hm = new HashMap<String, Double>();
        Set<KeyStore.Entry<K,V>> entries = myMap.entrySet();
        //parse the set
        Iterator<KeyStore.Entry<K,V>> it = entries.iterator();
        while(it.hasNext()){
            KeyStore.Entry<K,V> e = it.next();
            K key = e.getKey();
            V value = e.getValue();
        }



    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("RawDate.txt");
        NodeList nameList = doc.getElementsByTagName("name");
        for(int i = 0; i < nameList.getLength(); i++){
            Node n = nameList.item(i);
            if(n.getNodeType()==Node.ELEMENT_NODE){
                Element name = (Element) n;
               String price = name.getAttribute("price");
               byte[] priceList = price.getBytes();
               for(int j = 0; j < priceList.getLength(); j++ ){

               }
            }
        }
    } catch (ParserConfigurationException e){
        //Catch Block
        e.printStackTrace();
    } catch(SAXException e){
        //Catch Block
        e.printStackTrace();
    } catch(IOException e){
        //Catch Block
        e.printStackTrace();
    }

    //This code is a remake of the code above, because I got stuck.. so I am trying a different way without removing those lines of code

    try{
        File inputFile = new File("RawData.txt");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("DataParser:" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("name:    Milk ");
        System.out.println("============= ");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Price:    3.23"
                        + eElement.getAttribute("Price:   1.23"));
                System.out.println("------------- ");
                System.out.println("Price : "
                        + eElement
                        .getElementsByTagName("price")
                        .item(0)
                        .getTextContent());



        }






    }
}
