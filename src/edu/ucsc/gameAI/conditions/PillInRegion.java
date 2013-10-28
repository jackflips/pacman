package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class PillInRegion implements ICondition {
	
	int boundx1, boundx2, boundy1, boundy2;
	public PillInRegion(int x1, int y1, int x2, int y2) {
		boundx1 = x1;
		boundx2 = x2;
		boundy1 = y1;
		boundy2 = y2;
	}
	
	public boolean test(Game game) {
		int[] indices = game.getActivePillsIndices();
		for (int i=0; i<indices.length; i++) {
			int yCoord = game.getNodeYCood(indices[i]);
			if (yCoord >= boundy1 && yCoord <= boundy2) {
				int xCoord = game.getNodeXCood(indices[i]);
				if (xCoord >= boundx1 && xCoord <= boundx2) {
					return true;
				}
			}
		}
		return false;
	}
}
