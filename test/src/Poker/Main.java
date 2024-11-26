package Poker;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        Card cardSpade1 = new Card("♠","A");
        Card cardSpade2 = new Card("♠","2");
        Card cardSpade3 = new Card("♠","3");
        Card cardSpade4 = new Card("♠","4");
        Card cardSpade5 = new Card("♠","5");
        Card cardSpade6 = new Card("♠","6");
        Card cardSpade7 = new Card("♠","7");
        Card cardSpade8 = new Card("♠","8");
        Card cardSpade9 = new Card("♠","9");
        Card cardSpade10 = new Card("♠","10");
        Card cardSpade11 = new Card("♠","J");
        Card cardSpade12 = new Card("♠","Q");
        Card cardSpade13 = new Card("♠","K");

        ArrayList<Card> spade = new ArrayList<>();
        spade.add(cardSpade1);
        spade.add(cardSpade2);
        spade.add(cardSpade3);
        spade.add(cardSpade4);
        spade.add(cardSpade5);
        spade.add(cardSpade6);
        spade.add(cardSpade7);
        spade.add(cardSpade8);
        spade.add(cardSpade9);
        spade.add(cardSpade10);
        spade.add(cardSpade11);
        spade.add(cardSpade12);
        spade.add(cardSpade13);

        ArrayList<Card> poker = new ArrayList<>();
        poker.addAll(spade);
        int index = random.nextInt(poker.size());
        Card card = poker.get(index);
        System.out.println(card);
    }
}
