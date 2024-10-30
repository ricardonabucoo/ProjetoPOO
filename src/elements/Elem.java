package elements;

import cells.Cell;

import javax.swing.*;
import java.io.Serializable;

public abstract class Elem extends JButton implements Serializable
{
	protected Cell cell;
	protected ImageIcon imageIcon;
		
	public Elem(Cell cell) {
		this.cell = cell;
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setEnabled(false);
		addActionListener(e -> {
			System.out.println(getClass());
		});
	}
	public void update() {}
	public ImageIcon getImageIcon () { return this.imageIcon;}
	protected void setCell(Cell cell)
	{
		this.cell = cell;
	}
	public Cell getCell() { return this.cell; }
}
