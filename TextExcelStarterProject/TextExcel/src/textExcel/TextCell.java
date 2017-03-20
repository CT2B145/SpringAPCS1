package textExcel;

public class TextCell implements Cell {

	private String str;
	
	public TextCell(String strInput) {
		String string = strInput;
	}
	
	public String abbreviatedCellText() {
		int spaceNum = 10 - this.str.length();
		String revisedStr = this.str;
		if (this.str.length() < 10) {
			for (int i = spaceNum; i > 0; i--) {
				revisedStr += " ";
			}
			return revisedStr;
		} else if (this.str.length() == 10){
			return this.str;
		} else {
			revisedStr = this.str.substring(0, 10);
			return revisedStr;
		}
	}
	
	public String fullCellText() {
		return "\"" + str + "\"";
	}
}