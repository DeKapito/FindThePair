package model;

import java.util.List;

public class PlayField {

    private int numberOfCardsHorizontal;
    private int numberOfCardsVertical;

    private List<Card> cards;

    public PlayField(int numberOfCardsHorizontal, int numberOfCardsVertical) {
        this.numberOfCardsHorizontal = numberOfCardsHorizontal;
        this.numberOfCardsVertical = numberOfCardsVertical;
    }

}
