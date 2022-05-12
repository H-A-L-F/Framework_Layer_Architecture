package main;

import utils.CustPrompt;
import validators.ValidInRange;

public class Main {
	CustPrompt prompt;
	
	private void clear() {
		for(int i = 0; i < 25; i++) System.out.println();
	}
	
	private void title() {
		System.out.println();
		System.out.println("┏━━━┓╋╋╋┏━━━┓╋╋╋╋╋┏┓");
		System.out.println("┗┓┏┓┃╋╋╋┃┏━┓┃╋╋╋╋┏┛┗┓");
		System.out.println("╋┃┃┃┣━━┓┃┗━┛┣━━┳━┻┓┏╋━━┓");
		System.out.println("╋┃┃┃┃┏┓┃┃┏┓┏┫┃━┫━━┫┃┃┏┓┃");
		System.out.println("┏┛┗┛┃┏┓┃┃┃┃┗┫┃━╋━━┃┗┫┗┛┃");
		System.out.println("┗━━━┻┛┗┛┗┛┗━┻━━┻━━┻━┻━━┛");
		System.out.println();
	}
	
	private void init() {
		// LOAD DATA
		
		menuHome();
	}
	
	private int optHome() {
		System.out.println("1. Play New Restaurant");
		System.out.println("2. High Score");
		System.out.println("3. Exit");
		
		return prompt.getInt("Input menu [1..3]", new ValidInRange(1, 3));
	}
	
	private void menuHome() {
		int opt = 0;
		boolean run = true;
		
		while(run) {
			clear();
			title();
			
			opt = optHome();
			
			switch (opt) {
			case 1: {
				// PLAY NEW RESTAURANT
				
				String restName = prompt.getString("Input restaurant name [3..15]", new ValidInRange(3, 15));
				
				
				break;
			}
			case 2: {
				// HIGH SCORE
				break;
			}
			default: {
				// EXIT
				break;
			}
			}
		}
	}
	
	public Main() {
		prompt = new CustPrompt();
		
		init();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
