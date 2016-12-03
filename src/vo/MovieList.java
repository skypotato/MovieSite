package vo;

public class MovieList {
	String movieCd;// ��ȭ�ڵ�
	String movieNm;// ��ȭ��(����)
	String movieNmEn;// ��ȭ��(����)
	String prdtYear;// ���ۿ���
	String openDt;// ��������
	String typeNm;// ��ȭ����
	String prdtStatNm;// ���ۻ���
	String nationAlt;// ���۱���(��ü)
	String genreAlt;// ��ȭ�帣(��ü)
	String repNationNm;// ��ǥ ���۱�����
	String repGenreNm;// ��ǥ �帣��
	String directors;// ��ȭ����
	String peopleNm;// ��ȭ������
	String companys;// ���ۻ�
	String companyCd;// ���ۻ� �ڵ�
	String companyNm;// ���ۻ��

	public MovieList() {
		super();
		this.movieCd = "";
		this.movieNm = "";
		this.movieNmEn = "";
		this.prdtYear = "";
		this.openDt = "";
		this.typeNm = "";
		this.prdtStatNm = "";
		this.nationAlt = "";
		this.genreAlt = "";
		this.repNationNm = "";
		this.repGenreNm = "";
		this.directors = "";
		this.peopleNm = "";
		this.companys = "";
		this.companyCd = "";
		this.companyNm = "";
	}

	public MovieList(String movieCd, String movieNm, String movieNmEn, String prdtYear, String openDt, String typeNm,
			String prdtStatNm, String nationAlt, String genreAlt, String repNationNm, String repGenreNm,
			String directors, String peopleNm, String companys, String companyCd, String companyNm) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.movieNmEn = movieNmEn;
		this.prdtYear = prdtYear;
		this.openDt = openDt;
		this.typeNm = typeNm;
		this.prdtStatNm = prdtStatNm;
		this.nationAlt = nationAlt;
		this.genreAlt = genreAlt;
		this.repNationNm = repNationNm;
		this.repGenreNm = repGenreNm;
		this.directors = directors;
		this.peopleNm = peopleNm;
		this.companys = companys;
		this.companyCd = companyCd;
		this.companyNm = companyNm;
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

	public String getMovieNmEn() {
		return movieNmEn;
	}

	public void setMovieNmEn(String movieNmEn) {
		this.movieNmEn = movieNmEn;
	}

	public String getPrdtYear() {
		return prdtYear;
	}

	public void setPrdtYear(String prdtYear) {
		this.prdtYear = prdtYear;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getTypeNm() {
		return typeNm;
	}

	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}

	public String getPrdtStatNm() {
		return prdtStatNm;
	}

	public void setPrdtStatNm(String prdtStatNm) {
		this.prdtStatNm = prdtStatNm;
	}

	public String getNationAlt() {
		return nationAlt;
	}

	public void setNationAlt(String nationAlt) {
		this.nationAlt = nationAlt;
	}

	public String getGenreAlt() {
		return genreAlt;
	}

	public void setGenreAlt(String genreAlt) {
		this.genreAlt = genreAlt;
	}

	public String getRepNationNm() {
		return repNationNm;
	}

	public void setRepNationNm(String repNationNm) {
		this.repNationNm = repNationNm;
	}

	public String getRepGenreNm() {
		return repGenreNm;
	}

	public void setRepGenreNm(String repGenreNm) {
		this.repGenreNm = repGenreNm;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getPeopleNm() {
		return peopleNm;
	}

	public void setPeopleNm(String peopleNm) {
		this.peopleNm = peopleNm;
	}

	public String getCompanys() {
		return companys;
	}

	public void setCompanys(String companys) {
		this.companys = companys;
	}

	public String getCompanyCd() {
		return companyCd;
	}

	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}

	public String getCompanyNm() {
		return companyNm;
	}

	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

}
