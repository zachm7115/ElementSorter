import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ElementParser {
    private int weightM;
    private ArrayList<Element> ele;
    public ElementParser(int weightMax){
        weightM = weightMax;
        ele = new ArrayList<>();

    }
 
    public ArrayList<String> readElements(){
        try{
            File file = new File("./src/Elements.txt");
            Scanner reader = new Scanner(file);
 
            ArrayList<String> list = new ArrayList<>();
            while(reader.hasNextLine()){
                String s = reader.nextLine();
                list.add(s);
            }
            System.out.println(list);
            return list;
 
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
 
    public static void main(String[] args) {
        ElementParser e = new ElementParser(200);
        ArrayList<String> list = e.readElements();
        ArrayList<Element> lel = new ArrayList<>();
        for(String s: list){
            String[] parts = s.split(" ");
            String name = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double value = Double.parseDouble(parts[2]);
            Element ele = new Element(name, weight, value); //Make a simple Element class.
            lel.add(ele);
        }
    }
 
 
}