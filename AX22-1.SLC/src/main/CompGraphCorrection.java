package main;

import menu.Menu;
import utils.DirectoryOperator;
import utils.FileOperator;

public class CompGraphCorrection extends Menu {
	
	public CompGraphCorrection() {
		super();
		
		setTitle("\r\n"
				+ "█▀▀ █▀█ █▀▄▀█ █▀█ █▀▀ █▀█ ▄▀█ █▀█ █░█   ▄▄   ▄▀█ ▀▄▀\r\n"
				+ "█▄▄ █▄█ █░▀░█ █▀▀ █▄█ █▀▄ █▀█ █▀▀ █▀█   ░░   █▀█ █░█\r\n");
		
		addMenu(new Menu() {
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void execute() {
				DirectoryOperator dir = new DirectoryOperator("E:\\Codes\\Correction\\COMP6583001-Computer Graphics_BA01\\BA01");
				FileOperator fileOp = dir.traversing();
				
//				ScoringComponent sc = new ScoringComponent("Instantiate");
//				sc.addComponent(new Component("Scene"));
//				sc.addComponent(new Component("WebGL"));
//				sc.addComponent(new Component("renderer."));
//				sc.addComponent(new Component("appendChild"));
//				sc.correction(fileOp);
				
				System.out.println("Scene and Renderer");
				fileOp.searchFunction("Scene");
				fileOp.searchFunction("WebGL");
				System.out.println("==================================");
				fileOp.searchFunction("renderer.setSize");
				System.out.println("==================================");
				fileOp.searchFunction("antialias");
				System.out.println("==================================");
				fileOp.searchFunction("renderer.shadowMap");
				System.out.println("==================================");
				fileOp.searchFunction("renderer.render");
				System.out.println("==================================");
				
				System.out.println("Camera");
				fileOp.searchFunction("PerspectiveCamera");
				System.out.println("==================================");
				fileOp.searchFunction("position");
				System.out.println("==================================");
				fileOp.searchFunction("lookAt");
				System.out.println("==================================");
				
			}
		}.setSubtitle("Correction"));
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
