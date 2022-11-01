package utils;

import java.util.Scanner;

import lib.ValidatorInt;
import lib.ValidatorString;

public class CustPrompt {
	Scanner in;

	public CustPrompt() {
		this.in = new Scanner(System.in);
	}
	
	public int getInt(String str, ValidatorInt validator) {
		int ret = 0;
		do {
			System.out.printf(str);
			ret = in.nextInt();
			in.nextLine();
		} while (!validator.isValid(ret));
		return ret;
	}
	
	public String getString(String str, ValidatorString validator) {
		String ret = "";
		do {
			System.out.printf(str);
			ret = in.nextLine();
		} while (!validator.isValid(ret));
		return ret;
	}
	
	public void pressEnter() {
		System.out.printf("Press Enter to Continue ... ");
		in.nextLine();
	}
	
	public void close() {
		in.close();
	}
}
