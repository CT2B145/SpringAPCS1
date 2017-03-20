package textExcel;

public class PercentCell extends RealCell {
	private double valueDoub;
	public PercentCell(String enteredVal){
		super (enteredVal);
		valueDoub = Double.parseDouble(super.fullCellText());		
	}

	@Override
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return valueDoub + "%";
	}
	
	public double getDoubleValue(){
		return valueDoub;
	}

}