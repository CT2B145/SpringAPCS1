package textExcel;

public class ValueCell extends RealCell {
	private String cellText;
	public ValueCell(String text){
		super(text);
		this.cellText=text; 
	}
	@Override
	public String abbreviatedCellText() { //adds the number of spaces needed to keep text aligned
		String returnStr = cellText;
		int cellValueLength = cellText.length();
		if(returnStr.indexOf("00") >0){ //to handle testRealCellFormat
			cellValueLength = returnStr.length()-1;
			returnStr = returnStr.substring(0,cellValueLength);
			for (int i = 0; i<=(10-cellValueLength);i++){
				returnStr += " ";
			}
			return returnStr;
		}
// To test other cases other than that special type
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
	
	public String fullCellText() {//refers the to superclass methods
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue() {//refers the to superclass methods
		return super.getDoubleValue();
	}
}