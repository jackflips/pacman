package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.MOVE;
import pacman.entries.Anticeptor;
import pacman.entries.Anticeptor.PathValue;
import pacman.game.Game;
import pacman.game.Constants.*;
import java.util.ArrayList;



public class GhostAnticeptAction implements IAction, IBinaryNode {

	Game game;
	Anticeptor anticeptor;
	GHOST ghost;

	public GhostAnticeptAction(Game _game, GHOST _ghost) {
		game = _game;
		anticeptor = new Anticeptor();
		ghost = _ghost;
	}

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}


	public IAction makeDecision(pacman.game.Game game) {return this;}
	
	public MOVE getMove()
	{
		int pacmanPos = game.getPacmanCurrentNodeIndex();
		int ghostPos = game.getGhostCurrentNodeIndex(ghost);
		int distanceUsed = game.getShortestPathDistance(pacmanPos, ghostPos) * 2 / 3;
		ArrayList<PathValue> results = anticeptor.anticept(game, game.getPacmanCurrentNodeIndex(), MOVE.NEUTRAL, distanceUsed);
		int destinationNode = -1;
		for (PathValue result : results)
		{
			int dist = game.getShortestPathDistance(result.node, ghostPos);
			if(dist < distanceUsed)
			{
				destinationNode = result.node;
				break;
			}
		}
		if(destinationNode == -1)
		{
			destinationNode = pacmanPos;
		}
		return game.getNextMoveTowardsTarget(ghostPos, destinationNode, game.getGhostLastMoveMade(ghost), DM.PATH);
	}
}
