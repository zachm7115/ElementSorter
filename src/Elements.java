import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Base64;

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
    private ArrayList<Element> Bases;
    private ArrayList<Element> eles;
    private double score;
    public Elements(int maxWeight){
        Bases = new ArrayList<>();
        for (Element s: ElementParser.getElements()){
            Bases.add(s);
        }
        this.maxWeight = maxWeight;
        weight = 0;
        eles = new ArrayList<>();
        Generate();
    }
    public void Generate(){
        while (weight < maxWeight){
            int r = (int)(Math.random()*Bases.size());
            eles.add(Bases.get(r));
            weight += Bases.get(r).getWeight();
            Bases.remove(r);
        }
        eles.remove(eles.size()-1);
        getScore();

    }

    public Elements(Elements other, int maxWeight){
        Bases = new ArrayList<>();
        for (Element s: ElementParser.getElements()){
            Bases.add(s);
        }
        eles = new ArrayList<>();
        this.maxWeight = maxWeight;
        for (Element e: other.eles){
            eles.add(e);
        }
        checkWeight();
        getScore();
    }

    public int getWeight() {
        return weight;
    }

    public void mutate(){
        int r = (int)(Math.random()*Bases.size());
        int rr = (int)(Math.random()*eles.size());
        Element save = eles.get(rr);
        eles.remove(rr);
        eles.add(Bases.get(r));
        Bases.add(save);
        checkWeight();

    }

    public int getScore(){
        score = 0;
        for (Element e: eles){
            score += e.getValue();
        }
        score *=100;
        if (weight > 200){
            score-=10000;
        }
        return (int)score;
    }
//


    public void checkWeight(){
        weight = 0;
        for (Element e: eles){
            weight += e.getWeight();
        }
    }

}
