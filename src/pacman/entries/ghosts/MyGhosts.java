package pacman.entries.ghosts;

import java.util.EnumMap;
import java.util.ArrayList;

import pacman.controllers.Controller;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.conditions.IsEdible;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.fsm.*;
import edu.ucsc.gameAI.*;
import edu.ucsc.gameAI.GoLeftAction;
import edu.ucsc.gameAI.GoRightAction;
import edu.ucsc.gameAI.AttacmanAction;
import edu.ucsc.gameAI.fsm.*;
import pacman.entries.Anticeptor;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */


public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>> {

	/*public enum CommonGhostState {
		ANTICEPT,	
		SCATTER, 	
		SWARM; 
	};*/

	Anticeptor anticeptor;

	boolean initialized = false;
	//public CommonGhostState globalGhostState;
	private EnumMap<GHOST, GhostFSM> stateMachines;
	
	public void constructor(Game game) {
		//globalGhostState = CommonGhostState.SCATTER;
		
		stateMachines = new EnumMap<GHOST, GhostFSM>(GHOST.class);
		for (GHOST ghost : GHOST.values()) {
			stateMachines.put(ghost, new GhostFSM(game, ghost));
		}
	}

	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		
		if (!initialized) {
			constructor(game);
		}
		
		myMoves.clear();
		
		for(GHOST ghost : GHOST.values())	//for each ghost
		{
			if(game.doesGhostRequireAction(ghost)) { //if ghost requires an action:
				myMoves.put(ghost, stateMachines.get(ghost).getMove(game));
				
			}
		}
		
		
		return myMoves;
	}
}