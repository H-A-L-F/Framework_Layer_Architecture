package main;

public class GameMaster implements Runnable {
	private Thread t;
	private String tName;
	
	public GameMaster() {
		tName = "Master Thread";
		System.out.println("Creating " + tName);
	}

	@Override
	public void run() {
		// GAME MASTER JOB
		
	}
	
	public void start() {
		System.out.println("Starting " + tName);
		if(t == null) {
			t = new Thread(this, tName);
			t.start();
		}
	}
}
