package states;

import java.util.Scanner;

import models.Entity;

public class StateRun extends State implements Runnable{
	private Scanner in;
	private Thread t;
	private String tName;
	
	public StateRun(Entity entity) {
		super(entity);
		this.in = new Scanner(System.in);
		this.tName = "StateRun";
	}
	
	@Override
	public void execute() {
		initThread();
		start();
	}

	public void initThread() {
		System.out.println("Creating " + tName);
	}
	
	@Override
	public void run() {
		in.nextLine();
		getEntity().changeState(new StatePause(getEntity()));
	}

	public void start() {
		System.out.println("Starting " + tName);
		if(t == null) {
			t = new Thread(this, tName);
			t.start();
		}
	}
	
}
