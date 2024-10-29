package status_effect;

import elements.Player;

public class MovimentEffect implements StatusEffect {
	 @Override
	 public void applyEffect (Player player) {
		player.setMovementPoints(player.getMovementPoints() * 2);
	}
}
