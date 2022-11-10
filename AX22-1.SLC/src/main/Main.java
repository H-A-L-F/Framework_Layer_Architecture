package main;

import utils.FileOperator;

public class Main {
	public Main() {
	}

	public static void main(String[] args) {
		new Main();
		
		FileOperator op = new FileOperator("index.js");
		
		System.out.println("Instantiate:");
		op.searchFunction("Scene");
		op.searchFunction("WebGL");
		
		CompGraphCorrection menu1 = new CompGraphCorrection();
		menu1.playMenu();
	}
}
