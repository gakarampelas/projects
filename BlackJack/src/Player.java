import java.util.ArrayList;
import java.util.Scanner;


public class Player {

    private String name;
    private ArrayList<Card> hand; // player's hand: the cards he owns

    public Player() {
        hand = new ArrayList<Card>();
    }

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }
    public int acesCount() {                        //counts sum of aces in player's hand
        int count = 0;
        for (Card hand1 : this.hand) {
            if (hand1.getKind().equals("Ace")) {
                count += 1;
            }
        }
        return count;
    }

    public int deal(Deck d) { //method for player's dealing
        Scanner input = new Scanner(System.in);
        int value;
        System.out.println("Dealing with:\t" + this.getName());

        this.hand.add(d.pickRandom());                                            //player gets card
        System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
        value = this.gethandsValue();
        System.out.println("Hand's value: " + value);
        System.out.println("Draw?");

        while (!input.nextLine().equalsIgnoreCase("n") && !(value >= 21)) { //if possible, draws more
            this.hand.add(d.pickRandom());
            System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
            value = this.gethandsValue();
            System.out.println("Hand's value: " + value);

            if (value > 21) {
                System.out.println("Value > 21");

            } else if (value == 21) {
                System.out.println("Value=21!");
                return value;
            } else
                System.out.println("Draw?");

        }
        input.close();
        return value;
    }

  /*  public int dealConservative(Deck d) {                //method for predefined conservative dealing:
        Scanner input = new Scanner(System.in);
        int value;
        System.out.println("Dealing with:\t" + this.getName());

        this.hand.add(d.pickRandom());
        System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
        value = this.gethandsValue();
        System.out.println("Hand's value: " + value);
        System.out.println("Draw?");

        while (mannaLogic() && !(value >= 21)) {
            this.hand.add(d.pickRandom());
            System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
            value = this.gethandsValue();
            System.out.println("Hand's value: " + value);

            if (value > 21) {
                System.out.println("Value>21");

            } else if (value == 21) {
                System.out.println("21!");
                return value;
            } else
                System.out.println("Draw?");

        }
        input.close();
        return value;
    }*/

    public int dealWithBoundary(Deck d, int boundary) {                //method for predefined conservative dealing:
        Scanner input = new Scanner(System.in);
        int value;
        System.out.println("Dealing with:\t" + this.getName());
        this.hand.add(d.pickRandom());
        System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
        value = gethandsValue();
        System.out.println("Hand's value: " + value);
        System.out.println("Draw?");

        while ( (gethandsValue() <= boundary) && !(value >= 21)) {
            this.hand.add(d.pickRandom());
            System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
            value = gethandsValue();
            System.out.println("Hand's value: " + value);

            if (value > 21) {
                System.out.println("Value>21");

            } else if (value == 21) {
                System.out.println("21!");
                return value;
            } else
                System.out.println("Draw?");
        }
        input.close();
        return value;
    }

   /* public int dealRisky(Deck d) {      // method for risky dealing
        Scanner input = new Scanner(System.in);
        int value;
        System.out.println("Dealing with:\t" + this.getName());

        this.hand.add(d.pickRandom());
        System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
        value = this.gethandsValue();
        System.out.println("Hand's value: " + value);
        System.out.println("Draw?");

        while (NotmannaLogic() && !(value >= 21)) {
            {

                this.hand.add(d.pickRandom());
                System.out.println("Picked: " + this.hand.get(this.hand.size() - 1));
                value = this.gethandsValue();
                System.out.println("Hand's value: " + value);

                if (value > 21) {
                    System.out.println("Value>21");

                } else if (value == 21) {
                    System.out.println("21!");
                    return value;
                } else
                    System.out.println("Draw?");

            }


        }

        return value;

    }*/


    /*public boolean mannaLogic() {
        return this.gethandsValue() <= 16 ;
    }

    public boolean NotmannaLogic() {
        if (this.gethandsValue() <= 17) return true;
        else return false;
    }*/

    public int gethandsValue() {        //calculates hand's value
        int value = 0;

        if (acesCount() == 0) {

            for (Card hand1 : this.hand) {
                value += hand1.getValue();
            }
            return value;

        } else //ace counts as 11 or 1
        {

            for (Card hand1 : this.hand) {
                value += hand1.getValue(); //handsValue with ace=1
            }
            if ((value + 10) > 21) {

                return value;
            } else
                value = value + 10;
            return value;
        }
    }


    public int compareHandsValue(Player p) {
        if (this.gethandsValue() > 21 && p.gethandsValue() > 21) {
            System.out.println(this.toString() + "\n" + p.toString());
            System.out.println("Winner: No one");
            return 0;

        } else if (this.gethandsValue() > 21 && p.gethandsValue() <= 21) {
            System.out.println(this.toString() + "\n" + p.toString());
            System.out.println("Winner: " + p.toString());
            return -1;
        } else if (this.gethandsValue() <= 21 && p.gethandsValue() > 21) {
            System.out.println(this.toString() + "\n" + p.toString());
            System.out.println("Winner: " + this.toString());
            return 1;
        } else if (this.gethandsValue() <= 21 && p.gethandsValue() <= 21)

            if (this.gethandsValue() < p.gethandsValue()) {
                System.out.println(this.toString() + "\n" + p.toString());
                System.out.println("Winner: " + p.toString());
                return -1;
            } else if (this.gethandsValue() > p.gethandsValue()) {
                System.out.println(this.toString() + "\n" + p.toString());
                System.out.println("Winner: " + this.toString());
                return 1;
            } else
                System.out.println(this.toString() + "\n" + p.toString());
        if (this.hand.size() < p.hand.size()) {
            System.out.println("Winner: " + this.toString() + "\nFewer cards");
            return 1;
        } else if (this.hand.size() > p.hand.size()) {
            System.out.println("Winner: " + p.toString() + "\nFewer cards");
            return -1;
        } else
            System.out.println("Winner: No one");
        return 0;


    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void clearHand() {
        this.hand.clear();
    }

    @Override
    public String toString() {
        String temp = "Paikths: " + this.getName() + " Xeri: " + this.gethandsValue();
        return temp;
    }

}
