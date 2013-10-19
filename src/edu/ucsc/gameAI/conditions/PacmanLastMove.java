package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class PacmanLastMove implements ICondition {
	
	MOVE move;
	public PacmanLastMove(MOVE _move)
	{
		move = _move;
	}
	
	public boolean test(Game game) 
	{
		return (game.getPacmanLastMoveMade() == move);
	}
}
