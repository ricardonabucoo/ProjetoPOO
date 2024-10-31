package elements;

import cells.Cell;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.IllegalFormatWidthException;

public abstract class Elem extends JButton implements Serializable
{
	protected Cell cell;
	protected ImageIcon imageIcon;

	public Elem(){}

	public Elem(Cell cell) {
		this.cell = cell;
		cell.setElem(this);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setEnabled(true);
		//setMargin(new Insets(0, 0, 0, 0)); // Remove espaçamento
		//setBounds(5,cell.getHeight() - 35, 80, 30); // Ajusta o tamanho e posição
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
