package textExcel;

public class RealCell implements Cell {
private String cellText;
	
	public RealCell(String text){
		this.cellText=text; 
	}
	@Override
	public String abbreviatedCellText() {
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
	public String fullCellText() {
		return "\"" + cellText + "\"";
	}
	public double getDoubleValue() {
		double num = Double.parseDouble(this.cellText);
		return num;
	}
}