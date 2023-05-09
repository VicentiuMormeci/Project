package org.example;

public class MetodaPlata {
    private String card;
    private String cash;

    public MetodaPlata(String card, String cash) {
        this.card = card;
        this.cash = cash;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "MetodaPlata{" +
                "card='" + card + '\'' +
                ", cash='" + cash + '\'' +
                '}';
    }
}
