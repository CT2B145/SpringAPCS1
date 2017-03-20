package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String value) {//refers the to superclass constructor
		super(value);
	}
	
	public String abbreviatedCellText() { //refers the to superclass methods
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {//refers the to superclass methods
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue() {//refers the to superclass methods
		return super.getDoubleValue();
	}
}