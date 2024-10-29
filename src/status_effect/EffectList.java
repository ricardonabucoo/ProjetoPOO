package status_effect;

import java.util.ArrayList;
import java.util.List;

import elements.Player;

public class EffectList implements StatusEffect {
	
	private List<StatusEffect> effectList;
	
	public EffectList() {
		effectList = new ArrayList<StatusEffect>();
	}
	
	@Override
	public void applyEffect(Player player) {
		for(StatusEffect se : effectList) {
			se.applyEffect(player);
		}
	}
	
	public void addEffect(StatusEffect se) {
		effectList.add(se);
	}
	
	public void removeEffect(StatusEffect se) {
	    effectList.removeIf(effect -> effect.getClass().equals(se.getClass()));
	}

	public boolean containsEffect(EffectType effectType) {
		return effectList.stream().anyMatch(effectType::isInstance);
	}
}
