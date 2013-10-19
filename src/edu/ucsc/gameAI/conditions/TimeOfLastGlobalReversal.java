package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class TimeOfLastGlobalReversal implements ICondition {
	
	int min, int max;
	public TimeOfLastGlobalReversal(int _min, int _max)
	{
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getTimeOfLastGlobalReversal() > min && game.getTimeOfLastGlobalReversal() < max);
	}
}
