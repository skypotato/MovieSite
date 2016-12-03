package vo;

public class MovieChart {
	String boxofficeType;// �ڽ����ǽ� ����
	String showRange;// �ڽ����ǽ� ��ȸ ����
	String rnum;// ����
	String rank;// �ش������� �ڽ����ǽ� ����
	String rankInten;// ���ϴ�� ������ ������
	String rankOldAndNew;// ��ŷ�� �ű����Կ���
	String movieCd;// ��ȭ�� ��ǥ�ڵ�
	String movieNm;// ��ȭ��(����)
	String openDt;// ��ȭ�� ������
	String salesAmt;// �ش����� �����
	String salesShare;// �ش����� ������ �����Ѿ� ��� �ش� ��ȭ�� �������
	String salesInten;// ���� ��� ����� ������
	String salesChange;// ���� ��� ����� ���� ����
	String salesAcc;// ���������
	String audiCnt;// �ش����� ������
	String audiInten;// ���� ��� ������ ������
	String audiChange;// ���� ��� ������ ���� ����
	String audiAcc;// ����������
	String scrnCnt;// �ش����ڿ� ���� ��ũ����
	String showCnt;// �ش����ڿ� �󿵵� Ƚ��
	String image;// �̹��� URL

	public MovieChart() {
		super();
		this.boxofficeType = "";
		this.showRange = "";
		this.rnum = "";
		this.rank = "";
		this.rankInten = "";
		this.rankOldAndNew = "";
		this.movieCd = "";
		this.movieNm = "";
		this.openDt = "";
		this.salesAmt = "";
		this.salesShare = "";
		this.salesInten = "";
		this.salesChange = "";
		this.salesAcc = "";
		this.audiCnt = "";
		this.audiInten = "";
		this.audiChange = "";
		this.audiAcc = "";
		this.scrnCnt = "";
		this.showCnt = "";
		this.image = "";
	}

	public MovieChart(String boxofficeType, String showRange, String rnum, String rank, String rankInten,
			String rankOldAndNew, String movieCd, String movieNm, String openDt, String salesAmt, String salesShare,
			String salesInten, String salesChange, String salesAcc, String audiCnt, String audiInten, String audiChange,
			String audiAcc, String scrnCnt, String showCnt, String image) {
		super();
		this.boxofficeType = boxofficeType;
		this.showRange = showRange;
		this.rnum = rnum;
		this.rank = rank;
		this.rankInten = rankInten;
		this.rankOldAndNew = rankOldAndNew;
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.salesAmt = salesAmt;
		this.salesShare = salesShare;
		this.salesInten = salesInten;
		this.salesChange = salesChange;
		this.salesAcc = salesAcc;
		this.audiCnt = audiCnt;
		this.audiInten = audiInten;
		this.audiChange = audiChange;
		this.audiAcc = audiAcc;
		this.scrnCnt = scrnCnt;
		this.showCnt = showCnt;
		this.image = image;
	}

	public String getBoxofficeType() {
		return boxofficeType;
	}

	public void setBoxofficeType(String boxofficeType) {
		this.boxofficeType = boxofficeType;
	}

	public String getShowRange() {
		return showRange;
	}

	public void setShowRange(String showRange) {
		this.showRange = showRange;
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

	public String getRankInten() {
		return rankInten;
	}

	public void setRankInten(String rankInten) {
		this.rankInten = rankInten;
	}

	public String getRankOldAndNew() {
		return rankOldAndNew;
	}

	public void setRankOldAndNew(String rankOldAndNew) {
		this.rankOldAndNew = rankOldAndNew;
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

	public String getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
	}

	public String getSalesShare() {
		return salesShare;
	}

	public void setSalesShare(String salesShare) {
		this.salesShare = salesShare;
	}

	public String getSalesInten() {
		return salesInten;
	}

	public void setSalesInten(String salesInten) {
		this.salesInten = salesInten;
	}

	public String getSalesChange() {
		return salesChange;
	}

	public void setSalesChange(String salesChange) {
		this.salesChange = salesChange;
	}

	public String getSalesAcc() {
		return salesAcc;
	}

	public void setSalesAcc(String salesAcc) {
		this.salesAcc = salesAcc;
	}

	public String getAudiCnt() {
		return audiCnt;
	}

	public void setAudiCnt(String audiCnt) {
		this.audiCnt = audiCnt;
	}

	public String getAudiInten() {
		return audiInten;
	}

	public void setAudiInten(String audiInten) {
		this.audiInten = audiInten;
	}

	public String getAudiChange() {
		return audiChange;
	}

	public void setAudiChange(String audiChange) {
		this.audiChange = audiChange;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
