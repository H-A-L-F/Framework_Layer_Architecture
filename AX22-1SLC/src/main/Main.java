package main;

import lib.ValidInOption;
import lib.ValidInRange;
import utils.CustPrompt;

public class Main {
	CustPrompt in;
	
	public Main() {
		this.in = new CustPrompt();
		
//		in.getInt("Input a number [1..5]: ", new ValidInRange(1, 5));
		in.getString("Choose a type [Fire | Water]: ", new ValidInOption(new String[] {"Fire", "Water"}));
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
