package states;

import models.Entity;
import utils.GamePause;

public class StatePause extends State{
	GamePause gamePause;
	
	public StatePause(Entity entity) {
		super(entity);
		gamePause = new GamePause();
	}

	@Override
	public void execute() {
		// FACADE
		gamePause.pause();
	}
	
}
