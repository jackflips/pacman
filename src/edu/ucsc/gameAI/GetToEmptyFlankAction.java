package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.MOVE;
import pacman.entries.Anticeptor;
import pacman.entries.Anticeptor.PathValue;
import pacman.game.Game;
import pacman.game.Constants.*;
import java.util.ArrayList;



public class GetToEmptyFlankAction implements IAction, IBinaryNode {

	Game game;
	int numberOfMoves;
	int distanceFromOtherGhosts;
	Anticeptor anticeptor;
	GHOST myGhost;

	public GetToEmptyFlankAction(Game _game, int numMoves, int _distanceFromOtherGhosts, GHOST _ghost) {
		game = _game;
		numberOfMoves = numMoves;
		distanceFromOtherGhosts = _distanceFromOtherGhosts;
		myGhost = _ghost;
		anticeptor = new Anticeptor();
	}

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}


	public IAction makeDecision(pacman.game.Game game) {return this;}
	
	public MOVE getMove()
	{
		ArrayList<PathValue> results = anticeptor.anticept(game, game.getPacmanCurrentNodeIndex(), MOVE.NEUTRAL, numberOfMoves);
		outerloop:
		for (PathValue result : results) {
			for (GHOST ghost : GHOST.values()) {
				if (!(ghost == myGhost)) {
					int distance = game.getShortestPathDistance(game.getGhostCurrentNodeIndex(myGhost), game.getGhostCurrentNodeIndex(ghost));
					if (distance < distanceFromOtherGhosts) {
						continue outerloop;
					}
				}
			}
			return game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(myGhost), result.node, game.getGhostLastMoveMade(myGhost), DM.PATH);
		}
		return game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(myGhost), results.get(0).node, game.getGhostLastMoveMade(myGhost), DM.PATH);
	}
}
