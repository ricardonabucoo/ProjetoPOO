package cells;
import elements.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import static testes.HoverRedTintButtonExample.applyRedTint;

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

	public void setCellAbleToMove() {
        BufferedImage bufferedImage = null;
        if (imageIcon != null) {
            bufferedImage = new BufferedImage(
                    imageIcon.getIconWidth(),
                    imageIcon.getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB
            );
        }

        // Desenha a imagem do ImageIcon no BufferedImage
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(imageIcon.getImage(), 0, 0, null);
        g.dispose();

        // Aplica a tonalidade vermelha
        BufferedImage redTintImage = applyRedTint(bufferedImage);
        setIcon(new ImageIcon(redTintImage));
    }

	public void setCellUnableToMove(){
		setIcon(imageIcon);
	}

	private BufferedImage applyRedTint(BufferedImage image) {
		BufferedImage tintedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				Color originalColor = new Color(image.getRGB(x, y), true);
				int red = Math.min(255, (int) (originalColor.getRed() * 1.5));  // Aumenta a tonalidade vermelha
				int green = (int) (originalColor.getGreen() * 0.5);  // Reduz o verde
				int blue = (int) (originalColor.getBlue() * 0.5);    // Reduz o azul
				int alpha = originalColor.getAlpha();
				Color tintedColor = new Color(red, green, blue, alpha);
				tintedImage.setRGB(x, y, tintedColor.getRGB());
			}
		}
		return tintedImage;
	}
}

