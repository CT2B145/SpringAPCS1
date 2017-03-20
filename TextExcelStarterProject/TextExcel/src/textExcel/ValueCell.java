package textExcel;

public class ValueCell extends RealCell implements Cell {
	
	public ValueCell(String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}