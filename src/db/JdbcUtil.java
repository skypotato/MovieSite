package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

	/* Connection Pool���� Connection ��ü�� ���ͼ� ��ȯ�ϴ� �޼��� */
	public static Connection getConnection() {
		Connection con = null;

		try {
			/* ��Ĺ ��ü�� ���ؽ�Ʈ�� ��� ���� �κ� */
			Context initCtx = new InitialContext();
			/* Resource ���ǿ� ���� Context�� ������ �κ� */
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			/* context.xml�� ������ DataSource ��ü�� ��� ���� �κ� */
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
