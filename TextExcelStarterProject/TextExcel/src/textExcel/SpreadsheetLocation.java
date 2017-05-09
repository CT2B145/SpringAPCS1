package textExcel;

public class SpreadsheetLocation implements Location {
	
	private String name;
	
	//Constructor for SpreadsheetLocation
	public SpreadsheetLocation(String cellname) {
    	name = cellname;
    }

    public int getRow() {	//gets the row from the first letter in command
    	int row;
    	row = Integer.parseInt(name.substring(1))-1;
        return row;
    }

    public int getCol() // retrieves the column from the number value in command
    {  	int j = 0;
    	int colPosition = 0;
    	if(name.charAt(0)>=0){
    		String row = name.toUpperCase();
    		char colfinal = row.charAt(0);
    		j  = (int)colfinal;  	
    		colPosition = j - 65; // since the ascii value of A = 65
    	}
        return colPosition;
    }
}