package vo;

import java.sql.Date;

public class TimeInfo { // 상영정보

	private int time_id;
	private int movieCd;
	private String movieNm;
	private int theaterNum;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;

	public TimeInfo() {
		super();
	}

	public TimeInfo(int time_id, int movieCd, String movieNm, int theaterNum, String startDate, String endDate,
			String startTime, String endTime) {
		super();
		this.time_id = time_id;
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.theaterNum = theaterNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public int getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(int movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public int getTheaterNum() {
		return theaterNum;
	}

	public void setTheaterNum(int theaterNum) {
		this.theaterNum = theaterNum;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
