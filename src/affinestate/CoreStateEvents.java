package affinestate;

public interface CoreStateEvents<SM extends StateManager<?>> {

	/**
	 * Called when this state is entered 
	 */
	public abstract void onEnter();

	/**
	 * Called when this state is exited
	 */
	public abstract void onExit();

	/**
	 * Called when this state is updated
	 */
	public abstract void onUpdate();

}