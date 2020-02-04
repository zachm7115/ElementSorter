public class Main {

    public static void main(String[] args) {
        Population pop = new Population(1000, 0.5, 1);

        for (int i = 0; i < 1000; i++) {
            pop.kill();
            pop.regenerate();
        }
        pop.sort();
        pop.printB();

    }

}
