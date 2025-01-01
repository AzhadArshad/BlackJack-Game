package Project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
	//DO NOT CHANGE THIS ARRAYLIST! 
	public static ArrayList<CardSuperItem> drawDeck= new ArrayList<>();;
	//DO NOT CHANGE THIS ARRAYLIST!
	
	//YOU NEED TO ADD A NEW ARRAYLIST HERE TO REPRESENT THE CARDS IN A PLAYER'S HAND (see name from coursework)
	public static ArrayList<CardSuperItem> cardsInHand= new ArrayList<>();;
	
	public static int loopCount=0; //needed later to solve Extra Complexities
	
	public static boolean kingDrawn = false; //needed later for the King effect
	
	public static void main(String[] args) 
	{
		/**
		 * STEP 0: The code below WILL NOT COMPILE. Fix it, so you have the correct local variables. For later tasks you might need to add
		 * 	       variables here too. See coursework spec.
		 */
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int currentHandTotal=0;
		int randomNumber; 
		CardSuperItem drawnCard;
		
		System.out.println("Welcome to Weird Blackjack! Your aim is to draw as many cards as you can, without going over a value of 21!");
		System.out.println("Select which you want to play with:\n1. Number Cards Only\n2. Include Face Cards");
		int gameMode = sc.nextInt();
		/**
		 * STEP 1: You should create your deck of cards for the game here, based upon the player's response above.
		 *         To do this, you should call a version of createDeckOfCards() you have completed or created depending on mode chosen.
		 */
		if(gameMode==1) {			
			createDeckOfCards();	
		} else if(gameMode==2) {
			createDeckOfCards(4);

		} else {
			System.out.println("Invalid Option Selected");
			
		}

		
		
		/**
		 * STEP 2: You should now draw a card for the player, apply its effects (if any) and put it in their hand. Remember to check if they've gone bust!
		 * 	       HINT: cards should be removed from drawDeck when drawn, so you cannot draw the same card twice, and
		 * 		         then put in another ArrayList to track the cards the player has drawn.
		 */
		while(drawDeck.size()!=0 && gameMode==1/* You will need to complete this while loop! */) {
			//Code for drawing cards and resolving their effects goes here...
			
			randomNumber = random.nextInt(0,drawDeck.size()); //needed to generate a random card from the drawDeck
			
			drawnCard = drawDeck.get(randomNumber); //draws a random card from the drawDeck
			
			currentHandTotal +=drawnCard.applyCardEffect();
			
			//updation
			cardsInHand.add(drawnCard);
			drawDeck.remove(randomNumber);
			

			//Code for checking whether they've got Blackjack, or gone bust should go here. If they haven't, ask if they want to draw again as per coursework spec!
			/**
			 * STEP 3: Finally you should tell the players how they've done. Remember there are three possible outcomes:
			 *         * They got Blackjack (exactly 21)
			 *         * They went bust (over 21)
			 *         * They decided to stop drawing cards!
			 */
			
			//solving extra complexities
			String plural="";
		    loopCount++;
		    if(loopCount!=1) plural = "s";
		    
		    if(currentHandTotal<21) {
		    	System.out.println("You are still in this! You have "+cardsInHand.size()+" card"+plural+" in hand, and a total of "+currentHandTotal+ ".\n"+
		    	"Do you want to draw again? Yes or No");
		    	String yesOrNo = sc.next();
		    	if(yesOrNo.equalsIgnoreCase("yes")) {
		    		System.out.println("Okay, drawing a new card:");
		    		continue;
		    	}else if(yesOrNo.equalsIgnoreCase("no")){
		    		System.out.println("Phew, you have stopped drawing cards!\nYou drew " +cardsInHand.size() +" card"+plural+" and had a total of "+currentHandTotal+ " in hand!");
		    		break;
		    	}else {
		    		System.out.println("invalid input");
		    		break;
		    	}
		    }else if(currentHandTotal==21) {
		    	System.out.println("Blackjack! You got exactly 21, well done!");
		    	System.out.println("You drew "+ cardsInHand.size() +" cards before getting Blackjack. Well done!");
		    	break;
		    }else {
		    	System.out.println("Oh no! You've gone bust with a score of "+ currentHandTotal +"!\nYou drew "+cardsInHand.size()+ " cards before losing. Better luck next time!");
		    	break;
		    }
		   
		}
		
		//For game mode 2 & Difficulty #2
		while(drawDeck.size()!=0 && gameMode==2){
			randomNumber = random.nextInt(0,drawDeck.size()); //needed to generate a random card from the drawDeck
			
			drawnCard = drawDeck.get(randomNumber); //draws a random card from the drawDeck
			
			//updation
			cardsInHand.add(drawnCard);
			drawDeck.remove(randomNumber);
			
			int temp = drawnCard.applyCardEffect();
			
			if(temp==-99) {
				currentHandTotal=currentHandTotal/2; //jack effect
				kingDrawn = false;  // Resetting in case a jack follows a king
			}else if(temp==-98) {
				currentHandTotal=currentHandTotal*2; //queen effect
				kingDrawn = false;  // Resetting in case a queen follows a king
			}else if(temp==-97){
				kingDrawn = true;  //king effect
		
			}else if(kingDrawn && drawnCard.getValue()>0){
				if(temp<0) {
					temp = temp*2;
				}else {
					temp = temp*2;				
				}
				currentHandTotal+=temp;
				kingDrawn = false;  // Resetting
				
			}else {
				currentHandTotal+=temp;
			}
			
			//extra complexities
			String plural="";
		    loopCount++;
		    if(loopCount!=1) plural = "s";
			
			if(currentHandTotal<21) {
		    	System.out.println("You are still in this! You have "+cardsInHand.size()+" card"+plural+" in hand, and a total of "+currentHandTotal+
		    	".\nDo you want to draw again? Yes or No");
		    	String yesOrNo = sc.next();
		    	if(yesOrNo.equalsIgnoreCase("yes")) {
		    		System.out.println("Okay, drawing a new card:");
		    		continue;
		    	}else if(yesOrNo.equalsIgnoreCase("no")){
		    		System.out.println("Phew, you have stopped drawing cards!\nYou drew " +cardsInHand.size() +" card"+plural+" and had a total of "+currentHandTotal+ " in hand!");
		    		break;
		    	}else {
		    		System.out.println("invalid input");
		    		break;
		    	}
		    }else if(currentHandTotal==21) {
		    	System.out.println("Blackjack! You got exactly 21, well done!");
		    	System.out.println("You drew "+ cardsInHand.size() +" cards before getting Blackjack. Well done!");
		    	break;
		    }else {
		    	System.out.println("Oh no! You've gone bust with a score of "+ currentHandTotal +"!\nYou drew "+cardsInHand.size()+ " cards before losing. Better luck next time!");
		    	break;
		    }
			
	}
		
		if(drawDeck.size()==0) System.out.println("All Cards have been drawn out");
		
		//Remember to print all the cards in a player's hand here, and to close any scanners you've opened!
		for(int i=0;i<cardsInHand.size();i++) {
		cardsInHand.get(i).printCardDetails();
		}
		sc.close();
	}
	
	private static void createDeckOfCards()
	{
		//This should fill the drawDeck variable with the expected number of card objects. for Difficulty #1.
		//This initial version should just create the correct number of NumberCards, with the expected values of 1 to 6, as in the coursework specification
		
		//Hint: When adding a new NumberCard to the drawDeck ArrayList, make sure you call the correct Constructor as explained in the teaching materials!
		//      You should use the the two arrays from the CardDetails class to determine the values and related card names. 
		int[] cardValues = {1, 2, 3, 4, 5, 6};
		String[] cardsNames = {"an Ace", "a Deuce", "a Trey","a Four", "a Five", "a Six"};
		
		for(int i =0;i<cardValues.length;i++) {
			for(int j=0;j<3;j++) {
				drawDeck.add(new NumberCard(cardValues[i],cardsNames[i]));
				}
		}
	}
	
	//For Difficulty #2 you should create a new method here which overloads createDeckOfCards(). This method will create SuitedCards,
	//instead of NumberCards. There are more details in the coursework specification about how to do this.
	//MAKE SURE YOU DIFFICULTY #1 IS FULLY WORKING BEFORE ATTEMPTING THIS!
	private static void createDeckOfCards(int numberOfSuits) {
		int[] cardValues = {1, 2, 3, 7, 8, 9};
		String[] cardsNames = {"an Ace", "a Deuce", "a Trey","a Seven", "an Eight", "a Niners"};
	    String[] faceCards = {"a Jack", "a Queen", "a King"};
	    String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
	    
	    for(int i=0;i<suits.length;i++) {
	    	for(int j=0;j<cardValues.length;j++) {
	    		drawDeck.add(new SuitedCard(cardValues[j],cardsNames[j],suits[i]));
	    	}
	    	for(int j=0;j<faceCards.length;j++) {
	    		drawDeck.add(new SuitedCard(-1,faceCards[j],suits[i]));
	    	}
	    }
		
	}
	

}
