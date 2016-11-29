package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

	/* Connection Pool에서 Connection 객체를 얻어와서 반환하는 메서드 */
	public static Connection getConnection() {
		Connection con = null;

		try {
			/* 톰캣 자체의 컨텍스트를 얻어 오는 부분 */
			Context initCtx = new InitialContext();
			/* Resource 정의에 관한 Context를 얻어오는 부분 */
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			/* context.xml에 정의한 DataSource 객체를 얻어 오는 부분 */
			DataSource ds = (DataSource) envCtx.lookup("jdbc/MovieSiteDB");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {

		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt) {

		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs) {

		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void commit(Connection con) {

		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void rollback(Connection con) {

		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
