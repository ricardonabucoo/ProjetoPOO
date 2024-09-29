package essentials;

public class Cell {

	private static Cell[][] gridMap;
	private int row, col;
	private StaticElem staticElem;
	private DynamicElem dynamicElem;
	
	public Cell(int row, int col) {
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
		this.staticElem = elem;
	}
	
	
	
	
	
	

}

















