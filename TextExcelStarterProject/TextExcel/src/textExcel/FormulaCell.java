package textExcel;

import java.util.Arrays;

public class FormulaCell extends RealCell{
	private String formanswer;
	//private String cellText = "";
	private Cell[][] sprdsheet;	//saves array from spreadsheet to access information
	private String[][] stringArray;// converts to string to save the hassle
	// Constructor for the FormulaCell class
//	public FormulaCell (String enteredForm){
//		super(enteredForm);
//		this.formanswer = enteredForm;
//	}
	public FormulaCell (String enteredForm, Cell[][] emptycell){
		super(enteredForm);							//constructor to fill super's String field (accesses by fullCellText)
		this.formanswer = enteredForm;		
		sprdsheet = emptycell;
// The question that I cannot figure out, the object array changes to string, but the interior does not... WHY???
		stringArray = Arrays.copyOf(emptycell, emptycell.length, String[][].class);
		//stringArray = emptycell.toArray(new String[][]);
	}
		@Override
	public String abbreviatedCellText() { // processes the infomation here
		
		if(this.formanswer.indexOf("( SUM")>= 0){
			// in theory its supposed to handle the sum of cells listed here
			return"";
		}else if((this.formanswer.indexOf("( AVG")>= 0)){
			// in theory its supposed to handle the sum of cells listed here
			return "";
		} else if(this.formanswer.indexOf("(")>= 0){ //handles anything else that is not SUM or AVG
		String removepart = this.formanswer.substring(2,this.formanswer.length()-2);
		 String[] fracEquationHolder = removepart.split(" ",removepart.length()); // holds the fractions and operator
	        String operators = "";
	        double operand;
	        double operand2;
	        double answer = Double.parseDouble(fracEquationHolder[0]);


	        for(int i =0; i <= (fracEquationHolder.length-2); i+=2){
	        	//This below in theory was supposed to handle "A1", etc. For some reason got an Arrays casting error?
	    //================================================================================
				char charCell = fracEquationHolder[i].charAt(i);	
////			        Spreadsheet getCell1 = new Spreadsheet();
	        	if ((charCell >= 'a'&& charCell <= 'z') || (charCell >= 'A'&& charCell <= 'Z')){
	        		 fracEquationHolder[i] = getCell(fracEquationHolder[i]);
	        	}
	        	
	        	//Goal: to make it less lines as possible. But completely backfired.
//====================================================================================================
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
	        // handles the spacing
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
	
//==============================================================================================
	//For casting to the string array
	public String getCell(String loc) {
		int row = getRow(loc);
		int col = getCol(loc);
		return stringArray[row][col];
	}
    public int getRow(String test) {	//gets the row from the first letter in command
    	
    	int row = Integer.parseInt(test.substring(1))-1;
        return row;
    }

    public int getCol(String col) // retrieves the column from the number value in command
    {  	int j = 0;
    	int colPosition = 0;
    	if(col.charAt(0)>=0){
    		String row = col.toUpperCase();
    		char colfinal = row.charAt(0);
    		j  = (int)colfinal;  	
    		colPosition = j - 65; // since the ascii value of A = 65
    	}
        return colPosition;
    }
}
	
