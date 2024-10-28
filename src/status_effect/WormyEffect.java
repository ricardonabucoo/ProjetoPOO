package status_effect;

import elements.Player;

public class WormyEffect implements StatusEffect {
	 @Override
	 public void applyEffect(Player player) {
		player.setCanMoveNextRound(false); //dar o efeito de não poder se mover na próxima rodada
	}
}
