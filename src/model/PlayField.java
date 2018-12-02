package model;

import javafx.scene.image.Image;
import service.ImageOpener;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayField {

    private int numberOfCardsHorizontal;
    private int numberOfCardsVertical;
    private ImageOpener imageOpener;

    private List<Card> cards;
    private Card lastSelectedCard;

    public PlayField(int numberOfCardsHorizontal, int numberOfCardsVertical) {
        this.numberOfCardsHorizontal = numberOfCardsHorizontal;
        this.numberOfCardsVertical = numberOfCardsVertical;

        imageOpener = new ImageOpener();
        cards = createCards();
    }

    private List<Card> createCards() {
        List<URI> images = imageOpener.getCardImages();
        List<Card> cards = new ArrayList<>();

        for(int i = 0; i < (numberOfCardsHorizontal * numberOfCardsVertical)/2; i++) {
            Image image = new Image(images.get(i).toString());
            cards.add(new Card(i, image));
            cards.add(new Card(i, image));
        }

        Collections.shuffle(cards);

        return cards;
    }

    public void openCard(Card card) {
        if(!cards.contains(card) || card.isFound())
            return;

        if(lastSelectedCard == null) {
            lastSelectedCard = card;
            return;
        }

        if(card.getCardUuid().equals(lastSelectedCard.getCardUuid()))
            return;

        if(card.getCardId() == lastSelectedCard.getCardId()) {
            card.setFound(true);
            lastSelectedCard.setFound(true);
            lastSelectedCard = null;
        } else {
            lastSelectedCard = null;
        }
    }

    public int getNumberOfCardsHorizontal() {
        return numberOfCardsHorizontal;
    }

    public int getNumberOfCardsVertical() {
        return numberOfCardsVertical;
    }

    public Card getLastSelectedCard() {
        return lastSelectedCard;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Image getHiddenCardImage() {
        return imageOpener.getHiddenCardImage();
    }
}
