
package pacman.entries.ghosts;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.fsm.*;
import edu.ucsc.gameAI.*;
import edu.ucsc.gameAI.conditions.*;

import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;

public class GhostFSM
{
	IStateMachine stateMachine;
	GHOST gggghost;

	final int rushDistance = 70;  
	final int fleeSeekDistance = 40; 
	final int flankSeekDistance = 80;  
	final int flankProximityToAvoid = 40;  
	
	//50-60-80-30: mode 1870, mean 25xx-28xx
	//70-60-80-30: mode 1870; mean 24xx-27xx
	//90-60-80-30: mode 1560, mean 27xx-31xx
	//90-60-100-30: mode 1440, mean 28xx-30xx
	//70-60-100-30: mode 3110, mean 29xx-30xx
	//70-60-70-30: mode 1910, mean 25xx- 26xx
	//60-60-70-30: mode 1910, mean 25xx-26xx
	//80-60-90-30: 3110, 28xx-30xx
	//70-90-80-30: 1880, 25xx-26xx
	//70-70-80-30: 1910, 23xx-26xx
	//70-40-80-30: 1670, 24xx-26xx
	//70-50-80-30: 1900, 28xx
	
	//now changing RunAndScatter from -1, -10, -50, 1000, -100000
	//to -1, -100, -90, 1000, -100000
	//70-40-80-30: 1670, 25xx-27xx
	//70-70-80-30: 1670, 24xx-26xx
	//70-60-80-30: 1910, 23xx-26xx
	//70-60-80-20: 1910, 23xx-26xx
	//70-60-80-50: 1910, 25xx-27xx
	//70-40-80-50: 1670, 23xx-25xx
	//you'd think that would make more difference
	//70-70-80-50: 1910, 24xx-26xx
	//70-50-80-50: 1900, 27xx-29xx
	//70-30-80-50: 4130, 34xx
	//70-40-80-40: 1670, 23xx-25xx
	//60-40-70-40: 1670, 25xx-26xx

	//I ugess 70-40-80-40 or 50 is best...
	
	
	public GhostFSM(Game game, GHOST ghost)
	{
		gggghost = ghost;
		stateMachine = new StateMachine();
		
		State anticepting = new State();
		State fleeing = new State();
		State scattering = new State();
		State chasing = new State();
		stateMachine.setCurrentState(anticepting);
		//stateMachine.setCurrentState(chasing);
		
		Transition backIntoTheLineOfDuty = new Transition();
		backIntoTheLineOfDuty.setTargetState(anticepting);
		//backIntoTheLineOfDuty.setTargetState(chasing);
		backIntoTheLineOfDuty.setCondition(new InvertCondition(new IsEdible(ghost)));
		
		Vector<ITransition> fleeTransitions = new Vector<ITransition>();
		fleeTransitions.add(backIntoTheLineOfDuty);
		fleeing.setTransitions(fleeTransitions);
		
		Transition runAway = new Transition();
		runAway.setTargetState(fleeing);
		runAway.setCondition(new IsEdible(ghost));
		Transition cutHimOff = new Transition();
		cutHimOff.setTargetState(anticepting);
		//cutHimOff.setTargetState(chasing);
		cutHimOff.setCondition(new InvertCondition(new GhostBetweenGhostAndPacman(ghost)));
		
		Vector<ITransition> scatterTransitions = new Vector<ITransition>();
		scatterTransitions.add(runAway);
		scatterTransitions.add(cutHimOff);
		scattering.setTransitions(scatterTransitions);
		
		Transition getToAFlank = new Transition();
		getToAFlank.setTargetState(scattering);
		getToAFlank.setCondition(new GhostBetweenGhostAndPacman(ghost));
		
		Vector<ITransition> chaseTransitions = new Vector<ITransition>();
		chaseTransitions.add(runAway);
		chaseTransitions.add(getToAFlank);
		chasing.setTransitions(chaseTransitions);
		
		Transition rushHim = new Transition();
		rushHim.setTargetState(chasing);
		rushHim.setCondition(new GhostClose(ghost, rushDistance));
		Transition tailHim = new Transition();
		tailHim.setTargetState(chasing);
		tailHim.setCondition(new ClosestGhostToPacman(ghost));
		
		
		Vector<ITransition> anticeptTransitions = new Vector<ITransition>();
		anticeptTransitions.add(runAway);
		anticeptTransitions.add(tailHim);
		anticeptTransitions.add(getToAFlank);
		anticeptTransitions.add(rushHim);
		anticepting.setTransitions(anticeptTransitions);
		//*/
		
		anticepting.setAction(new GhostAnticeptAction(game, ghost));
		fleeing.setAction(new RunAndScatterAction(game, fleeSeekDistance, ghost));
		scattering.setAction(new GetToEmptyFlankAction(game, flankSeekDistance, flankProximityToAvoid, ghost));
		chasing.setAction(new AttacmanAction(game, ghost));
	}
	
	public MOVE getMove(Game game)
	{
		Collection<IAction> actions = stateMachine.update(game);
		Iterator<IAction> actionItor = actions.iterator();
		IAction action = actionItor.next();
		//System.out.println(gggghost + ": " + action.getClass().getName());
		return action.getMove();
	}
}