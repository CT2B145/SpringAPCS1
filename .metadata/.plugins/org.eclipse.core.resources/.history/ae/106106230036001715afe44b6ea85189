package textExcel;

public class RealCell implements Cell {

	private String str; //string value stored in realcell
	
	public RealCell(String str) { //constructor
		this.str = str;
	}
	
	public String abbreviatedCellText() { //returns max 10 characters of fullCellText()
		String answer1 = getDoubleValue() +"";
        int cellValueLength = answer1.length();
		if (cellValueLength < 10){
			while (answer1.length() < 10){
				answer1 += " ";
			}
			return answer1;
		}else if (cellValueLength > 10){
			answer1 = answer1.substring(0, 10);
			return answer1;
		}else{
			return answer1;
		}
	
	}
	
	public String fullCellText() { //returns full and actual value of cell
		return this.str;
	}
	
	public double getDoubleValue() { //converts str into double value
		double num = Double.parseDouble(this.str);
		return num;
	}	
}