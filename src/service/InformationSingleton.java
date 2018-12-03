package service;

public class InformationSingleton {

    private static InformationSingleton informationSingleton;
    private int numberOfCardsHorizontal;
    private int numberOfCardsVertical;
    private int countErrors;

    private InformationSingleton() {
        numberOfCardsHorizontal = 2;
        numberOfCardsVertical = 2;
        countErrors = 0;
    }

    public static InformationSingleton getInformationSingleton() {
        if(informationSingleton == null) {
            informationSingleton = new InformationSingleton();
        }

        return informationSingleton;
    }

    public void incrementCountErrors() {
        countErrors++;
    }

    public void resetCountErrors() {
        countErrors = 0;
    }

    public Integer getCountErrors() {
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
