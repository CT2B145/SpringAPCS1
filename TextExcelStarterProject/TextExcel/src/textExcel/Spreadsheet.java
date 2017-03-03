package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	@Override
	public String processCommand(String command)
	{
		Cell empty[][]  = new EmptyCell[12][20];
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
		
		return null;
	}

}
