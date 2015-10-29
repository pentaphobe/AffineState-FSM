package affinestate;

/**
 * State is generally only used as an internal interface, most use cases should
 * start with BasicState
 * 
 * @author pentaphobe
 *
 * @param <SM>
 *            the StateManager type
 */
public interface State<SM extends StateManager<?>> extends CoreStateEvents<SM> {
	/**
	 * Generally only called by the owning StateManager on add
	 * @param owner the parent StateManager
	 */
	public void setOwner(SM owner);

	/**
	 * Setter for name
	 * @param stateName
	 */
	public void setName(String stateName);

	/**
	 * Helper method which calls the owning StateManager's setState method
	 * @param stateName
	 */
	public void setState(String stateName);

	
	/**
	 * @return <SM> the owning StateManager
	 */
	public SM getOwner();
}