package menu;

import java.util.Vector;
import lib.ValidInRange;
import utils.CustPrompt;

public abstract class Menu {
	private String title;
	private String subtitle;
//	private HashMap<Integer, Menu> menus;
	private Vector<Menu> menus;
	
	private CustPrompt in;
	
	public Menu() {
		this.title = new String();
		this.subtitle = new String();
//		this.menus = new HashMap<Integer, Menu>();
		this.menus = new Vector<Menu>();
		
		this.in = new CustPrompt();
	}
	
	private void printTitle() {
		System.out.println(title);
	}
	
	private void clear() {
		for(int i = 0; i < 25; i++) System.out.println();
	}
	
	private void printOpts() {
//		menus.forEach((key, val) -> {
//			System.out.println(key.toString() + " - " + val.subtitle);
//		});
		int size = menus.size();
		int i = 0;
		for (; i < size; i++) {
			Menu curr = menus.get(i);
			System.out.println((i + 1) + " - " + curr.subtitle);
		}
		System.out.println((i + 1) + " - Exit");
	}	
	public void playMenu() {
		int opt = 0;
		while (true) {
			clear();
			if(title.length() >= 1) printTitle();
			printOpts();
			opt = in.getInt(">> ", new ValidInRange(1, menus.size() + 1));
			
			if(opt == menus.size() + 1) {
				exit();
				break;
			}
			menus.get(opt - 1).execute();
		}
	}
	
	public abstract void execute();
	
	public abstract void exit();
	
	public void addMenu(Menu menu) {
//		menus.put(key, menu);
		menus.add(menu);
	}

	public String getSubtitle() {
		return subtitle;
	}

	public Menu setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}
	
	public Menu setTitle(String title) {
		this.title = title;
		return this;
	}

	public CustPrompt getIn() {
		return in;
	}

	public void setIn(CustPrompt in) {
		this.in = in;
	}
}
