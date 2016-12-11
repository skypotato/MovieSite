package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.MemberBean;
import vo.TimeInfo;

public class TimeDao {
	DataSource ds;
	Connection con;
	private static TimeDao timeDAO;

	private TimeDao() {
		// TODO Auto-generated constructor stub
	}

	public static TimeDao getInstance() {
		if (timeDAO == null) {
			timeDAO = new TimeDao();
		}
		return timeDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	/* 타임 저장 */
	public int insertTime(TimeInfo timeInfo) {

		PreparedStatement pstmt = null;
		String sql = null;
		int insertCount = 0;

		try {
			System.out.println("getConnection");
			sql = "insert time_info(movieCd,movieNm,theaterNum,startDate,endDate,startTime,endTime)"
					+ "values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, timeInfo.getMovieCd());
			pstmt.setString(2, timeInfo.getMovieNm());
			pstmt.setInt(3, timeInfo.getTheaterNum());
			pstmt.setString(4, timeInfo.getStartDate());
			pstmt.setString(5, timeInfo.getEndDate());
			pstmt.setString(6, timeInfo.getStartTime());
			pstmt.setString(7, timeInfo.getEndTime());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("insertMember 에러: " + ex);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<TimeInfo> listTime() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<TimeInfo> timeArr = new ArrayList<TimeInfo>();

		try {
			System.out.println("getConnection");
			sql = "select movieCd,movieNm,theaterNum,startDate,endDate,startTime,endTime from time_info "
					+ "where date(startDate) <= date(now()) and date(endDate) > date(now())";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TimeInfo timeInfo = new TimeInfo();
				timeInfo.setMovieCd(rs.getInt("movieCd"));
				timeInfo.setMovieNm(rs.getString("movienm"));
				timeInfo.setTheaterNum(rs.getInt("theaterNum"));
				timeInfo.setStartDate(rs.getString("startDate"));
				timeInfo.setEndDate(rs.getString("endDate"));
				timeInfo.setStartTime(rs.getString("startTime"));
				timeInfo.setEndTime(rs.getString("endTime"));
				timeArr.add(timeInfo);
			}

		} catch (Exception ex) {
			System.out.println("listTime 에러: " + ex);
		} finally {
			close(pstmt);
			close(rs);
		}
		return timeArr;
	}

}
