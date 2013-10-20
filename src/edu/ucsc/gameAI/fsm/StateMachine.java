package edu.ucsc.gameAI.fsm;

import edu.ucsc.gameAI.fsm.IStateMachine;
import pacman.game.Game;
import edu.ucsc.gameAI.fsm.IState;
import edu.ucsc.gameAI.fsm.ITransition;
import edu.ucsc.gameAI.IAction;
import java.util.ArrayList;

import java.util.Collection;

public class StateMachine implements IStateMachine {


	IState currentState;
	/**
	 * The member function that performs the update on the FSM:
	 * - Test transitions for current state and moves to new state.
	 * - Returns a collection of IActions that result from the current
	 *   state and any transitions, entrances and exits that may occur.
	 * @return A collection of actions produced by evaluating the FSM.
	 */
	public Collection<IAction> update(Game game) {
		Collection<IAction> actions = new ArrayList<IAction>();
		Collection<ITransition> transitions = currentState.getTransitions();
		for (ITransition transition : transitions) {
			if (transition.isTriggered(game)) {
				actions.add(currentState.getExitAction());
				actions.add(transition.getAction());
				currentState = transition.getTargetState();
				actions.add(currentState.getEntryAction());
				break;
			}
		}
		actions.add(currentState.getAction());

		return actions;
	}
		
		/**
		 * Retrieves the current state of the finite state machine.
		 * @return The current state of the finite state machine.
		 */
	public IState getCurrentState() {
		return currentState;
	}
		
		/**
		 * Sets the current state of fsm. For setting initial state.
		 */
	public void setCurrentState(IState state) {
		currentState = state;
	}
}