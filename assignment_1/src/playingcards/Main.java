package playingcards;

public class Main {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();
        for (Card card : d.cards) {
            System.out.println(card.toString());
        }
    }
}
