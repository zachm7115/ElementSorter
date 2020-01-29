public class Elements {
//    TO GET THE ELEMENTS:
//
//    Element[] elements = ElementParser.getElements();
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

    private int maxWeight;

    public Elements(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public Elements(Element other, int maxWeight){
        this.maxWeight = maxWeight;
    }

    public void mutate(){

    }

    public void getScore(){

    }

}
