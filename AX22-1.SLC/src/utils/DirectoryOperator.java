package utils;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class DirectoryOperator {
	private String path;
	private File file;
	private Vector<File> files;
	private Scanner in;

	public DirectoryOperator(String path) {
		super();
		this.path = path;
		this.file = new File(path);
		this.files = new Vector<File>(Arrays.asList(file.listFiles()));
		this.in = new Scanner(System.in);
	}
	
	private void loadFile() {
		this.file = new File(path);
		this.files = new Vector<File>(Arrays.asList(file.listFiles()));
	}
	
	public void displayDirectory(File[] files, String prefix) {
		System.out.println("Directory: " + path);
		for (File curr : files) {
            if (curr.isDirectory()) {
                System.out.println(prefix + curr.getName() + "/");
 
//                displayDirectory(curr.listFiles(), prefix + "\t");
            }
 
            else {
                System.out.println(prefix + curr.getName());
            }
		}
	}
	
	public void displayDirectory() {
		System.out.println("Directory: " + path);
		for (File curr : files) {
			if (curr.isDirectory()) {
				System.out.println(curr.getName() + "/");
				
//				displayDirectory(curr.listFiles(), "\t");
			}
			
			else {
				System.out.println(curr.getName());
			}
		}
	}
	
	public FileOperator traversing() {
		displayDirectory();
		
		System.out.printf("[Enter | Open | Exit]: ");
		String str = in.nextLine();
		
		if(str.startsWith("Enter ")) {
			str = str.replace("Enter ", "");
			this.path += "\\" + str;
			loadFile();
			
			return traversing();
		} else if (str.startsWith("Open ")) {
			str = str.replace("Open ", "");
			this.path += "\\" + str;
			
			System.out.println("");
			return new FileOperator(path);
		} else if (str.equals("Exit")) {
			return null;
		}
		
		return null;
	}
}
