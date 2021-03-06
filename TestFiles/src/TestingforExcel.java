package textExcel;

public class FormulaCell extends RealCell {
	private String formulaText;
	private Cell[][] userSpreadsheet;
	
	public FormulaCell (String specValue, Cell[][] spreadsheet) {
		super (specValue);
		formulaText = fullCellText().substring(2, fullCellText().length() -2);
		userSpreadsheet = spreadsheet;
	}
	
	public String abbreviatedCellText() {
		String formula = getDoubleValue() + "";
		if (formula.length() > 10) {
			return formula.substring(0, 10);   //truncates integer value longer than 9 characters and adds the percent sign
		} else if (formula.length() == 10) {	//no need to change the integer value since exactly 9 characters long
			return formula;
		} else {
			while (formula.length() < 10) {    //adds spaces so the cell will be 10 characters long if the integer value itself is shorter than 9 characters
				formula += " ";
			}
			return formula;
		}
	}			
			
	public double getDoubleValue() {
		if (formulaText.toUpperCase().indexOf("SUM") != -1) {
			return sumMethod(formulaText);
		} else if (formulaText.toUpperCase().indexOf("AVG") != -1) {
			return avgMethod(formulaText);	
		} else {
			String[] splitSpaces = formulaText.split(" ");
			for (int j = 0; j < splitSpaces.length; j+=2) {
				if (splitSpaces[j].toUpperCase().charAt(0) >= 65) {
					splitSpaces[j] = getCellValue(splitSpaces[j]) + "";
				}
			} 
			double calculation = Double.parseDouble(splitSpaces[0]);
			for (int i = 1; i < splitSpaces.length; i+=2) {
				if (splitSpaces[i].equals("+")) {
					calculation += Double.parseDouble(splitSpaces[i+1]);
				} else if (splitSpaces[i].equals("-")) {
					calculation -= Double.parseDouble(splitSpaces[i+1]);
				} else if (splitSpaces[i].equals("*")) {
					calculation *= Double.parseDouble(splitSpaces[i+1]);
				} else {
					calculation /= Double.parseDouble(splitSpaces[i+1]);
				}
			}
			return calculation;
		}
	}
		
	public double getCellValue(String cellName) {
		SpreadsheetLocation specLoc = new SpreadsheetLocation(cellName);
		double valueOfCell =  ((RealCell) userSpreadsheet[specLoc.getRow()][specLoc.getCol()]).getDoubleValue();
		return valueOfCell;
	}
	
	public double sumMethod (String text) {
		double sumTotal = 0.0;
		text = text.toUpperCase().substring(4);
		String[] splitDash = text.split("-");
		SpreadsheetLocation firstCell = new SpreadsheetLocation(splitDash[0]);
		SpreadsheetLocation lastCell = new SpreadsheetLocation(splitDash[1]);
		for (int cellMarkerCol = firstCell.getCol(); cellMarkerCol <= lastCell.getCol(); cellMarkerCol++) {
			for (int cellMarkerRow = firstCell.getRow(); cellMarkerRow <= lastCell.getRow(); cellMarkerRow++) {
				sumTotal += ((RealCell) userSpreadsheet[cellMarkerRow][cellMarkerCol]).getDoubleValue();
			}
		}
		return sumTotal;
	}
	
	public double avgMethod (String text) {
		double sumTotal = 0.0;
		int numbOfCells = 0;
		text = text.toUpperCase().substring(4);
		String[] splitDash = text.split("-");
		SpreadsheetLocation firstCell = new SpreadsheetLocation(splitDash[0]);
		SpreadsheetLocation lastCell = new SpreadsheetLocation(splitDash[1]);
		for (int cellMarkerCol = firstCell.getCol(); cellMarkerCol <= lastCell.getCol(); cellMarkerCol++) {
			for (int cellMarkerRow = firstCell.getRow(); cellMarkerRow <= lastCell.getRow(); cellMarkerRow++) {
				sumTotal += ((RealCell) userSpreadsheet[cellMarkerRow][cellMarkerCol]).getDoubleValue();
				numbOfCells ++;
			}
		}
		return (sumTotal / numbOfCells);
		
	}
	
}


