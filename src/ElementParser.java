import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ElementParser {

    public static Element[] elements;

    static {
        ArrayList<String> list = readElements();
        elements = new Element[100];
        int i = 0;
        for (String s : list) {
            String[] parts = s.split(" ");
            String name = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double value = Double.parseDouble(parts[2]);
            Element ele = new Element(name, weight, value); //Make a simple Element class.
            elements[i] = ele;
            i++;
        }
    }

    private static ArrayList<String> readElements() {
        try {
            File file = new File("./src/Elements.txt");
            Scanner reader = new Scanner(file);

            ArrayList<String> list = new ArrayList<>();
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                list.add(s);
            }
            System.out.println(list);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Element> getElements() {


        ArrayList<Element> copyy = new ArrayList<>();

        for (Element orig : elements) {
            copyy.add(new Element(orig));
        }
        return copyy;
    }
}