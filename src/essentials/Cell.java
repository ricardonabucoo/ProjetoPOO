package essentials;
import UI.Buttons.BotaoTransparente;
import elements.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.Serializable;

public class Cell extends JPanel implements Serializable{

	private static Cell[][] gridMap;
	public boolean isEmpty;
	private int row, col;
	private StaticElem staticElem;
	private DynamicElem dynamicElem;
	private JButton button;
	private ImageIcon staticImageIcon;  // Para armazenar a imagem original do botão estático
	private ImageIcon dynamicImageIcon;

	public static void setGridMap(Cell[][] grid){
		gridMap = grid;
	}

	public Cell(int row, int col) {

		this.row = row;
		this.col = col;
		button = new BotaoTransparente();
		button.setBounds(0, 0, getWidth(), getHeight());
		add(button);
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

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}


	public static void initializeGridMap(Cell[][] grid) {
	    Cell.gridMap = grid;
	}
	
	public Cell getCellUp()	{
		if(col != 0 )
			return gridMap[row][col-1];
		else
			return null;
	}
	
	public Cell getCellDown() {
		if(col != gridMap.length-1)
			return gridMap[row][col+1];
		else
			return null;
	}
	
	public Cell getCellLeft() {
		if(row != 0)
			return gridMap[row-1][col];
		else
			return null;
	}
	
	public Cell getCellRight() {
		if(row != gridMap.length-1)
			return gridMap[row+1][col];
		else
			return null;
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
	public StaticElem getStaticElem(){
		return this.staticElem;
	}
	
	public void setDynamicElem(DynamicElem elem) {
        dynamicElem = elem;
        elem.setBounds(0,0, 50, 50);
        add(elem);
		button = new BotaoTransparente();
		button.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(button);
        setComponentZOrder(elem, 0);
		setComponentZOrder(button,1);
        revalidate();
        repaint();
	}

	public void removeDynamicElem(DynamicElem elem) {
		if(elem != this.dynamicElem){
			System.out.println("opaopaopa erro");
			return;
		}
		remove(dynamicElem);
		dynamicElem = null;
		revalidate();
		repaint();
	}
	
	

	
	public void setStaticElem(StaticElem elem) {
		this.staticElem = elem;
		removeAll();
		elem.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(elem);
		button = new BotaoTransparente();
		button.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(button);
        revalidate();
        repaint();
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


	public boolean withoutDynamicElem() {
		return dynamicElem == null; // Retorna true se a célula estiver vazia
	}





}

