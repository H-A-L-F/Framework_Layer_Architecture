package models;

import utils.RandInitial;
import states.State;
import states.StatePause;
import states.StateRun;

public class Restaurant extends Entity implements Runnable{
	private RandInitial initialStorage;
	
	private int money, score, size;
	private boolean run;
	
	private Thread t;
	private String tName;
	
	public static Restaurant currRestaurant;

	private Restaurant(String name, int money, int score, int size) {
		super(name);
		this.initialStorage = new RandInitial();
		this.money = money;
		this.score = score;
		this.size = size;
		this.run = true;
		
		initThread();
	}
	
	private Restaurant(String name) {
		super(name);
		this.initialStorage = new RandInitial();
		this.money = 1300; 
		this.score = 0;
		this.size = 4;
		this.run = true;
		
		initThread();
	}
	
	public void initThread() {
		tName = "Master Thread";
		System.out.println("Creating " + tName);
	}
	
	@Override
	public void run() {
		// TUGAS GAME MASTER
		// PRINT GAME VIEW
		try {
			if(run) {
				System.out.println("Playing...");
			}
			
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		System.out.println("Starting " + tName);
		
		changeState(new StatePause(this));
		
		if(t == null) {
			t = new Thread(this, tName);
			t.start();
		}
	}
	
	public static Restaurant getCurrRestaurant(String name, int money, int score, int size) {
		if(Restaurant.currRestaurant == null) Restaurant.currRestaurant = new Restaurant(name, money, score, size);
		return Restaurant.currRestaurant;
	}
	
	public static Restaurant getCurrRestaurant(String name) {
		if(Restaurant.currRestaurant == null) Restaurant.currRestaurant = new Restaurant(name);
		return Restaurant.currRestaurant;
	}
	
	@Override
	public void changeState(State state) {
		super.changeState(state);
		run = !run;
	}

	public void printStats() {
		System.out.println();
		System.out.println("Status");
		System.out.println("Money : Rp. " + this.money);
		System.out.println("Score : " + this.score + " Points");
		System.out.println("Size  : " + this.size + " Seats");
		System.out.println();
	}
	
	public void continueBusiness() {
		changeState(new StateRun(this));
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
