package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

import pacman.game.Constants.MOVE;
import pacman.entries.Anticeptor;
import pacman.entries.Anticeptor.PathValue;
import pacman.game.Game;
import pacman.game.Constants.*;
import java.util.ArrayList;



public class AnticeptAction implements IAction, IBinaryNode {

	Game game;
	int numberOfMoves;
	Anticeptor anticeptor;

	public AnticeptAction(Game _game, int numMoves) {
		game = _game;
		numberOfMoves = numMoves;
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
