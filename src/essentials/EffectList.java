package essentials;

import java.util.ArrayList;
import java.util.List;

public class EffectList implements StatusEffect {
	
	private List<StatusEffect> effectList;
	
	public EffectList() {
		effectList = new ArrayList<StatusEffect>();
	}
	
	@Override
	public void ApplyEffect(Player player) {
		for(StatusEffect se : effectList) {
			se.ApplyEffect(player);
		}
	}
	
	public void AddEffect(StatusEffect se) {
		effectList.add(se);
	}
	
	public void RemoveEffect(StatusEffect se) {
	    effectList.removeIf(effect -> effect.getClass().equals(se.getClass()));
	}
	

}
