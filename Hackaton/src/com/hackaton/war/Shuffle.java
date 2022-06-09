package com.hackaton.war;

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
	
	private ArrayList<Card> shuffle;
	
	public Shuffle(Deck myDeck) {
		shuffle = new ArrayList<Card>();
		
		Random rand = new Random();
		for(int i = 0; i < 52; i++) {
			int j = rand.nextInt(52);
			Card card = myDeck.getCards().get(i);
			Card switchCard = myDeck.getCards().get(j);
			myDeck.getCards().set(i, switchCard);
			myDeck.getCards().set(j, card);
			
		}
		
		shuffle.addAll(myDeck.getCards());
	}

	public ArrayList<Card> getShuffle() {
		return shuffle;
	}

	public void setShuffle(ArrayList<Card> shuffle) {
		this.shuffle = shuffle;
	}
	
}
