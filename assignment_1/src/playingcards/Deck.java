package playingcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public final List<Card> cards;

    public Deck() {
        this.cards = constructDeckCards();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private static List<Card> constructDeckCards() {
        final List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                final Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        return cards;
    }
}
