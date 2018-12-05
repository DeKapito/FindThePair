package service;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InformationSingleton {

    private static InformationSingleton informationSingleton;
    private int numberOfCardsHorizontal;
    private int numberOfCardsVertical;
    private IntegerProperty countErrors;

    private InformationSingleton() {
        numberOfCardsHorizontal = 2;
        numberOfCardsVertical = 2;
        countErrors = new SimpleIntegerProperty(0);
    }

    public static InformationSingleton getInformationSingleton() {
        if(informationSingleton == null) {
            informationSingleton = new InformationSingleton();
        }

        return informationSingleton;
    }

    public void incrementCountErrors() {
        countErrors.set(countErrors.get() + 1);
    }

    public void resetCountErrors() {
        countErrors.set(0);
    }

    public Integer getCountErrors() {
        return countErrors.getValue();
    }

    public IntegerProperty getCountErrorsProperty() {
        return countErrors;
    }

    public void setNumberOfCards(int numberOfCardsHorizontal, int numberOfCardsVertical) {
        this.numberOfCardsHorizontal = numberOfCardsHorizontal;
        this.numberOfCardsVertical = numberOfCardsVertical;
    }

    public int getNumberOfCardsHorizontal() {
        return numberOfCardsHorizontal;
    }

    public int getNumberOfCardsVertical() {
        return numberOfCardsVertical;
    }
}
