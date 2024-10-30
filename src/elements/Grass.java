package elements;

import essentials.Cell;

import java.awt.*;
import javax.swing.ImageIcon;

public final class Grass extends Cell {

	public static final int MP_REQUIRED_FOR_GRASS = 1;

	public Grass(int row, int col) {
		super(row,col);
		imageIcon = new ImageIcon("images/grass.png");
		setIcon(imageIcon);
	}

	@Override
	public int getMPNeeded() {
		return MP_REQUIRED_FOR_GRASS;
	}


}
