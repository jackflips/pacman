package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Constants.MOVE;


public class GoUpAction implements IAction, IBinaryNode {

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}
	
	public IAction makeDecision() {return this;}
	
	public MOVE getMove()
	{
		return MOVE.UP;
	}
}