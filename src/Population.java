import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {

    int size;
    double killRate, mutationRate;
    ArrayList<Elements> elements;

    public Population(int size, double killRate, double mutationRate) {
        this.size = size;
        this.killRate = killRate;
        this.mutationRate = mutationRate;

        elements = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            elements.add(new Elements(200));
        }
    }

    public void sort(){
        Collections.sort(elements, (o1, o2) ->  o2.getScore() - o1.getScore());
    }
    public void printB(){
        System.out.println(elements.get(0).getScore()/100);
        System.out.println(elements.get(0).getWeight());


    }

    public void kill(){
        int num = (int)(size*killRate);
        sort();

        for (int i = 0; i < num; i++) {
            elements.remove(elements.size()-1);
        }
    }

    public void regenerate(){
        while(size > elements.size()){
            int index = (int)(Math.random()*elements.size()); //randomly chooses an element as the "template"
            Elements newElement = new Elements(elements.get(index), 200);
            if(Math.random() > mutationRate) //chance to mutate new elements
                newElement.mutate();
            elements.add(newElement); //adds new elements into the pool
        }
    }


}
