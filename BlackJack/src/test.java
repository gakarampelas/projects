import java.util.Random;

public class test {

    public static void main(String args[]) {

        Deck d = new Deck();
        int riskyWins = 0, consWins = 0; // wins counters
        Random rand = new Random();    //P(deck refreshes)=1/2
        System.out.println("Performing 100000 rounds in order to test better strategy");
        Player risky = new Player("Risky");
        Player cons = new Player("Conservative");
        for (int i = 0; i < 100; i++) {

            risky.dealWithBoundary(d,18);
            cons.dealWithBoundary(d,17);
            if (risky.compareHandsValue(cons) == 1) {
                riskyWins += 1;
            } else if (risky.compareHandsValue(cons) == -1) {
                consWins += 1;
            }
            if (rand.nextDouble() <= 0.5) { //refreshes Deck
                d = new Deck(4);
            }
            risky.clearHand();
            cons.clearHand(); //start over with empty hand
        }
        System.out.println("WINS\n" + risky.getName() + ": " + riskyWins);
        System.out.println(cons.getName() + ": " + consWins);


    }
}
