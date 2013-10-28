package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class IsPowerPillStillAvailable implements ICondition {
	
	int pillIndex;
	public IsPowerPillStillAvailable(int _pillIndex)
	{
		pillIndex = _pillIndex;
	}
	
	public boolean test(Game game) 
	{
		return game.isPowerPillStillAvailable(pillIndex);
	}
}
