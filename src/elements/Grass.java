package elements;

import essentials.Cell;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public final class Grass extends StaticElem {

	public static final int MP_REQUIRED_FOR_GRASS = 1;

	public Grass(Cell ownPlace) {
		super(ownPlace);
		ImageIcon icon = new ImageIcon("images/grass.png");
		this.setIcon(icon);

		if (icon.getImageLoadStatus() == MediaTracker.COMPLETE)
			System.out.println("Imagem carregada com sucesso.");
		else
			System.out.println("Erro ao carregar a imagem.");
	}

	@Override
	public int getMPNeeded() {
		return this.MP_REQUIRED_FOR_GRASS;
	}
}
