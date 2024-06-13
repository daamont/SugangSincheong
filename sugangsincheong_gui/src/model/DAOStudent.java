package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAOStudent {
	private MStudent mStudent;

	public DAOStudent() {
		this.mStudent = new MStudent();
	}

	public Vector<MStudent> getList() {
		Vector<MStudent> mStudentList = new Vector<MStudent>();
		DatabaseManager dbm = new DatabaseManager();

		String query = "SELECT * FROM student;";
		ResultSet result = dbm.getQueryResult(query);
		try {
			while (result.next()) {
				mStudent = new MStudent();
				mStudent.setStudentNumber(result.getString(1));
				mStudent.setName(result.getString(2));
				mStudent.setEmail(result.getString(3));
				mStudent.setMajorNumber(result.getString(4));
				mStudent.setPassword(result.getString(5));

				mStudentList.add(mStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.exitDatabase();
		}
		return mStudentList;
	}

	public void getUserId(String inputName, String inputEmail) {
		DatabaseManager dbm = new DatabaseManager();

		String query = "SELECT * FROM student WHERE name = ? AND email = ?;";

		try (Connection conn = dbm.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, inputName);
			pstmt.setString(2, inputEmail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}