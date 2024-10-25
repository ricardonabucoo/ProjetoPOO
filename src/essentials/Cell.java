package essentials;
import elements.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class Cell extends JPanel {

	private static Cell[][] gridMap;
	private int row, col;
	private StaticElem staticElem;
	private DynamicElem dynamicElem;
	private ImageIcon staticImageIcon;  // Para armazenar a imagem original do botão estático
    private ImageIcon dynamicImageIcon;

	public Cell(int row, int col) {

		this.setLayout(null);
		this.row = row;
		this.col = col;
		setPreferredSize(new Dimension(100, 100));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (staticElem != null) {
                    staticElem.setBounds(0, 0, getWidth(), getHeight());
                    updateStaticElemIcon();  
                }
                
                if (dynamicElem != null) {
                    dynamicElem.setBounds(0, 0, getWidth(), getHeight());
                    updateDynamicElemIcon(); 
                }
            }
        });
	}
	
	public static void initializeGridMap(Cell[][] grid) {
	    Cell.gridMap = grid;
	}
	
	public Cell getCellUp()	{
		return gridMap[row][col-1];
	}
	
	public Cell getCellDown() {
		return gridMap[row][col+1];
	}
	
	public Cell getCellLeft() {
		return gridMap[row-1][col];
	}
	
	public Cell getCellRight() {
		return gridMap[row+1][col];
	}
	
	public void update() {
		if (staticElem != null) 
			staticElem.update();
		
        if (dynamicElem != null) 
        	dynamicElem.update();
	}
	
	public void onEnter(Player player) {
		staticElem.onEnter(player);
	}
	
	public void onStay(Player player) {
		staticElem.onStay(player);
	}
	
	public void onExit(Player player) {
		staticElem.onExit(player);
	}
	
	public void verifyMPNeeded(Player player) {
		
	}
	
	public int getMPNeeded() {
		return staticElem.getMPNeeded();
	}
	
	public DynamicElem getDynamicElem(){
		return this.dynamicElem;
	}
	
	public void setDynamicElem(DynamicElem elem) {
        this.dynamicElem = elem;
        elem.setBounds(0,0, 50, 50); 
        elem.setBorderPainted(false);
        elem.setFocusPainted(false);
        elem.setContentAreaFilled(false);
        this.add(elem);
        this.setComponentZOrder(elem, 0); 
        this.setComponentZOrder(staticElem, 1);
        this.revalidate();
        this.repaint();
	}
	
	
	public StaticElem getStaticElem(){
		return this.staticElem;
	}
	
	public void setStaticElem(StaticElem elem) {
		this.staticElem = elem;
		this.removeAll();
		elem.setBounds(0, 0, this.getWidth(), this.getHeight());  
		elem.setBorderPainted(false);
		elem.setFocusPainted(false);
		elem.setContentAreaFilled(false);
        this.add(elem);
        revalidate();
        repaint();
        
        if (dynamicElem != null) {
            dynamicElem.setBounds(0, 0, 50, 50);     
            dynamicElem.setBorderPainted(false);
            dynamicElem.setFocusPainted(false);
            dynamicElem.setContentAreaFilled(false);
            this.add(dynamicElem);
        }
        
        this.revalidate();
        this.repaint();
		
	}
	
	private void updateStaticElemIcon() {
	    if (staticElem instanceof JButton) {
	        JButton staticButton = (JButton) staticElem;
	        if (staticButton.getIcon() != null) {
	            ImageIcon icon = (ImageIcon) staticButton.getIcon();
	            Image scaledImage = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
	            staticButton.setIcon(new ImageIcon(scaledImage));
	        }
	    }
	}
	
	private void updateDynamicElemIcon() {
        if (dynamicImageIcon != null) {
            // Redimensiona a imagem para se ajustar ao tamanho do botão dinâmico
            JButton dynamicButton = (JButton) this.getComponent(0); // Pega o botão dinâmico adicionado
            Image scaledImage = dynamicImageIcon.getImage().getScaledInstance(dynamicButton.getWidth(), dynamicButton.getHeight(), Image.SCALE_SMOOTH);
            dynamicButton.setIcon(new ImageIcon(scaledImage));
        }
    }

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		Cell cell = new Cell(1, 1);
		frame.add(cell);
		frame.setVisible(true);

	}







}

