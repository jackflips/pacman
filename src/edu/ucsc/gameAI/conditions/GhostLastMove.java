package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class GhostLastMove implements ICondition {
	
	GHOST gghost;
	MOVE move;
	public GhostLastMove(GHOST ghost, MOVE _move)
	{
		gghost=ghost;
		move = _move;
	}
	
	public boolean test(Game game) 
	{
		return (game.getGhostLastMoveMade(gghost) == move);
	}
}
