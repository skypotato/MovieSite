package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDao;
import dao.TimeDao;
import vo.MemberBean;
import vo.TimeInfo;

public class TimeListService {

	public ArrayList<TimeInfo> registerArticle() throws Exception {
		// TODO Auto-generated method stub

		ArrayList<TimeInfo> timeArr = new ArrayList<TimeInfo>();
		Connection con = getConnection();
		TimeDao timeDao = TimeDao.getInstance();
		timeDao.setConnection(con);
		timeArr = timeDao.listTime();
		close(con);
		return timeArr;
	}

}
