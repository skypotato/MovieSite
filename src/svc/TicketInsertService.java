package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.TicketDao;
import dao.TimeDao;
import vo.Seat;
import vo.TimeInfo;

public class TicketInsertService {

	public boolean registerArticle(ArrayList<Seat> seats, int timeid, String id) throws Exception {
		// TODO Auto-generated method stub

		boolean isRegisterSuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		TicketDao ticketDao = TicketDao.getInstance();
		ticketDao.setConnection(con);
		insertCount = ticketDao.insertTicket(seats, timeid, id);

		if (insertCount > 0) {
			commit(con);
			isRegisterSuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isRegisterSuccess;

	}
}
