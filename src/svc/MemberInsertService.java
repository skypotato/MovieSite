package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDao;
import vo.MemberBean;

public class MemberInsertService {

	public boolean registerArticle(MemberBean bean) throws Exception {
		// TODO Auto-generated method stub

		boolean isRegisterSuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		MemberDao memberDAO = MemberDao.getInstance();
		memberDAO.setConnection(con);
		insertCount = memberDAO.insertMember(bean);

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
