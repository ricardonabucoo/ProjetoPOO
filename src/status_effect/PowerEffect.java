package status_effect;

import elements.Player;

public class PowerEffect implements StatusEffect {
	 @Override
	 public void applyEffect (Player player) {
		int currentPower = player.getPower();
		player.setPower(currentPower * 2);
	}

}
