package main;

import java.util.AbstractList;

import lib.ValidEmail;
import lib.ValidInCollection;
import lib.ValidInOption;
import lib.ValidInRange;
import menu.Menu;

public class HomeMenu extends Menu {
	private Restaurant restaurant;
	
	public HomeMenu() {
		super();
		this.restaurant = Restaurant.getInstance();
		
		setTitle("\r\n"
				+ "▄▀█ ▀▄▀ █▀▀ █▀█ █▀█ █▀█ ▄▀█ ▀█▀ ▀█▀ █▄█   ▄▄   █░█ █▀▀\r\n"
				+ "█▀█ █░█ █▀░ █▄█ █▀▄ █▀▀ █▀█ ░█░ ░█░ ░█░   ░░   █▀█ █▄▄\r\n");
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				String name = getIn().getString("Input worker name [5..20]: ", new ValidInRange(5, 20));
				String gender = getIn().getString("Input worker gender [Male | Female]: ", new ValidInOption(new String[] {"Male", "Female"}));
				String email = getIn().getString("Input email (must contains @ and ends with .com): ", new ValidEmail());
				
				restaurant.addWorker(new Worker(name, gender, email));
			}
		}.setSubtitle("Register new worker"));
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				restaurant.printWorker();
				getIn().pressEnter();
			}
		}.setSubtitle("View all worker"));
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				restaurant.printWorker();
				
				AbstractList<String> cols = restaurant.getIds();
				cols.add("back");
				String id = getIn().getString("Input worker ID [\"back\" to back]", new ValidInCollection(cols));
				
				if(id.equals("back")) return;
				
				restaurant.removeWorker(id);
			}
		}.setSubtitle("Fire worker"));
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
	
	
}
