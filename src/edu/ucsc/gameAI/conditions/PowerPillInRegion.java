package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class PowerPillInRegion implements ICondition {
	
	int boundx1, boundx2, boundy1, boundy2;
	public PowerPillInRegion(int x1, int y1, int x2, int y2) {
		boundx1 = x1;
		boundx2 = x2;
		boundy1 = y1;
		boundy2 = y2;
	}
	
	public boolean test(Game game) {
		int[] indices = game.getActivePowerPillsIndices();
		for (int i=0; i<indices.length; i++) {
			yCoord = game.getNodeYCood(indices[i]);
			if (yCoord >= y1 && yCoord <= y2) {
				xCoord = game.getNodeXCood(indices[i]);
				if (xCoord >= x1 && xCoord <= x2) {
					return true;
				}
			}
		}
		return false;
	}
}
