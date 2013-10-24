package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.*;
import pacman.game.Game;


public class AttacmanAction implements IAction, IBinaryNode {

	Game game;
	GHOST ghost;

	public AttacmanAction(Game _game, GHOST _ghost) {
		game = _game;
		ghost = _ghost;
	}

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}
	
	public IAction makeDecision(pacman.game.Game game) {return this;}
	
	public MOVE getMove() {
		int pacmanIndex = game.getPacmanCurrentNodeIndex();
		int ghostIndex = game.getGhostCurrentNodeIndex(ghost);
		return game.getNextMoveTowardsTarget(ghostIndex,pacmanIndex, DM.PATH);
	}
}
