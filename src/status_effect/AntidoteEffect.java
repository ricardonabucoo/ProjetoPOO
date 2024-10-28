package status_effect;

import elements.Player;

public class AntidoteEffect implements StatusEffect {
	@Override
	public void applyEffect(Player player) {
		if (!player.getCanMoveNextRound()) {
			player.setCanMoveNextRound(true); // Permite que o jogador anule o efeito "bichado"
		}
	}
}
