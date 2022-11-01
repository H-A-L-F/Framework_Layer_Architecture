package main;

public class Worker {
	private int id;
	private String name;
	private String gender;
	private String email;
	
	public Worker(String name, String gender, String email) {
		super();
		this.id = (int) ((Math.random() * (999 - 1)) + 1);
		this.name = name;
		this.gender = gender;
		this.email = email;
	}
	
	public String getWorkerId() {
		return String.format("WR%03d", id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
