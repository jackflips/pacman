package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class InvertCondition implements ICondition {
	
	ICondition condition;
	public InvertCondition(ICondition _condition)
	{
		condition = _condition;
	}
	
	public boolean test(Game game) 
	{
		if(condition.test(game))
			return false;
		return true;
	}
}
