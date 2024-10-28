package elements;

import essentials.Cell;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public final class Grass extends StaticElem {

	public static final int MP_REQUIRED_FOR_GRASS = 1;
	private String currentImagePath;

	public Grass(Cell ownPlace) {
		super(ownPlace);
		currentImagePath = "images/grass.png";
		ImageIcon icon = new ImageIcon(currentImagePath);
		this.setIcon(icon);

		if (icon.getImageLoadStatus() == MediaTracker.COMPLETE)
			System.out.println("Imagem carregada com sucesso. (Grama)");
		else
			System.out.println("Erro ao carregar a imagem.");
	}

	@Override
	public int getMPNeeded() {
		return this.MP_REQUIRED_FOR_GRASS;
	}
	public String getCurrentImagePath () {
		return this.currentImagePath;
	}

}
