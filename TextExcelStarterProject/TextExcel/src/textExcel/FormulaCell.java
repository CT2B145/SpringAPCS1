package textExcel;

public class FormulaCell extends RealCell{
	private String formanswer;
	private String[] fractionEquationHolder;
	// Constructor for the FormulaCell class
	public FormulaCell (String enteredForm){
		super(enteredForm);
		this.formanswer = enteredForm;
	}

	@Override
	public String abbreviatedCellText() {
		
		
		if(this.formanswer.indexOf("( SUM")>= 0){ //for SUM
			return"";
		} else if(this.formanswer.indexOf("(")>= 0){ //for adding regular numbers

			String removepart = this.formanswer.substring(2,this.formanswer.length()-2);
		 String[] fracEquationHolder = removepart.split(" ",removepart.length()); // holds the fractions and operator
	        String operators = "";
	        double operand;
	        double operand2;
	        boolean hasUppercase = !fractionEquationHolder[0].substring(1).equals(fractionEquationHolder[0].toLowerCase());
	        // object creation to reference sprdlocation to particular cell
	       // SpreadsheetLocation location1 = new SpreadsheetLocation(fractionEquationHolder[0]);
	      //  Spreadsheet getCell = new Spreadsheet();
	        //if(fractionEquationHolder[0].matches(".*[a-zA-Z].*")){
//	        if(hasUppercase){
//	        fractionEquationHolder[0] = getCell.getCell(location1).fullCellText();
//	        }
	        double answer = Double.parseDouble(fracEquationHolder[0]);
//	        // loop to do given math
	        for(int i =0; i <= (fracEquationHolder.length-2); i+=2){
//	        	hasUppercase = !fractionEquationHolder[i].substring(1).equals(fractionEquationHolder[i].toLowerCase());
//		        //if(fractionEquationHolder[i+2].matches(".*[a-zA-Z]+.*")){
//	        	if(hasUppercase){
//			        fractionEquationHolder[i+2] = getCell.getCell(location1).fullCellText();
//			        }
	            operators = fracEquationHolder[i+1];
	            operand = Double.parseDouble(fracEquationHolder[i]);
	            operand2 = Double.parseDouble(fracEquationHolder[i+2]);
	            if(operators.indexOf("+")>=0){
	                answer += operand2;
	            }else if(operators.indexOf("-")>=0){
	                answer -= operand2;
	            }else if(operators.indexOf("*")>=0){
	                answer *=  operand2;
	            }else if(operators.indexOf("/")>=0){
	                answer /=   operand2;
	            }else
	                return(answer+"      "); 
	        }
	        String answer1 = answer +"";
	        int cellValueLength = answer1.length();
			if (cellValueLength < 10){
				while (answer1.length() < 10){
					answer1 += " ";
				}
				return answer1;
			} else if (cellValueLength > 10){
				answer1 = answer1.substring(0, 10);
				return answer1;
			}else{
				return answer1;
			}
			
		}// OUT OF THE MAIN IF
		return"";
	}

	@Override
	public String fullCellText() {
		return super.fullCellText();
	}
	public double getDoubleValue (){ // truncates it
		return Double.parseDouble(this.formanswer.substring(0, this.formanswer.length()-1))/100;
		
	}
	
}