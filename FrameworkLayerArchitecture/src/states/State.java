package states;

import models.Entity;

public abstract class State {
	private Entity entity;
	
	public State(Entity entity) {
		super();
		this.setEntity(entity);
	}

	public abstract void execute();

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}
}
