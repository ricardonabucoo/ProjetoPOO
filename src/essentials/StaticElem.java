package essentials;

public abstract class StaticElem extends Elem {

	
	public void OnEnter(Player player) {}
	public void OnStay(Player player) {}
	public void OnExit(Player player) {}

	abstract int GetMPNeeded();

}
