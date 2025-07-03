package status_effect;

import elements.Player;

import java.io.Serializable;

public class AntidoteEffect implements StatusEffect, Serializable {
	@Override
	public void applyEffect(Player player) {
		if (!player.getCanMoveNextRound()) {
			player.setCanMoveNextRound(true); // Permite que o jogador anule o efeito "bichado"
		}
	}
}
