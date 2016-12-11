package vo;

public class Seat {
	private int seatNum;
	private int theaterNum;
	private boolean state;

	public Seat() {
		super();
	}

	public Seat(int seatNum, int theaterNum, boolean state) {
		super();
		this.seatNum = seatNum;
		this.theaterNum = theaterNum;
		this.state = state;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getTheaterNum() {
		return theaterNum;
	}

	public void setTheaterNum(int theaterNum) {
		this.theaterNum = theaterNum;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
