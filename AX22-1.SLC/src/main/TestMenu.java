package main;

import menu.Menu;

public class TestMenu extends Menu {
	
	public TestMenu() {
		super();
		
		Menu addMenu = new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("Misalnya nambahin menu baru");
				getIn().pressEnter();
			}
		};
		addMenu.setSubtitle("Add Menu");
		
		addMenu(addMenu);
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("View Menu");
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
