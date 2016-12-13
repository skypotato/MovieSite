package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Seat;
import vo.TimeInfo;

public class TicketDao {
	DataSource ds;
	Connection con;
	private static TicketDao timeDAO;

	private TicketDao() {
		// TODO Auto-generated constructor stub
	}

	public static TicketDao getInstance() {
		if (timeDAO == null) {
			timeDAO = new TicketDao();
		}
		return timeDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertTicket(ArrayList<Seat> seatList, int timeid, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int insertCount = 0;
		int updateSeatState = 0;
		TimeInfo timeInfo = new TimeInfo();
		int theaterNum = seatList.get(0).getTheaterNum();
		String seatStr = "";

		try {
			// 좌석 상태를 예약상태로 바꾼다.
			for (Seat seat : seatList) {
				System.out.println("getConnection");
				sql = "update seat set state=true where rowChar=? and columnNum=? and theaterNum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, String.valueOf(seat.getRowChar()));
				pstmt.setInt(2, seat.getColumnNum());
				pstmt.setInt(3, seat.getTheaterNum());
				seatStr += seat.getRowChar() + "-" + seat.getColumnNum() + "|";
				updateSeatState = pstmt.executeUpdate();
			}

			// 영화제목과 시작시간 받아오기
			sql = "select startTime, movieNm from time_info where time_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, timeid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				timeInfo.setStartTime(rs.getString("startTime"));
				timeInfo.setMovieNm(rs.getString("movieNm"));
			}

			// 예약 등록
			sql = "insert tiket_info(time_id,id,seat_id,theaterNum,movieNm,startTime) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, timeid);
			pstmt.setString(2, id);
			pstmt.setString(3, seatStr);
			pstmt.setInt(4, theaterNum);
			pstmt.setString(5, timeInfo.getStartTime());
			pstmt.setString(6, timeInfo.getMovieNm());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("listTime : " + ex);
		} finally {
			close(pstmt);
			close(rs);

		}
		return updateSeatState;

	}

}
