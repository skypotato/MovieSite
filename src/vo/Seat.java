package vo;

public class Seat {
	private char rowChar;
	private int columnNum;
	private int theaterNum;
	private int state;

	public Seat() {
		super();
	}

	public Seat(char rowChar, int columnNum, int theaterNum, int state) {
		super();
		this.rowChar = rowChar;
		this.columnNum = columnNum;
		this.theaterNum = theaterNum;
		this.state = state;
	}

	public char getRowChar() {
		return rowChar;
	}

	public void setRowChar(char rowChar) {
		this.rowChar = rowChar;
	}

	public int getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}

	public int getTheaterNum() {
		return theaterNum;
	}

	public void setTheaterNum(int theaterNum) {
		this.theaterNum = theaterNum;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
