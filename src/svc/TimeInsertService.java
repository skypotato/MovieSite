package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDao;
import dao.TimeDao;
import vo.MemberBean;
import vo.TimeInfo;

public class TimeInsertService {

	public boolean registerArticle(TimeInfo timeInfo) throws Exception {
		// TODO Auto-generated method stub

		boolean isRegisterSuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		TimeDao timeDao = TimeDao.getInstance();
		timeDao.setConnection(con);
		insertCount = timeDao.insertTime(timeInfo);

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
