package cells;
import elements.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Serializable;

public abstract class Cell extends JButton implements Serializable{

	private static Cell[][] gridMap;
	public final int row, col;
	protected ImageIcon imageIcon;
	private Elem elem;

	public static void setGridMap(Cell[][] grid){
		gridMap = grid;
	}

	public Cell(int row, int col) {

		this.row = row;
		this.col = col;
		setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if(imageIcon != null) {
					Image resizedImage = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
					setIcon(new ImageIcon(resizedImage));
				}
			}
		});
		//addActionListener(e -> {
		//	System.out.println(getClass());
		//});

	}

	public static void initializeGridMap(Cell[][] grid) {
	    Cell.gridMap = grid;
	}

	public abstract int getMPNeeded();

	public Cell getCellUp()	{ return col != 0 ? gridMap[row][col-1] : null; }

	public Cell getCellDown() { return col != gridMap.length - 1 ? gridMap[row][col+1] : null; }

	public Cell getCellLeft() { return row != 0 ? gridMap[row-1][col] : null; }

	public Cell getCellRight() { return row != gridMap.length - 1 ? gridMap[row+1][col] : null; }

	public final void update() {
		updateCell();
        if (elem != null)
			elem.update();
	}

	public void updateCell() {}

	public void onEnter(Player player) {}

	public void onStay(Player player) {}

	public void onExit(Player player) {}

	public Elem getElem(){ return this.elem; }
	
	public void setElem(Elem elem) {
        this.elem = elem;
        elem.setBounds(0,0, 50, 50);
        add(elem);
        revalidate();
        repaint();
	}

	public void removeElem() {
		remove(this.elem);
		this.elem = null;
		revalidate();
		repaint();
	}

	public boolean isUnoccupied() {
		return elem == null;
	}

	public int getRow() { return row; }

	public int getCol() {
		return col;
	}

	public ImageIcon getImageIcon() { return imageIcon; }
}

