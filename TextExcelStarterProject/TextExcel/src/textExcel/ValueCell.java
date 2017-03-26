package textExcel;

public class ValueCell extends RealCell {
	private String cellText;
	public ValueCell(String text){
		super(text);
		this.cellText=text; 
	}
	@Override
	public String abbreviatedCellText() {//adds spaces to the decimal or non decimaled number
		double numbers = Double.parseDouble(this.cellText);
		String withSpaces= numbers+ "          ";
			return withSpaces.substring(0,10);
	}
	public String fullCellText() {//refers the to superclass methods
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue() {//refers the to superclass methods
		return super.getDoubleValue();
	}
}