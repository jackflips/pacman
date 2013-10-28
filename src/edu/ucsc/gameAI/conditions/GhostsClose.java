package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class GhostsClose implements ICondition {
	
	public boolean test(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values()) {
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0) {
				if (game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<50) {
					return true;
				}
			}
		}
		return false; 
	}
}