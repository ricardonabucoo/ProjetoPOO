package essentials;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

public final class Rock extends StaticElem {


public static final int MP_REQUIRED_FOR_ROCK=2;


@Override
public int GetMPNeeded() {
	// TODO Auto-generated method stub
	return this.MP_REQUIRED_FOR_ROCK;
}

@Override
public void OnEnter(Player player) {
	
	
	public Rock(Cell ownPlace) {
		super(ownPlace, null);
		ImageIcon icon = new ImageIcon(getClass().getResource("Rocks.png"));
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
		return this.MP_REQUIRED_FOR_ROCK;
	}
	
	@Override
	public void OnEnter(Player player) {
		
		
		
		
	}
	
	
}


public Cell GetExitDirection() {
	
	return null;
}


private void JumpTo(Cell exitDirection) {
	
	
	
}
	
}