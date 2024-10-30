package elements;

import essentials.Cell;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public final class Grass extends StaticElem {

	public static final int MP_REQUIRED_FOR_GRASS = 1;

	public Grass(Cell ownPlace) {
		super(ownPlace);
		imageIcon = new ImageIcon("images/grass.png");
		this.setIcon(imageIcon);

		if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE)
			System.out.println("Imagem carregada com sucesso. (Grama)");
		else
			System.out.println("Erro ao carregar a imagem.");
	}

	@Override
	public int getMPNeeded() {
		return MP_REQUIRED_FOR_GRASS;
	}


}
