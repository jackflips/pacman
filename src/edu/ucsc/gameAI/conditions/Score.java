package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class Score implements ICondition {
	
	int min, max;
	public Score(int _min, int _max)
	{
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getScore() > min && game.getScore() < max);
	}
}
