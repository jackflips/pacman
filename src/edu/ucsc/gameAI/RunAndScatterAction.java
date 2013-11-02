package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.MOVE;
import pacman.entries.Anticeptor;
import pacman.entries.Anticeptor.PathValue;
import pacman.game.Game;
import pacman.game.Constants.*;
import java.util.ArrayList;



public class RunAndScatterAction implements IAction, IBinaryNode {

	Game game;
	int numberOfMoves;
	Anticeptor anticeptor;
	GHOST myGhost;

	public RunAndScatterAction(Game _game, int numMoves, GHOST _ghost) {
		game = _game;
		numberOfMoves = numMoves;
		myGhost = _ghost;
		anticeptor = new Anticeptor(-1, -100, -90, 1000, -100000, 0);
	}

	public void doAction() {
		// TODO Auto-generated method stub
		// not used ???
	}


	public IAction makeDecision(pacman.game.Game game) {return this;}
	
	public MOVE getMove()
	{
		ArrayList<PathValue> results = anticeptor.anticept(game, game.getGhostCurrentNodeIndex(myGhost), game.getGhostLastMoveMade(myGhost), numberOfMoves);
		return results.get(0).move;
	}
}
