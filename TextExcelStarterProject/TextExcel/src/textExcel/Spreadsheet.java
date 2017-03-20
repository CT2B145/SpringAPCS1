
package textExcel;
 


public class Spreadsheet implements Grid
{
	private Cell[][] emptycell = new Cell[20][12];
	public Spreadsheet(){
		for( int i = 0; i < emptycell.length; i++){
			for (int j = 0; j<emptycell[i].length; j++){
				emptycell[i][j] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{	int row = 0;
		int col = 0;
		String[] inputcommand = command.split(" ");
		if(command.length()-1 >=2){
			String location = command;
			SpreadsheetLocation cellLocation = new SpreadsheetLocation(location);
			row = cellLocation.getRow();
			col = cellLocation.getCol();
			return emptycell[row][col].fullCellText();
		}else if (inputcommand[1].equals("=")&& inputcommand[2].length()>= 0){
			String location = inputcommand[0];
			SpreadsheetLocation cellLocation = new SpreadsheetLocation(location);
			row = cellLocation.getRow();
			col = cellLocation.getCol();
			if (inputcommand[2].substring(inputcommand[2].length()-1).equals("%")){
				emptycell[row][col] = new PercentCell(inputcommand[2]);
				//return getGridText();
			}else if(inputcommand[2].charAt(0) == '"' && inputcommand[2].charAt(inputcommand[2].length()-1) == '"'){
				emptycell[row][col] = new TextCell(inputcommand[2].substring(1, inputcommand[2].length()-1));
			//	return getGridText();
			}else if(inputcommand[2].charAt(0) == '(' && inputcommand[2].charAt(inputcommand[2].length()-1) == ')'){
				emptycell[row][col] = new FormulaCell(inputcommand[2]);
				//return getGridText();
			}else{
				emptycell[row][col] = new ValueCell(inputcommand[2]);
				return getGridText();
			}
			return getGridText();
		}else if(inputcommand[0].equals("clear") && inputcommand[1].charAt(0) >=0){
			String test = emptycell[row][col].abbreviatedCellText();
			return test;
		}else if(inputcommand[0].equals("clear") && inputcommand[1].charAt(0) <=0)	{
			return getGridText();
		}

		return "";
}

	@Override
	public int getRows()
	{
		int rowCount = 20;
		return rowCount;
	}

	@Override
	public int getCols()
	{
		int colCount = 12;
		
		return colCount;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return emptycell[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String tableholder = "";
		tableholder = tableholder + "   |";
		char col = 'A';
		for(int i = 0; i < 12; i++){
			tableholder = tableholder + ((char)(col)) + "         |";
			col = (char) (col +  1);
		}
		for (int i = 0; i < 20; i++){
			tableholder = tableholder +  "\n";
			if(i<9){
				tableholder = tableholder +  (i+1) + "  |";
			}else{
				tableholder = tableholder +  (i+1) + " |"; // remember there is an extra character
			}
			for(int j = 0; j<12 ; j++){
//				if(emptycell[i][j] != null){
				//emptycell[i][j] = "         ";
					tableholder = tableholder + emptycell[i][j].abbreviatedCellText() + "|";	

			//
			}
		}
		return tableholder + "\n";
	}
}