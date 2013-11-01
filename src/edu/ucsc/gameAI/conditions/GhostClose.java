package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class GhostClose implements ICondition {
	
	GHOST ghost;
	int distance;
	
	public GhostClose(GHOST _ghost, int _distance)
	{
		ghost = _ghost;
		distance = _distance;
	}
	
	public boolean test(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		if(game.getGhostLairTime(ghost)==0) {
			if (game.getShortestPathDistance(current, game.getGhostCurrentNodeIndex(ghost)) < distance) {
				return true;
			}
		}
		return false; 
	}
}