package main;

public class Component {
    private String title;
    private int score;
    private String note;
    
	public Component(String title, int score, String note) {
		super();
		this.title = title;
		this.score = score;
		this.note = note;
	}
	
	public Component(String title) {
		super();
		this.title = title;
		this.score = 0;
		this.note = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
