package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.MOVE;

public class GoDownAction implements IAction, IBinaryNode {

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}
	
	public IAction makeDecision() {return this;}
	
	public MOVE getMove()
	{
		return MOVE.DOWN;
	}
}
