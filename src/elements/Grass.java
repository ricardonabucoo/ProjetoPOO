package elements;

import essentials.Cell;

import java.awt.MediaTracker;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public final class Grass extends StaticElem {

	public static final int MP_REQUIRED_FOR_GRASS = 1;


	public Grass(Cell ownPlace) {
		super(ownPlace, null);
		ImageIcon icon = new ImageIcon("images/grama.png");
		this.setIcon(icon);
		if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
			System.out.println("Imagem carregada com sucesso.");
		} else {
			System.out.println("Erro ao carregar a imagem.");
		}


	}

	@Override
	public int GetMPNeeded() {
		// TODO Auto-generated method stub
		return this.MP_REQUIRED_FOR_GRASS;
	}
}
