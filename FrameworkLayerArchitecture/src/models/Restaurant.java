package models;

import utils.RandInitial;

public class Restaurant {
	private RandInitial initialStorage;
	private String name;
	private int money, score, size;
	
	public static Restaurant currRestaurant;

	private Restaurant(String name, int money, int score, int size) {
		super();
		this.initialStorage = new RandInitial();
		this.name = name;
		this.money = money;
		this.score = score;
		this.size = size;
	}
	
	private Restaurant(String name) {
		super();
		this.initialStorage = new RandInitial();
		this.name = name;
		this.money = 1300; 
		this.score = 0;
		this.size = 4;
	}
	
	public static Restaurant getCurrRestaurant(String name, int money, int score, int size) {
		if(Restaurant.currRestaurant == null) Restaurant.currRestaurant = new Restaurant(name, money, score, size);
		return Restaurant.currRestaurant;
	}
	
	public static Restaurant getCurrRestaurant(String name) {
		if(Restaurant.currRestaurant == null) Restaurant.currRestaurant = new Restaurant(name);
		return Restaurant.currRestaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public RandInitial getInitialStorage() {
		return initialStorage;
	}

	public void setInitialStorage(RandInitial initialStorage) {
		this.initialStorage = initialStorage;
	}
	
}
