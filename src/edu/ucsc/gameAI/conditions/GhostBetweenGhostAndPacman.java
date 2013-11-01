package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;


import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.game.Constants.*;

public class GhostBetweenGhostAndPacman implements ICondition {
	
	GHOST ghost;
	
	public GhostBetweenGhostAndPacman(GHOST _ghost)
	{
		ghost = _ghost;
	}
	
	
	//assumes, for now, that other ghosts are not edible
	//that should probably be changed
	//but whatevs for now.
	public boolean test(Game game) 
	{
		int pacmanPos = game.getPacmanCurrentNodeIndex();
		int current = game.getGhostCurrentNodeIndex(ghost);
		MOVE lastMove = game.getGhostLastMoveMade(ghost);
		
		int[] ghostPositions = new int[3];
		int i = 0;
		for (GHOST testGhost : GHOST.values())
		{
			if(testGhost == ghost)
				continue;
			ghostPositions[i] = game.getGhostCurrentNodeIndex(testGhost);
			i++;
		}
		
		while(current != pacmanPos)
		{
			MOVE[] moves = game.getPossibleMoves(current, lastMove);
			if(moves.length > 1)
				lastMove = game.getNextMoveTowardsTarget(current, pacmanPos, lastMove, DM.PATH);
			else
				lastMove = moves[0];
			current = game.getNeighbour(current, lastMove);
			for(int ghostPos : ghostPositions)
			{
				if(ghostPos == current)
					return true;
			}
		}
		return false; 
	}
}