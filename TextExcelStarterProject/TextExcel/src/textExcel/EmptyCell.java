package textExcel;

public class EmptyCell implements Cell {
	
	private String value;
	
	//Constructor for EmptyCell class
	public EmptyCell() {
		this.value = fullCellText();
		abbreviatedCellText();
	}
	
	public String abbreviatedCellText() {
		return "          ";
	}
	
	public String fullCellText() {
		return "";
	}
	
	public String printCell() {
		return "";
	}
}