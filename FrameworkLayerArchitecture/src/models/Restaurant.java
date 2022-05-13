package models;

import utils.RandInitial;

public class Restaurant {
	RandInitial initialStorage;

	public Restaurant() {
		super();
		this.initialStorage = new RandInitial();
	}

	public RandInitial getInitialStorage() {
		return initialStorage;
	}

	public void setInitialStorage(RandInitial initialStorage) {
		this.initialStorage = initialStorage;
	}
	
}
