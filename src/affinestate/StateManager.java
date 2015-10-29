package affinestate;

import java.util.HashMap;

public class StateManager<T extends State> extends HashMap<String, T> {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public T currentState;
	public T nextState;

	public StateManager() {
		super();
	}

	private void preUpdate() {
		if (nextState != currentState) {
			if (currentState != null) {
				currentState.onExit();
			}
			if (nextState != null) {
				nextState.onEnter();
			}
			currentState = nextState;
		}
	}

	private void doUpdate() {
		if (currentState != null) {
			currentState.onUpdate();
		}
	}

	private void postUpdate() {
	}

	final public void onUpdate() {
		preUpdate();
		doUpdate();
		postUpdate();
	}

	public void setState(T newState) {
		nextState = newState;
	}

	public void setState(String newState) {
		setState(get(newState));
	}

	@Override
	public T put(String stateName, T newState) {
		System.out.printf("Adding a state: %s, %s\n", stateName, newState);
		super.put(stateName, newState);
		newState.setOwner(this);
		newState.setName(stateName);
		return newState;
	}
}