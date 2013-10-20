package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Constants.MOVE;

public class GoLeftAction implements IAction, IBinaryNode {

	public GoLeftAction() {
		
	}

	public void doAction() {
		// TODO Auto-generated method stub
		//...but apparently this won't be used anyway, so, whatevs?
	}
	
	public IAction makeDecision(pacman.game.Game game) {return this;}
	
	public MOVE getMove()
	{
		return MOVE.LEFT;
	}
}
