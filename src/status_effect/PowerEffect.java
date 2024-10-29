package status_effect;

import elements.Player;

import java.io.Serializable;

public class PowerEffect implements StatusEffect, Serializable {
	 @Override
	 public void applyEffect (Player player) {
		player.setPower(player.getPower() * 2);
	}

}
