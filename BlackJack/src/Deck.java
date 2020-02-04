
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    static int size = 52; //deck's size by default equals to 52
    private ArrayList<Card> cards;

    public Deck(Deck d) { //copies the deck given 
        cards = new ArrayList<Card>();
        this.cards.addAll(d.cards);
    }

    public Deck(int howManyDecks) {  //mixes *howManyDecks deck's
        cards = new ArrayList<Card>();
        for(int i=0;i<howManyDecks;i++) 
         this.cards.addAll(new Deck().cards);
    }
    

    public Deck() {
        cards = new ArrayList<Card>();
        Card tempCard = new Card(); //temporary card to initialize Deck

        int counter = 0;
        //<------------------------initialisation of numbers------------------------------------
        for (int i = 0; i < 9; i++) {
            tempCard.setKind("Number");
            tempCard.setValue(i + 2); //with value from 2 - 10

            //colour is Black 
            tempCard.setColour("Black");
            for (int j = 0; j < 2; j++) { //and quality is Club, or Spade
                if (j == 0) {
                    tempCard.setQuality("Club");
                }
                if (j == 1) {
                    tempCard.setQuality("Spade");
                }

                cards.add(new Card(tempCard)); //inserts card in deck

            }
            //colour is Red
            tempCard.setColour("Red");
            for (int j = 0; j < 2; j++) { //and quality is Heart, or Diamond
                if (j == 0) {
                    tempCard.setQuality("Heart");
                }
                if (j == 1) {
                    tempCard.setQuality("Diamond");
                }
                cards.add(new Card(tempCard)); //inserts card in deck
                //	

            }
        }
		//------------------------initialisation of numbers------------------------------------>

        //<------------------------initialisation of Aces,King,Queen,Jack---------------------------------------
        for (int i = 0; i < 4; i++) {

            if (i == 0) {
                tempCard.setKind("King");
            }
            if (i == 1) {
                tempCard.setKind("Queen");
            }
            if (i == 2) {
                tempCard.setKind("Jack");
            }
            if (i == 3) {
                tempCard.setKind("Ace");
            }
            tempCard.setColour("Black");
            tempCard.setQuality("Club");
            if (tempCard.getKind().equals("Ace")) {
                tempCard.setValue(1); // toBeChecked value = 1 || value=11 for Ace
            } else {
                tempCard.setValue(10);
            }
            cards.add(new Card(tempCard)); //inserts card in deck

            tempCard.setQuality("Spade");
            cards.add(new Card(tempCard)); //inserts card in deck

            tempCard.setColour("Red");
            tempCard.setQuality("Heart");
            cards.add(new Card(tempCard)); //inserts card in deck

            tempCard.setColour("Red");
            tempCard.setQuality("Diamond");
            cards.add(new Card(tempCard)); //inserts card in deck

        }
		//--------------------------initialisation of Aces,King,Queen,Jack--------------------------------------->		

    }

    public Card pickRandom() { //randomly picks card from deck
        Random rand = new Random();
        int n = rand.nextInt(cards.size()); //arithmos apo to 0 ews kai to size
        return this.cards.remove(n);
    }

    public void shuffle() { //shuffles the deck 
        Deck temp = new Deck(this.cards.size());
        Random rand = new Random();
      
        
        int DecksCount=cards.size(); //xrhsimopoieitai giati to megethos twn arraylist einai metavlhto
        for (int i = 0; i < DecksCount; i++) {
            temp.cards.add(this.cards.remove(rand.nextInt(this.cards.size())));
        }
      
        this.cards = temp.cards;

    }
    public void chances(Deck d){
        for(int i=1;i<11;i++){
            System.out.println("P("+ i +")="+ d.chanceOf(i));
        }
    }
    public double chanceOf(int number){ //chance of drawing a specific value in the deck is #numberAppearances/#currentDecksSize
        
        int currentSize=this.cards.size();
        double appearances=0;
        for (Card card : this.cards) {
            if (card.getValue()==number) {
                appearances+=1;
            }
        }
        double pos;
        pos = appearances / currentSize;
       
        return pos;
    }
   

    @Override
    public String toString() {
        String temp = "";
        for (Card card : cards) {
            temp += card.toString();
        }
        return temp;

    }

}
