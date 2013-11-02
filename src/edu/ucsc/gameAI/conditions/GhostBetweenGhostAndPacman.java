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
		//System.out.println("In GhostBetweenGhost..");
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
		//System.out.println("Pacman at node" + pacmanPos);
		while(current != pacmanPos)
		{
			MOVE[] moves = game.getPossibleMoves(current, lastMove);
			if(moves.length > 1)
				lastMove = game.getNextMoveTowardsTarget(current, pacmanPos, lastMove, DM.PATH);
			else
				lastMove = moves[0];
			current = game.getNeighbour(current, lastMove);
			//System.out.println("At node" + current);
			for(int ghostPos : ghostPositions)
			{
				if(ghostPos == current)
				{
					//System.out.println("GhostBetweenGhost.. returning true");
					return true;
				}
			}
			i++;
			if(i > 1000)
			{
				//System.out.println("GhostBetweenGhost giving up, returning false.");
				return false;
			}
		}
		//System.out.println("GhostBetweenGhost.. returning false");
		return false; 
	}
}