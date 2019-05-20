package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class ExamDAO implements java.io.Serializable {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String password = "root";

	private String selectKey = null;
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get one record by StudentNumber
	 * 
	 * @param StudentNumber
	 * @return instance of OneRecord
	 * @throws DAOException
	 */
	public static OneRecord find(String StudentNumber) {
		OneRecord result = null;
//		SQL文の作成
		String sql = "SELECT * FROM examRecords WHERE studentNo = ?";
//		データベースへ接続 PreparedStatement ResultSetの作成
		try (Connection con = DriverManager.getConnection(url + "gradeReport?useSSL=false", user, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, StudentNumber);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String sNo = rs.getString("studentNo");
				String sName = rs.getString("studentName");
				int math = rs.getInt("math");
				int english = rs.getInt("english");
				int japanese = rs.getInt("japanese");
				int science = rs.getInt("science");
				result = new OneRecord(sNo, sName, math, english, japanese, science);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * examRecordsテーブルの全レコード取得
	 * 
	 * @return ArrayList<OneRecord> contents all students data
	 * @throws DAOException
	 */
	public static List<OneRecord> findAll() {
		List<OneRecord> examList = new ArrayList<OneRecord>();
		// SQL文の作成
		String sql = "SELECT studentNo,studentName,math,english,japanese,science FROM examRecords";
//		データベースへ接続 PreparedStatement ResultSetの作成
		try (Connection con = DriverManager.getConnection(url + "gradeReport?useSSL=false", user, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				// SQL実行
				ResultSet rs = pstmt.executeQuery()) {

//			結果をArraylistに格納
			while (rs.next()) {
				String sNo = rs.getString("studentNo");
				String sName = rs.getString("studentName");
				int math = rs.getInt("math");
				int english = rs.getInt("english");
				int japanese = rs.getInt("japanese");
				int science = rs.getInt("science");
				OneRecord oneR = new OneRecord(sNo, sName, math, english, japanese, science);
				examList.add(oneR);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return examList;
	}

	public static void main(String[] args) {
		OneRecord record = find("");
		System.out.println(record == null);
	}
}