package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import edu.ucsc.gameAI.IAction;

/**
 * The interface for a state in a finite state machine. 
 * 
 * @author Josh McCoy
 */
public class State implements IState {
	

	IAction action;
	IAction entryAction;
	IAction exitAction;
	Collection<ITransition> transitions;
	/**
	 * Determines the action appropriate for being in this state. 
	 * @return Action for being in this state.
	 */
	public IAction getAction() {
		return action;
	}
	
	/**
	 * sets the action returned while in the state.
	 * @param action action to set
	 */
	public void setAction(IAction _action) {
		action = _action;
	}
		
	/**
	 * Generates the action for entering this state.
	 * @return The action associated with entering this state.
	 */
	public IAction getEntryAction() {
		return entryAction;
	}

	/**
	 * Sets the action for entering the state.
	 * @param action Entrance action.
	 */
	public void setEntryAction(IAction _action) {
		entryAction = _action;
	}
	
	/**
	 * Retrieves the action for exiting this state.
	 * @return The action associated with exiting this state.
	 */
	public IAction getExitAction() {
		return exitAction;
	}
	
	/**
	 * Sets the action for exiting the state.
	 * @param action Exit action.
	 */
	public void setExitAction(IAction _action) {
		exitAction = _action;
	}

	
	/**
	 * Accessor for all transitions out of this state.
	 * @return The outbound transitions from this state.
	 */
	public Collection<ITransition> getTransitions() {
		return transitions;
	}
	
	/**
	 * Sets the transition collection for this state.
	 * @param trans the transitions
	 */
	public void setTransitions(Collection<ITransition> trans) {
		transitions = trans;
	}
}

