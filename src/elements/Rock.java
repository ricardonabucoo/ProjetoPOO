package elements;

import essentials.Cell;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public final class Rock extends StaticElem {

	public static final int MP_REQUIRED_FOR_ROCK=2;
	private String currentImagePath;

	public Rock(Cell ownPlace) {
		super(ownPlace);
		currentImagePath = "images/rock.png";
		ImageIcon icon = new ImageIcon(currentImagePath);
		this.setIcon(icon);

	    if (icon.getImageLoadStatus() == MediaTracker.COMPLETE)
	        System.out.println("Imagem carregada com sucesso. (Pedra)");
	    else
	        System.out.println("Erro ao carregar a imagem.");
	}
	
	@Override
	public int getMPNeeded() {
		// TODO Auto-generated method stub
		return this.MP_REQUIRED_FOR_ROCK;
	}
	
	@Override
	public void onEnter(Player player) {

	}

	public Cell getExitDirection() {
		return null;
	}

	private void jumpTo(Cell exitDirection) {

	}
	public String getCurrentImagePath () {
		return this.currentImagePath;
	}

}