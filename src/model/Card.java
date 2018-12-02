package model;

import javafx.scene.image.Image;

public class Card {
    private int cardId;
    private Image imageFile;
    private boolean isFound;

    public Card(int cardId, Image imageFile) {
        this.cardId = cardId;
        this.imageFile = imageFile;
        this.isFound = false;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Image getImageFile() {
        return imageFile;
    }

    public void setImageFile(Image imageFile) {
        this.imageFile = imageFile;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }
}
