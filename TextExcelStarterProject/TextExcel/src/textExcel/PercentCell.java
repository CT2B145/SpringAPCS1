package textExcel;

public class PercentCell extends RealCell {
	private double percent;
	
	public PercentCell(String initialValue){
		super(initialValue);								
	}

	@Override
	public String abbreviatedCellText() { //refers the to superclass methods
		return super.abbreviatedCellText();
	}

	@Override
	public String fullCellText() { //converts it to the requested decimal format in test files
		return (getDoubleValue()/100.0) + "";				
	}
	
	public double getDoubleValue(){ //refers the to superclass methods and extracts the number from that value
		return Double.parseDouble(super.fullCellText()); 		
	}

}