package affinestate;

abstract public class BasicState<SM extends StateManager<?>> implements State<SM> {
	private SM owner;
	private String name;

	abstract public void onEnter();

	abstract public void onExit();

	abstract public void onUpdate();

	public void setOwner(SM owner) {
		this.owner = owner;
	}

	public void setState(String stateName) {
		owner.setState(stateName);
		System.out.println("Set state to:" + stateName);
	}

	@Override
	public void setName(String stateName) {
		this.name = stateName;
	}
	
	public SM getOwner() {
		return owner;
	}

	public String getName() {
		return name;
	}	
}
