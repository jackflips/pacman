package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentPacmanNodeIndex implements ICondition {
	
	int index;
	public CurrentPacmanNodeIndex(int _index)
	{
		index = _index;
	}
	
	public boolean test(Game game) 
	{
		return (game.getPacmanCurrentNodeIndex() == index);
	}
}
