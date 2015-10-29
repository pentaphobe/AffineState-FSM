package affinestate;


public interface State<SM extends StateManager<?>> {
  public void onEnter();
  public void onExit();
  public void onUpdate();
  public void setOwner(SM owner);
  public void setName(String stateName);
  public void setState(String stateName);
}