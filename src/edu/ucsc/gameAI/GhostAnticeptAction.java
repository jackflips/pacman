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

	public GhostAnticeptAction(Game _game, GHOST ghost) {
		game = _game;
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
		PathValue first = results.get(0);
		return first.move;
	}
}
