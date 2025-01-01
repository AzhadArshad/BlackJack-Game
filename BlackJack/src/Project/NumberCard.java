package Project;

public class NumberCard extends CardSuperItem{

	//This class needs to be completed for the first part of the coursework (Difficulty #1: Number Cards Only)
	//Remember, this needs to be a subclass of the abstract CardSuperItem class!
	//YOU SHOULD NOT ADD ANY ADDITIONAL DATA FIELDS IN EITHER SUBCLASS!


	//To complete this class and complete Difficulty #1 you will have to:
	//1. Create the correct constructor so the class can be instantiated
	
	public NumberCard(int value, String cardName) {
		 super(value, cardName);
		
	}
	
	//2. Override both methods in the superclass with the behaviours expected in the courseworks specification
	//@Override
	public int applyCardEffect() {
		System.out.println("You drew "+getCardName());		
		return getValue();
	}

	//@Override
	public void printCardDetails() {
		System.out.println(getCardName());		
	}
	
	
	//Hint: For each of the overriden methods in point 2 you will need to use getter methods you create in the superclass
	//      in order to get access to the data fields. You can use this to both print messages, and solve the "Extra
	//		Complexity" tasks.
		
	//Examples of expected behaviour including this class can be found in Appendix A, B, and C, in the coursework specification
}
