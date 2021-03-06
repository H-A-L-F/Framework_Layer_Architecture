package main;

import models.Restaurant;
import utils.CustPrompt;
import validators.ValidInRange;

public class Main {
	private CustPrompt prompt;
	private ValidInRange validInRange;
	private Restaurant restaurant;
	
	public static Main main;
	
	private Main() {
		prompt = new CustPrompt();
		validInRange = new ValidInRange(0, 0);
	}
	
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
		
		return prompt.getInt("Input menu [1..3]", validInRange.setMinMax(1, 3));
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
				
				String restName = prompt.getString("Input restaurant name [3..15]", validInRange.setMinMax(3, 15));
				
				restaurant = Restaurant.getCurrRestaurant(restName);
				restaurant.start();
				
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
	
	private void titlePause() {
		System.out.println();
		System.out.println("Pause Menu ==============");
		System.out.println();
	}
	
	private int optPause() {
		System.out.println("1. Continue Business");
		System.out.println("2. Upgrade Restaurant");
		System.out.println("3. Close Business");
		
		return prompt.getInt("Input menu [1..3] : ", validInRange.setMinMax(1, 3));
	}
	
	public void menuPause() {
		int opt = 0;
		boolean run = true;
		
		while (run) {
			clear();
			titlePause();
			restaurant.printStats();
			
			opt = optPause();
			
			switch (opt) {
			case 1: {
				// CONTINUE BUSINESS
				System.out.println("Continue...");
				restaurant.continueBusiness();
				break;
			}
			case 2: {
				// UPGRADE RESTAURANT
				break;
			}
			default: {
				// CLOSE BUSINESS
				break;
			}
			}
		}
	}
	
	public static void main(String[] args) {
		Main.main = new Main();
		
		Main.main.init();
	}
}
