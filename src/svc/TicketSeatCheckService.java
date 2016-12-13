package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.TimeDao;
import vo.Seat;
import vo.TimeInfo;

public class TicketSeatCheckService {

	public ArrayList<Seat> seatCheck(TimeInfo timeInfo) throws Exception {
		// TODO Auto-generated method stub
	
		ArrayList<Seat> seats = new ArrayList<Seat>();
		Connection con = getConnection();
		TimeDao timeDao = TimeDao.getInstance();
		timeDao.setConnection(con);
		seats = timeDao.seatCheck(timeInfo);		
		close(con);
		return seats;

	}

}
