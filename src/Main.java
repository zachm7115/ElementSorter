public class Main {

    public static void main(String[] args) {
        Population pop = new Population(100, 0.5, 1);

        for (int i = 0; i < 10; i++) {
            pop.kill();
            pop.regenerate();
        }

    }

}
