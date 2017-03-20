package textExcel;

public class TextCell implements Cell {

	private String string; // a field
	
	public TextCell(String strInput) {
		this.string = strInput; //taking the command request from process
	}
	
	public String abbreviatedCellText() { //adds the number of spaces needed to keep text aligned
		int spaceNeeded = 10 - this.string.length();
		String finalString = this.string;
		if (this.string.length() < 10) {
			for (int i = 0; i < spaceNeeded; i++) {
				finalString  = finalString +  " ";
			}
			return finalString;
		} else if (this.string.length() == 10){
			return this.string;
		} else {
			finalString = this.string.substring(0, 10);
			return finalString;
		}
	}
	
	public String fullCellText() { // only used for GetCell, this returns on the string
		return "\"" + this.string + "\"";
	}
}