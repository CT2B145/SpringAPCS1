package textExcel;

public class EmptyCell implements Cell {

	@Override
	public String abbreviatedCellText() {
		String text = "          ";
		return text;
	}

	@Override
	public String fullCellText() {
		//
		return "";
	}
	public String printCell(){
		
		return null;
	}
	public EmptyCell(){
		
	}

}
