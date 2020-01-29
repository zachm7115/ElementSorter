import java.lang.reflect.Array;
import java.util.ArrayList;

public class Elements {
//    TO GET THE ELEMENTS:
//
//
//    Individual.
//    What is an "individual" in this project?  How should we save the gene?
//    A backpack.                            An array of booleans or ints.
//
//    How can we score the "fitness" of an individual?
//    The sum of the values.
//    With a heavy penalty for going over 200kg...
//    Maybe if(weight>200): -100*(weight-200)
//
//    How can you mutate the genes?
//    Randomly turn them on or off.
//
//    Does mating make sense here?  If so, how can you mate 2 individuals?
//    It can.  Maybe take the first half of one individual +
//    second half of the other, and vice versa.  Will create
//              2 offspring.
//
//
//            Population.



    private int maxWeight, weight;
    private ArrayList<Element> Bases = ElementParser.getElements();
    private ArrayList<Element> eles;
    private double score;
    public Elements(int maxWeight){
        this.maxWeight = maxWeight;
        weight = 0;
        eles = new ArrayList<>();
    }
    public void Generate(){
        while (weight < maxWeight){
            int r = (int)(Math.random()*Bases.size());
            eles.add(Bases.get(r));
            Bases.remove(r);
        }
        eles.remove(eles.size()-1);
        getScore();

    }

    public Elements(Elements other, int maxWeight){
        eles = new ArrayList<>();
        this.maxWeight = maxWeight;
        for (Element e: other.eles){
            eles.add(e);
        }
        getScore();
    }


    public void mutate(){

    }

    public void getScore(){
        score = 0;
        for (Element e: eles){
            score += e.getValue();
        }
        score *=100;
    }
//


    public void checkWeight(){
        weight = 0;
        for (Element e: eles){
            weight += e.getWeight();
        }
    }

}
