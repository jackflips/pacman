package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class PacmanInRegion implements ICondition {
	
	int boundx1, boundx2, boundy1, boundy2;
	public PacmanInRegion(int x1, int y1, int x2, int y2) {
		boundx1 = x1;
		boundx2 = x2;
		boundy1 = y1;
		boundy2 = y2;
	}
	
	public boolean test(Game game) {
		int index = game.getPacmanCurrentNodeIndex();
		int yCoord = game.getNodeYCood(index);
		if (yCoord >= boundy1 && yCoord <= boundy2) {
			int xCoord = game.getNodeXCood(index);
			if (xCoord >= boundx1 && xCoord <= boundx2) {
				return true;
			}
		}
		return false;
	}
}
