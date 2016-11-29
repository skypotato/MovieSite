package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.MemberBean;

public class MemberDao {
	DataSource ds;
	Connection con;
	private static MemberDao boardDAO;

	private MemberDao() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDao getInstance() {
		if (boardDAO == null) {
			boardDAO = new MemberDao();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	/* ID 중복확인 */
	public boolean checkID(String id) {

		boolean result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			System.out.println("getConnection");
			sql = "select id from tblMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			result = rs.next();
		} catch (Exception ex) {
			System.out.println("checkID 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;

	}

	/* 회원가입 */
	public int insertMember(MemberBean bean) {

		PreparedStatement pstmt = null;
		String sql = null;
		int insertCount = 0;

		try {
			System.out.println("getConnection");
			sql = "insert tblMember(id,pass,name,phone)" + "values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPass());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getPhone());

			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("insertMember 에러: " + ex);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	/* 로그인 */
	public boolean loginMember(String id, String pass) {

		boolean result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			System.out.println("getConnection");
			sql = "select id from tblMember where id=? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();

			result = rs.next();
		} catch (Exception ex) {
			System.out.println("loginMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/* 회원정보가져오기 */
	public MemberBean getMember(String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = null;

		try {
			System.out.println("getConnection");
			sql = "select * from tblMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPass(rs.getString("pass"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));

			}
		} catch (Exception ex) {
			System.out.println("getMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return bean;
	}

	/* 회원정보수정 */
	public boolean updateMember(MemberBean bean) {

		boolean result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int updateCount = 0;

		try {
			System.out.println("getConnection");
			sql = "update tblMember set pass=?,name=?,phone=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getPass());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPhone());
			updateCount = pstmt.executeUpdate();
			if (updateCount > 0)
				result = true;

		} catch (Exception ex) {
			System.out.println("getMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;

	}

}
