package Project;

public class SuitedCard extends CardSuperItem{	
	//This class needs to be completed for the second part of the coursework (Difficulty #2: Include Face Cards)

	
	//This second difficulty is designed to be a more difficult task for students to show their understanding.
	//As such, you are expected to solve this problem using the knowledge you have learnt from the teaching materials
	//and completing Difficulty #1. Do not attempt to solve this until you have the rest working!
	
	//Examples of expected behaviour including this class can be found in Appendix D and E in the coursework specification
	
	public SuitedCard(int value, String cardName, String suit) {
		super(value, cardName, suit);
	}
	
	//@Override
	public int applyCardEffect() {
		if(getValue()!=-1) {
			//for Black cards
			if(getSuit().equalsIgnoreCase("spades")||getSuit().equalsIgnoreCase("clubs")) {
				System.out.println("You drew "+getCardName()+" of "+getSuit());
				return getValue();
			//for Red cards
			}else {
				System.out.println("You drew "+getCardName()+" of "+getSuit());
				System.out.println("Awesome, it was a red card so half that value gets deducted!");
				return -(getValue()/2);
			}			
		}else {
			//for King effect
			if(getCardName().equalsIgnoreCase("a king")) {
				System.out.println("You drew "+getCardName()+" of "+getSuit());
				System.out.println("Yikes, a King! The value of the next card will be doubled!");
				return -97;
			//for Queen effect	
			}else if(getCardName().equalsIgnoreCase("a queen")) {
				System.out.println("You drew "+getCardName()+" of "+getSuit());
				System.out.println("Oh no a Queen! Your total has been doubled!");
				return -98;
			//for Jack effect
			}else {
				System.out.println("You drew "+getCardName()+" of "+getSuit());
				System.out.println("Ooh a Jack! Your total has been halved!");
				return -99;
			}
		}
	}

	//@Override
	public void printCardDetails() {
		System.out.println(getCardName()+" of "+getSuit());
	}
}
