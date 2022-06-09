package com.hackaton.war;

import java.util.*;

public class TestDeck {

	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
		Shuffle shuffle = new Shuffle(myDeck);
//		for (Card card: myDeck.getCards()) {
//			card.showCard();
//		}
//		
		ArrayList<Card> player1 = new ArrayList<Card>();
		ArrayList<Card> player2 = new ArrayList<Card>();
		
		for(Card card : shuffle.getShuffle()) {
			if((int)Math.round(Math.random()) == 1) {
				if(player1.size() != 26) {
					player1.add(card);					
				} else {
					player2.add(card);
				}
			} else {
				if(player2.size() != 26) {
					player2.add(card);					
				} else {
					player1.add(card);
				}
			}
		}
		
//		System.out.println("Player 1: " + player1.size());
//		for(Card card : player1) {
//			card.showCard();
//		}
//		System.out.println("Player 2: " + player2.size());
//		for(Card card : player2) {
//			card.showCard();
//		}
		
		ArrayList<Card> garbage = new ArrayList<Card>();
		int i = 0;
		int j = 0;
		while(player1.size() > 0 && player2.size() > 0) {
			System.out.printf("Player 1: %d %d\n", player1.size(), i);
			System.out.printf("Player 2: %d %d\n", player2.size(), j);
			System.out.println("Player 1 card is: " + player1.get(i).getName());
			System.out.println("Player 2 card is: " + player2.get(j).getName());
			garbage.add(player1.get(i));
			garbage.add(player2.get(j));
			if(player1.get(i).getRank() > player2.get(j).getRank()) {
//				System.out.println("Player 1 is higher");
//				player1.addAll(garbage);
				player1.remove(i);
				player2.remove(j);
			}
			else if (player2.get(j).getRank() > player1.get(i).getRank()) {
//				System.out.println("Player 2 is higher");
//				player2.addAll(garbage);
				player1.remove(i);
				player2.remove(j);
			} else {
//				System.out.println("WAR!!");
				if(player1.size() < 4 && player2.size() < 4) {
					break;
				}
				boolean war = true;
				while(war) {
					if(i+1 >= player1.size()) {
						i = 0;
					}
					if(j+1 >= player2.size()) {
						j = 0;
					}
//					System.out.println("I");
					garbage.add(player1.get(i+1));
					garbage.add(player2.get(j+1));
					player1.remove(i+1);
					player2.remove(j+1);
					
					if(i+2 >= player1.size()) {
						i = 0;
					}
					if(j+2 >= player2.size()) {
						j = 0;
					}
//					System.out.println("declare");
					garbage.add(player1.get(i+1));
					garbage.add(player2.get(j+1));
					player1.remove(i+1);
					player2.remove(j+1);
					
					if(i+3 >= player1.size()) {
						i = 0;
					}
					if(j+3 >= player2.size()) {
						j = 0;
					}
//					System.out.println("war");
					garbage.add(player1.get(i+1));
					garbage.add(player2.get(j+1));
					player1.remove(i+1);
					player2.remove(j+1);
					
					if(i+4 >= player1.size()) {
						i = 0;
					}
					if(j+4 >= player2.size()) {
						j = 0;
					}
					
					System.out.println("War Player 1 card is " + player1.get(i+1).getName());
					System.out.println("War Player 2 card is " + player2.get(j+1).getName());
					
					if(player1.get(i+1).getRank() > player2.get(j+1).getRank()) {
//						System.out.println("War Player 1 is higher");
//						player1.addAll(garbage);
						war = false;
					}
					else if (player2.get(j+1).getRank() > player1.get(i+1).getRank()) {
//						System.out.println("War Player 2 is higher");
//						player2.addAll(garbage);
						war = false;
					}
					player1.remove(i+1);
					player2.remove(j+1);
					
				}
			}
			i++;
			j++;
			if(i >= player1.size()) {
				i = 0;
			}
			if(j >= player2.size()) {
				j = 0;
			}
		}
		System.out.println("Player 1: " + player1.size());
//		for(Card card : player1) {
//			card.showCard();
//		}
		System.out.println("Player 2: " + player2.size());
//		for(Card card : player2) {
//			card.showCard();
//		}
	}
}
