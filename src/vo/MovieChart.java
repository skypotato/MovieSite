package vo;

public class MovieChart {
	String rnum; // 순위
	String rank;
	String movieCd; // movie번호
	String movieNm; // movie이름
	String openDt; // 개봉일
	String salesAcc; // 누적매출액
	String audiAcc; // 누적관객수
	String scrnCnt; // 스크린수
	String showCnt; // 상영횟수
	
	public MovieChart() {
		super();
		this.rnum = null;
		this.rank = null;
		this.movieCd = null;
		this.movieNm = null;
		this.openDt = null;
		this.salesAcc = null;
		this.audiAcc = null;
		this.scrnCnt = null;
		this.showCnt = null;
	}

	public MovieChart(String rnum, String rank, String movieCd, String movieNm, String openDt, String salesAcc,
			String audiAcc, String scrnCnt, String showCnt) {
		super();
		this.rnum = rnum;
		this.rank = rank;
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.salesAcc = salesAcc;
		this.audiAcc = audiAcc;
		this.scrnCnt = scrnCnt;
		this.showCnt = showCnt;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getSalesAcc() {
		return salesAcc;
	}

	public void setSalesAcc(String salesAcc) {
		this.salesAcc = salesAcc;
	}

	public String getAudiAcc() {
		return audiAcc;
	}

	public void setAudiAcc(String audiAcc) {
		this.audiAcc = audiAcc;
	}

	public String getScrnCnt() {
		return scrnCnt;
	}

	public void setScrnCnt(String scrnCnt) {
		this.scrnCnt = scrnCnt;
	}

	public String getShowCnt() {
		return showCnt;
	}

	public void setShowCnt(String showCnt) {
		this.showCnt = showCnt;
	}
	
}
