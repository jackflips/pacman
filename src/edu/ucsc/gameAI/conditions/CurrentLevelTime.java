package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentLevelTime implements ICondition {
	
	int min, max;
	public CurrentLevelTime(int _min, int _max)
	{
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getCurrentLevelTime() > min && game.getCurrentLevelTime() < max);
	}
}
