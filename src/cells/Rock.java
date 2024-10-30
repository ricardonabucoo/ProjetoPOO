package cells;

import elements.Player;

import javax.swing.ImageIcon;

public final class Rock extends Cell {

	public static final int MP_REQUIRED_FOR_ROCK=2;

	public Rock(int row, int col) {
		super(row,col);
		imageIcon = new ImageIcon("images/rock.png");
		setIcon(imageIcon);
	}

	@Override
	public int getMPNeeded() {
		return MP_REQUIRED_FOR_ROCK;
	}
	
	@Override
	public void onEnter(Player player) {

	}


}