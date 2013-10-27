package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.*;
import pacman.game.Game;



public class MoveTowardsVaryingTargetAction implements IAction, IBinaryNode {

	public class VaryingNode
	{
		public int nodeIndex;
	}
	
	VaryingNode source;
	VaryingNode target;

	public AttacmanAction(VaryingNode agentLocation, VaryingNode targetLocation) {
		source = agentLocation;
		target = targetLocation;
	}

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}
	
	public IAction makeDecision(pacman.game.Game game) {return this;}
	
	public MOVE getMove() {
				return game.getNextMoveTowardsTarget(source.nodeIndex, target.nodeIndex, DM.PATH);
	}
}
