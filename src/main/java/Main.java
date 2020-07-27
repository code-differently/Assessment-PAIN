public class Main {


    public static void main(String[] args) throws Exception{
        ReadFile reader = new ReadFile();
        System.out.println(reader.getData());
        System.out.println("\n" + reader.getSubStrings());
        System.out.println(reader.getErrCount());
        reader.fixMissSpells();
        System.out.println(reader.getSubStrings());
        reader.createNameList();

    }




}
