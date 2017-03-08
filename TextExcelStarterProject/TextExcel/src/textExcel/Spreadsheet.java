package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] emptycell;
	@Override
	public String processCommand(String command)
	{
		Cell empty[][]  = new EmptyCell[13][21];
		this.emptycell = empty;
		return command;
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
		
		return null;
	}

	@Override
	public String getGridText()
	{
		String tableholder = "          ";
	
	for(int i= 0; i<13; i++){
		tableholder = tableholder + "\n";
		for(int j = 0; j<21; j++){
			tableholder = tableholder + emptycell[i][j]+"|";
	}
		for(int j = 0; j<20; j++){
			int test =  j + 1;
			emptycell[0][j] = 'a'+ 1;
	}
	}
	
	return tableholder;
}

}
