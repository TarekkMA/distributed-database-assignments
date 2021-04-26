package playingcards;

public class Card {
    public final Rank rank;
    public final Suit suit;

    public Card( Suit suit,Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
