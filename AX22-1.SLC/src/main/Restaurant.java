package main;

import java.util.Vector;

public class Restaurant {
	private Vector<Worker> workers;
	private static Restaurant instance;
	
	private Restaurant() {
		this.workers = new Vector<Worker>();
	}
	
	public static Restaurant getInstance() {
		if (instance == null) instance = new Restaurant();
		return instance;
	}
	
	public void addWorker(Worker worker) {
		workers.add(worker);
	}
	
	public void printWorker() {
		System.out.printf("╔═══════╤══════════════════════╤════════╤════════════════════════════════╗\r\n");
		System.out.printf("║ %-5s │ %-20s │ %-6s │ %-30s ║\r\n", "ID", "Name", "Gender", "Email");
		System.out.printf("╠═══════╪══════════════════════╪════════╪════════════════════════════════╣\r\n");
		for (Worker worker : workers) {
			System.out.printf("║ %-5s │ %-20s │ %-6s │ %-30s ║\r\n", worker.getWorkerId(), worker.getName(), worker.getGender(), worker.getEmail());
		}
		System.out.printf("╚═══════╧══════════════════════╧════════╧════════════════════════════════╝\r\n");
	}
	
	public Vector<String> getIds() {
		Vector<String> ids = new Vector<String>();
		for (Worker worker : workers) {
			ids.add(worker.getWorkerId());
		}
		return ids;
	}
	
	public void removeWorker(String id) {
		for (Worker worker : workers) {
			if(worker.getWorkerId().equals(id)) {
				workers.remove(worker);
				return;
			}
		}
	}
}
