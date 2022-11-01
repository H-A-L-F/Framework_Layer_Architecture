package main;

import java.util.ArrayList;

import menu.Menu;

public class AXForPatty extends Menu {
	
	public AXForPatty() {
		// TODO Auto-generated constructor stub
		super();
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("Misalnya nambahin menu");
				getIn().pressEnter();
			}
		}.setSubtitle("Add menu"));
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("Misalnya view menu");
				getIn().pressEnter();
			}
		}.setSubtitle("View Menu"));
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
