package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class InvertCondition implements ICondition {
	
	ICondition condition1, condition2;
	public CurrentGhostNodeIndex(ICondition _condition1, ICondition _condition2)
	{
		condition1 = _condition1;
		condition2 = _condition2;
	}
	
	public boolean test(Game game) 
	{
		if(condition1.test(game) && condition2.test(game))
			return true;
		return false;
	}
}
