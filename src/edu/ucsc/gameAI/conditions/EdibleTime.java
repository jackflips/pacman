package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class EdibleTime implements ICondition {
	
	GHOST gghost;
	int min, max;
	public EdibleTime(GHOST ghost, int _min, int _max)
	{
		gghost=ghost;
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getGhostEdibleTime(gghost) > min && game.getGhostEdibleTime(gghost) < max);
	}
}
