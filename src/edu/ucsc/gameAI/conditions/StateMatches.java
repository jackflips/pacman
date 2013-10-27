package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.entries.ghosts;

public class StateMatches implements ICondition {
	
	MyGhosts.CommonGhostState stateToMatch;
	MyGhosts controller;
	public StateMatches(MyGhosts parent, MyGhosts.CommonGhostState state)
	{
		stateToMatch = state;
		controller = parent;
	}
	
	public boolean test(Game game) 
	{
		return (state == parent.globalGhostState);
	}
}
