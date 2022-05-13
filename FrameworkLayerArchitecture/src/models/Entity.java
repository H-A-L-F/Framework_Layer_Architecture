package models;

import states.State;

public abstract class Entity {
	private String name;
	private State state;
	
	public Entity(String name) {
		this.name = name;
	}
	
	public void changeState(State state) {
		this.state = state;
		this.state.execute();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
