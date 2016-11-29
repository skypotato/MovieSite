package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDao;
import vo.MemberBean;

public class MemberLoginService {
	public boolean loginArticle(MemberBean bean) throws Exception {
		// TODO Auto-generated method stub

		boolean isLoginSuccess = false;
		Connection con = getConnection();
		MemberDao memberDAO = MemberDao.getInstance();
		memberDAO.setConnection(con);
		isLoginSuccess = memberDAO.loginMember(bean.getId(), bean.getPass());
		close(con);
		return isLoginSuccess;

	}
}
