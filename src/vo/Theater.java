package vo;

public class Theater {

	private int theatreNum;
	private int totalSeat;

	public Theater() {
		super();
	}

	public Theater(int theatreNum, int totalSeat) {
		super();
		this.theatreNum = theatreNum;
		this.totalSeat = totalSeat;
	}

	public int getTheatreNum() {
		return theatreNum;
	}

	public void setTheatreNum(int theatreNum) {
		this.theatreNum = theatreNum;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

}
