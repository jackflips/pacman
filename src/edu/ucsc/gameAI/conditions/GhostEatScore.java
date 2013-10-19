package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class GhostEatScore implements ICondition {
	
	int min, int max;
	public GhostEatScore(int _min, int _max)
	{
		min = _min;
		max = _max;
	}
	
	public boolean test(Game game) 
	{
		return (game.getGhostCurrentEdibleScore() > min && game.getGhostCurrentEdibleScore() < max);
	}
}
