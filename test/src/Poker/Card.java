package Poker;

public class Card {
    private String suit;
    private String num;

    @Override
    public String toString() {
        return this.suit+this.num;
    }

    public Card(String suit, String num){
        this.suit=suit;
        this.num=num;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getSuit() {
        return suit;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}
