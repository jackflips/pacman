package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class ClosestGhostToPacman implements ICondition {
	
	GHOST ghost;
	
	public ClosestGhostToPacman(GHOST _ghost)
	{
		ghost = _ghost;
	}
	
	public boolean test(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST otherGhost : GHOST.values()) {
			if(game.getGhostEdibleTime(otherGhost)==0 && game.getGhostLairTime(otherGhost)==0 &&
				game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0) 
			{
				if (game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(otherGhost))<
					game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost)))
				{
					//since it's strictly less than, we don't have to worry about a ghost invalidating itself
					return false;
				}
			}
		}
		return true; 
	}
}