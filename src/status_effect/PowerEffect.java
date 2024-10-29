package status_effect;

import elements.Player;

public class PowerEffect implements StatusEffect {
	 @Override
	 public void applyEffect (Player player) {
		player.setPower(player.getPower() * 2);
	}

}
