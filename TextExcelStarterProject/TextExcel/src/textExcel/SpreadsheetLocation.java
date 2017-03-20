package textExcel;

public class SpreadsheetLocation implements Location {
	
	private String name;
	
	//Constructor for SpreadsheetLocation
	public SpreadsheetLocation(String cellname) {
    	this.name = cellname;
    }

    public int getRow() {	// Retrieving the number from the ex. "a1" phrase and using the "1" for the row count
    	int row;
    	row = Integer.parseInt(name.substring(1))-1;
        return row;
    }

    public int getCol()
    { //FIXME PLEASSEEEE
        int j = 0;
    	int colPosition = 0;
    	if(name.charAt(0)>=0){
    		String row = name.toUpperCase();
    		char colfinal = row.charAt(0);
    		j  = (int)colfinal;  	
    		colPosition = j - 65; // since ascii value of A = 65
    	}
        return colPosition;
    }
}