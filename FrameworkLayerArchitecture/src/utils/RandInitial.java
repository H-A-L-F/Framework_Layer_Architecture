package utils;

import java.util.ArrayList;
import java.util.Collections;

public class RandInitial {
	// 26C2 * 2! = 650
	private ArrayList<String> list;

	public RandInitial() {
		super();
		this.list = new ArrayList<String>();
		genList();
	}
	
	private void genList() {
		for(int i = 65; i < 91; i++) {
			for(int j = 65; j < 91; j++) {
				String str = Character.toString(i) + Character.toString(j);
				addInitial(str);
			}
		}
	}
	
	public String getRandInitial() {
		Collections.shuffle(list);
		String ret = list.get(0);
		list.remove(0);
		return ret;
	}
	
	public void addInitial(String str) {
		if(!list.contains(str)) this.list.add(str);
	}
	
	public void removeInitial(String str) {
		if(list.contains(str)) this.list.remove(str);
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

}
