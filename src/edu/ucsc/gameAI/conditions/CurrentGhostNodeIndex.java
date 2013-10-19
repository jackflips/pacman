package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class CurrentGhostNodeIndex implements ICondition {
	
	GHOST gghost;
	int index;
	public CurrentGhostNodeIndex(GHOST ghost, int _index)
	{
		gghost=ghost;
		index = _index;
	}
	
	public boolean test(Game game) 
	{
		return game.getGhostCurrentNodeIndex(gghost) == index;
	}
}
