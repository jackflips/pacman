package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Constants.MOVE;

public class GoLeftAction implements IAction, IBinaryNode {

	public void doAction() {
		// TODO Auto-generated method stub
		//...but apparently this won't be used anyway, so, whatevs?
	}
	
	public IAction makeDecision() {return this;}
	
	public MOVE getMove()
	{
		return MOVE.LEFT;
	}
}
