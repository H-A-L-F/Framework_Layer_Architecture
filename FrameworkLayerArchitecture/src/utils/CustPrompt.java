package utils;

import java.util.Scanner;

import validators.Validator;

public class CustPrompt {
	Scanner in;

	public CustPrompt() {
		this.in = new Scanner(System.in);
	}
	
	public int getInt(String str, Validator validator) {
		int ret = 0;
		do {
			System.out.println(str);
			ret = in.nextInt();
			in.nextLine();
		} while (!validator.isValidInt(ret));
		return ret;
	}
	
	public String getString(String str, Validator validator) {
		String ret = "";
		do {
			System.out.println(str);
			ret = in.nextLine();
		} while (!validator.isValidString(ret));
		return ret;
	}
}
