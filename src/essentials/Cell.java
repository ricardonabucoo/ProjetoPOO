package essentials;
import java.awt.Button;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell extends JButton {

	private static Cell[][] gridMap;
	private int row, col;
	private StaticElem staticElem;
	private DynamicElem dynamicElem;
	
	public Cell(int row, int col) {
		super("Cell " + row + " " + col);
		this.row = row;
		this.col = col;
	}
	
	public static void initializeGridMap(Cell[][] grid) {
	    Cell.gridMap = grid;
	}
	
	public Cell GetCellUp()	{
		return gridMap[row][col-1];
	}
	
	public Cell GetCellDown() {
		return gridMap[row][col+1];
	}
	
	public Cell GetCellLeft() {
		return gridMap[row-1][col];
	}
	
	public Cell GetCellRight() {
		return gridMap[row+1][col];
	}
	
	public void Update() {
		staticElem.Update();
		dynamicElem.Update();
	}
	
	public void OnEnter(Player player) {
		staticElem.OnEnter(player);
	}
	
	public void OnStay(Player player) {
		staticElem.OnStay(player);
	}
	
	public void OnExit(Player player) {
		staticElem.OnExit(player);
	}
	
	public void VerifyMPNeeded(Player player) {
		
	}
	
	public int GetMPNeeded() {
		return staticElem.GetMPNeeded();
	}
	
	public DynamicElem GetDynamicElem(){
		return this.dynamicElem;
	}
	
	public void SetDynamicElem(DynamicElem elem) {
		this.dynamicElem = elem;
	}
	
	public StaticElem GetStaticElem(){
		return this.staticElem;
	}
	
	public void SetStaticElem(StaticElem elem) {
		this.setText("");
		ImageIcon image; 
		
		if(elem instanceof Rock) {
			image = new ImageIcon(getClass().getResource("Rocks.png"));
		}
		else if(elem instanceof Tree) {
			image = new ImageIcon(getClass().getResource("arvore.png"));
		}
		else /* (elem instanceof Grass) */{
			image = new ImageIcon(getClass().getResource("grama.png"));
		}
		if (image.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
		    System.out.println("Imagem carregada com sucesso.");
		    this.setIcon(image);    
		} else {
		    System.out.println("Erro ao carregar a imagem.");
		}
		this.staticElem = elem;
	}
	
	
	
	
	
	

}

















