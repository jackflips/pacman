
/*
package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class MyPacMan extends Controller<MOVE>
{
	private MOVE myMove=MOVE.NEUTRAL;
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//Place your game logic here to play the game as Ms Pac-Man
		
		return myMove;
	}
}
*/

package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.*;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.conditions.GhostsClose;
import edu.ucsc.gameAI.GoLeftAction;
import edu.ucsc.gameAI.GoRightAction;
import edu.ucsc.gameAI.PacmanAnticeptAction;
import edu.ucsc.gameAI.decisionTrees.binary.BinaryDecision;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */

public class MyPacMan extends Controller<MOVE> {

	BinaryDecision moveBinaryDecision;

	public void constructor(Game game) {
		moveBinaryDecision = new BinaryDecision();
		moveBinaryDecision.setCondition(new GhostsClose(50));
		moveBinaryDecision.setTrueBranch(new PacmanAnticeptAction(game, 200));
		moveBinaryDecision.setFalseBranch(new PacmanAnticeptAction(game, 100));
	}
	
	public MOVE getMove(Game game,long timeDue) {	

		constructor(game);

		return moveBinaryDecision.makeDecision(game).getMove();
	}
}

