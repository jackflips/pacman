package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class GhostEaten implements ICondition {
	
	GHOST gghost;
	public GhostEaten(GHOST ghost)
	{
		gghost=ghost;
	}
	
	public boolean test(Game game) 
	{
		return game.wasGhostEaten(gghost);
	}
}
