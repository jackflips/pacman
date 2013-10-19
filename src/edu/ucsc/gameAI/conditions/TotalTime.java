package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class TotalTime implements ICondition {
	
	int min, int max;
	public TotalTime(int _min, int _max)
	{
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getTotalTime() > min && game.getTotalTime() < max);
	}
}
