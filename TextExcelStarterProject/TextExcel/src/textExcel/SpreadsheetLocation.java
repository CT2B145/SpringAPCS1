package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String name;
	public SpreadsheetLocation(String cellName)
    {	
     name = cellName;
//    	Location loc = new SpreadsheetLocation(cellName);
//    	loc.getCol();
//    	loc.getRow();
    }
    @Override
    public int getRow()
    { // FIXME fix variables
    	// FIXME fix variables
    	name = name.substring(1);
    	 // FIXME fix variables
    	int j = Integer.parseInt(name);
    	int colPosition = j-1;
        return colPosition;
    }

    @Override
    public int getCol()
    { //FIXME PLEASSEEEE
        int j = 0;
    	int rowPosition = 0;
    	if(name.charAt(0)>=0){
    		char row = name.charAt(0);
    		j  = (int)row;  	
    		rowPosition = j - 65; // since ascii value of A = 65
    	}
        return rowPosition;
    }
    
    

}
