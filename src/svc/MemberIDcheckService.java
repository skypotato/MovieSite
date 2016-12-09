package svc;
import java.sql.Connection;
import dao.MemberDao;
import vo.MemberBean;
import static db.JdbcUtil.*;


public class MemberIDcheckService {
	public boolean idCheck(String id) throws Exception{
		// TODO Auto-generated method stub
		
		boolean checkSuccess = false;
		Connection con = getConnection();
		MemberDao memberDAO = MemberDao.getInstance();
		memberDAO.setConnection(con);
		boolean flag = memberDAO.checkID(id);

		if(flag){
			checkSuccess = true;
		}
		
		close(con);
		return checkSuccess;
	
	}
}
