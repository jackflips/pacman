package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.MOVE;
import pacman.entries.Anticeptor;
import pacman.entries.Anticeptor.PathValue;
import pacman.game.Game;
import pacman.game.Constants.*;
import java.util.ArrayList;



public class PacmanAnticeptAction implements IAction, IBinaryNode {

	Game game;
	int numberOfMoves;
	Anticeptor anticeptor;
	boolean timedOut;

	public PacmanAnticeptAction(Game _game, int numMoves) {
		game = _game;
		numberOfMoves = numMoves;
		anticeptor = new Anticeptor();
		timedOut = false;
	}

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}

	private boolean ghostClose(pacman.game.Game game, int distance) {
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values()) {
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0) {
				if (game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost)) < distance) {
					return true;
				}
			}
		}
		return false; 
	}

	public IAction makeDecision(pacman.game.Game game) {return this;}

	private double getPowerpillScale(pacman.game.Game game) {
		double averageDistanceFromPacman = 0.0;
		double numberOfNonEdibleGhosts = 4.0;
		for (GHOST ghost : GHOST.values()) {
			averageDistanceFromPacman += game.getEuclideanDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost));
			if (game.isGhostEdible(ghost)) {
				numberOfNonEdibleGhosts--;
			}
		} 
		double scale = 1 - ((averageDistanceFromPacman / 4.0) / 116.0); //normalized
		if (ghostClose(game, 60)) {
			scale = 1.4;
		}
		return scale;
	}
	
	public MOVE getMove()
	{

		/*
		double powerpillScale = 0;
		if (game.getCurrentLevelTime() > 35)
			powerpillScale = getPowerpillScale(game);
		anticeptor.adjustPowerpillWeight(20.0 * powerpillScale);
		*/


		ArrayList<PathValue> results = anticeptor.anticept(game, game.getPacmanCurrentNodeIndex(), MOVE.NEUTRAL, numberOfMoves);
		PathValue first = results.get(0);
		/*
		if (first.value == 5 || first.value == 0) {
			return game.getNextMoveTowardsTarget(600, game.getPacmanCurrentNodeIndex(), MOVE.NEUTRAL, DM.PATH);
		}
		*/
		return first.move;
	}
}
