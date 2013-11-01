
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

	public GhostFSM(Game game, GHOST ghost)
	{
		stateMachine = new StateMachine();
		
		State anticepting = new State();
		State fleeing = new State();
		State scattering = new State();
		State chasing = new State();
		stateMachine.setCurrentState(anticepting);
		
		Transition backIntoTheLineOfDuty = new Transition();
		backIntoTheLineOfDuty.setTargetState(anticepting);
		backIntoTheLineOfDuty.setCondition(new InvertCondition(new IsEdible(ghost)));
		
		Vector<ITransition> fleeTransitions = new Vector<ITransition>();
		fleeTransitions.add(backIntoTheLineOfDuty);
		fleeing.setTransitions(fleeTransitions);
		
		Transition runAway = new Transition();
		runAway.setTargetState(fleeing);
		runAway.setCondition(new IsEdible(ghost));
		Transition cutHimOff = new Transition();
		cutHimOff.setTargetState(anticepting);
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
		rushHim.setCondition(new GhostClose(ghost, 100));
		Transition tailHim = new Transition();
		tailHim.setTargetState(chasing);
		tailHim.setCondition(new ClosestGhostToPacman(ghost));
		
		Vector<ITransition> anticeptTransitions = new Vector<ITransition>();
		anticeptTransitions.add(runAway);
		anticeptTransitions.add(tailHim);
		anticeptTransitions.add(getToAFlank);
		anticeptTransitions.add(rushHim);
		anticepting.setTransitions(anticeptTransitions);
		
		anticepting.setAction(new GhostAnticeptAction(game, ghost));
		fleeing.setAction(new RunAndScatterAction(game, ghost));
		scattering.setAction(new GetToEmptyFlankAction(game, ghost)); //not sure what I'm going with this one
		chasing.setAction(new AttacmanAction(game, ghost));
	}
	
	public MOVE getMove(Game game)
	{
		Collection<IAction> actions = stateMachine.update(game);
		Iterator<IAction> actionItor = actions.iterator();
		IAction action = actionItor.next();
		return action.getMove();
	}
}