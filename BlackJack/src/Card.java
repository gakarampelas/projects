public class Card {

    private int value; // value to be counted
    private String kind; // Ace, King, Queen, Jack ,Number
    private String colour; // Black or White
    private String quality; // Heart, Club, Diamond, Spade

    public Card(Card temp) {
        this.value = temp.getValue();
        this.kind = temp.getKind();
        this.colour = temp.getColour();
        this.quality = temp.getQuality();
    }

    public Card() {
        this.value = -1;
        this.kind = "";
        this.colour = "";
        this.quality = "";
    }

   /* public Card(int value, String kind, String colour, String quality) {
        this.value = value;
        this.kind = kind;
        this.colour = colour;
        this.quality = quality;
    }*/

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        String r = "Card with value=" + this.getValue();
        if ("Ace".equals(this.getKind())) r += " or 11";
        r += " kind=" + this.getKind() + " colour= " + this.getColour() + " quality=" + this.getQuality() + "\n";
        return r;
    }

}
