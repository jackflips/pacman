package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	private MOVE myMove=MOVE.NEUTRAL;
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//Place your game logic here to play the game as Ms Pac-Man
		
		return myMove;
	}
}

/*
package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.*;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.*;
import edu.ucsc.gameAI.conditions.GhostsClose;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */

/*
public class MyPacMan extends Controller<MOVE>
{

	BinaryDecision moveBinaryDecision = new BinaryDecision();
	moveBinaryDecision.setCondition(new GhostsClose());
	//moveBinaryDecision.setTrueBranch(new AnticeptAction(4));
	//moveBinaryDecision.setFalseBranch(new AnticeptAction(8));
	moveBinaryDecision.setTrueBranch(new GoDownAction());
	moveBinaryDecision.setFalseBranch(new GoRightAction());
	
	public MOVE getMove(Game game,long timeDue) {		
		return moveBinaryDecision.makeDecision(game).getMove();
	}
}
*/