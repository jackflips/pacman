package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class NumberOfLivesRemaining implements ICondition {
	
	int min, int max;
	public NumberOfLivesRemaining(int _min, int _max)
	{
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getPacmanNumberOfLivesRemaining() > min && game.getPacmanNumberOfLivesRemaining() < max);
	}
}
