package textExcel;

public class RealCell implements Cell {
private String cellText;
	
	public RealCell(String text){
		this.cellText=text; 
	}
	@Override
	public String abbreviatedCellText() { //adds the number of spaces needed to keep text aligned
		String returnStr = cellText;
		int cellValueLength = cellText.length();
		if (cellValueLength < 10){
			while (returnStr.length() < 10){
				returnStr += " ";
			}
			return returnStr;
		} else if (cellValueLength > 10){
			returnStr = returnStr.substring(0, 10);
			return returnStr;
		}else{
			return cellText;
		}
	}

	@Override
	public String fullCellText() { //used for GetCell only (no quotes needed, since this is a superclass)
		return cellText ;
	}
	public double getDoubleValue() { //extracts the numbers from the cell into a double format
		double num = Double.parseDouble(this.cellText);
		return num;
	}
}