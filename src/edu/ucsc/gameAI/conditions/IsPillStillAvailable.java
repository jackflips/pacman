package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class IsPillStillAvailable implements ICondition {
	
	int pillIndex;
	public IsPillStillAvailable(int _pillIndex)
	{
		pillIndex = _pillIndex;
	}
	
	public boolean test(Game game) 
	{
		return game.isPillStillAvailable(pillIndex);
	}
}
