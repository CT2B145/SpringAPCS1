package textExcel;

public class FormulaCell extends RealCell{
	private String formanswer;
	//private String[] fractionEquationHolder;
	private Spreadsheet sprdsheet;	//saves array from spreadsheet to access information from Spreadsheet
	private Cell[][] breadsheet;

	// Constructor for the FormulaCell class
	public FormulaCell (String enteredForm, Spreadsheet emptycell, Cell[][] breadsheet){
		// TODO divided between Cell [][] or Spreadsheet object. Everytime I try Cell[][] objects, getDoubleValue method fails to exist.
		super(enteredForm);							//constructor to fill super's String field (accesses by fullCellText)
		formanswer = enteredForm;		
		sprdsheet = emptycell;
		this.breadsheet = breadsheet;
	}

	public double sum(String total) { // adds the cells in the when SUM is requested
		String[] cellParts = total.split("-");
		double sum = 0;
		int rowBeg = Integer.parseInt(cellParts[0].substring(1));//numbers
		int rowEnd = Integer.parseInt(cellParts[1].substring(1));
		char colBeg = cellParts[0].charAt(0); // letters
		char colEnd = cellParts[1].charAt(0);
		for (char i = colBeg; i < colEnd; i++) {
			for (int j = rowBeg; j < rowEnd; j++) {
				SpreadsheetLocation gridLoc = new SpreadsheetLocation(i + j + "");
				//sum += ((RealCell) sprdsheet.getCell(gridLoc)).getDoubleValue();
				sum += ((RealCell) breadsheet[i][j]).getDoubleValue();
		}
		
	} // TODO Similiar to the issue below.
		return sum;
	}
	
	public double avg(String total) { // figures out the average of the lot
		String[] cellParts = total.split("-");
		int next = 0;
		double avgTotal = 0;
		String hold;
		int rowBeg = Integer.parseInt(cellParts[0].substring(1)); //numbers
		int rowEnd = Integer.parseInt(cellParts[1].substring(1));
		char colBeg = cellParts[0].charAt(0);// letters
	//	char colEnd = cellParts[1].charAt(0);
		char i = colBeg;
		//if(colBeg == colEnd){
			for (int j = rowBeg; j < rowEnd; j++) {
				SpreadsheetLocation gridLoc = new SpreadsheetLocation(i+j+"");
				avgTotal += ((RealCell) breadsheet[i][j]).getDoubleValue();
				next++;
			//	TODO Here is the problem. next is not incrementing, nor is avgTotal recieving any data
				// TODO both are seeming stuck at 0.0
		}
	//}
		return avgTotal/next;	
	}
//	public double calculate (String operator, double operand, double operand2){
////	            operand = Double.parseDouble(opera);
////	            operand2 = Double.parseDouble(b);
//	            if(operator.indexOf("+")>=0){
//	                answer += operand2;
//	            }else if(operator.indexOf("-")>=0){
//	                answer -= operand2;
//	            }else if(operator.indexOf("*")>=0){
//	                answer *=  operand2;
//	            }else if(operator.indexOf("/")>=0){
//	                answer /=   operand2;
//	            }else{
//	                return answer;
//			}	                return answer;
//
//	}
	@Override
	public double getDoubleValue() {
		String removepart = formanswer.substring(2,formanswer.length()-2);
		 String[] fracEquationHolder = removepart.split(" ",removepart.length()); // holds the fractions and operator
		  double operand;
	      double operand2;
	      double answer;
		if (removepart.toUpperCase().indexOf("SUM")>=0){ //filters out SUM
			return sum(fracEquationHolder[1]);
		}else if (removepart.toUpperCase().indexOf("AVG")>=0) { //filters out AVG
			return sum(fracEquationHolder[1]);
		}else{
			for (int j = 0; j < fracEquationHolder.length; j+=2) {
				if (fracEquationHolder[j].toUpperCase().charAt(0) >= 65) {
					fracEquationHolder[j] = getCellValue(fracEquationHolder[j]) + "";
				}
			} 
			answer = Double.parseDouble(fracEquationHolder[0]);
			for (int i = 1; i < fracEquationHolder.length; i+=2) {
				if (fracEquationHolder[i].equals("+")) {
					answer += Double.parseDouble(fracEquationHolder[i+1]);
				}else if(fracEquationHolder[i].equals("-")) {
					answer -= Double.parseDouble(fracEquationHolder[i+1]);
				}else if(fracEquationHolder[i].equals("/")) {
					answer /= Double.parseDouble(fracEquationHolder[i+1]);
				}else if (fracEquationHolder[i].equals("*")) {
					answer *= Double.parseDouble(fracEquationHolder[i+1]);
				}else {
					throw new IllegalArgumentException("ERro, operator does not exist");
				}
			}
		}// for the needed spaces
		return answer;
	}
	public double getCellValue(String cellPlace) {
		SpreadsheetLocation gridLoc = new SpreadsheetLocation(cellPlace);
		double cellvalue =  ((RealCell) breadsheet[gridLoc.getRow()][gridLoc.getCol()]).getDoubleValue();
		return cellvalue;
	}
	
	
	@Override
	public String abbreviatedCellText() {
//return super.abbreviatedCellText();
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

	@Override
	public String fullCellText() {
		return super.fullCellText();
	}
}
	