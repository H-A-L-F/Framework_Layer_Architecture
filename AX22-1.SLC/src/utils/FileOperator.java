package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

public class FileOperator {
	private File file;
	private Scanner sc;
	private Vector<String> lines;
	
	public FileOperator(String url) {
		super();
		this.file = new File(url);
		this.lines = new Vector<String>();
		
		loadFile();
	}
	
	private void open() {
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
	}
	
	private void close() {
		sc.close();
	}
	
	private void loadFile() {
		open();
		
		while (sc.hasNextLine()) {
			String buffer = sc.nextLine();
			lines.addAll(Arrays.asList(buffer.split("\n")));
		}
		
		close();
	}
	
	public void viewFile() {
		for (String string : lines) {
			System.out.println(string);
		}
	}
	
	public void searchLine(String key) {
		List<String> res = lines.stream()
				.filter(str -> str.contains(key))
				.collect(Collectors.toList());
		
		for (String string : res) {
			System.out.println(string);
		}
	}
	
	public void searchFunction(String key) {
//		List<String> res = lines.stream()
//				.filter(str -> {
//					return str.contains(key);
//				})
//				.collect(Collectors.toList());
		
		Vector<String> res = new Vector<String>();
		for(int i = 0; i < lines.size(); i++) {
			String curr = lines.get(i);
			if(!curr.contains(key)) continue;
			res.add(curr);
			if(curr.contains("(") && curr.contains(")")) continue;
			for(int j = i + 1; j < lines.size(); j++) {
				curr = lines.get(j);
				res.add(curr);
				if(curr.contains(")")) break;
			}
		}
		
		for (String string : res) {
			System.out.println(string);
		}
	}
}
