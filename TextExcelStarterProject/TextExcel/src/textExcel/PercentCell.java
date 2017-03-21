package textExcel;

public class PercentCell extends RealCell implements Cell{

	private String input;
	public PercentCell (String test){
		super (test);
		this.input = test;
	}
	
	public String abbreviatedCellText() { // returns the needed pecentages for the table
		String roundfrac;
		if(this.input.indexOf(".")<0){
			roundfrac = this.input;
		}else{
			roundfrac = this.input.substring(0, this.input.indexOf("."));
		}
		roundfrac += "%";
		int cellValueLength = roundfrac.length()-1;
		if (cellValueLength < 10){
			while (roundfrac.length() < 10){
				roundfrac += " ";
			}
			return roundfrac;
		} else if (cellValueLength > 10){
			roundfrac = roundfrac.substring(0, 10);
			return roundfrac;
		}else{
			return roundfrac;
		}
	}

	public String fullCellText() { // gets value for the inspect file
		return getDoubleValue()+"";
	}
	
	public double getDoubleValue (){ // truncates it
		return Double.parseDouble(this.input.substring(0, this.input.length()-1))/100;
		
	}

}