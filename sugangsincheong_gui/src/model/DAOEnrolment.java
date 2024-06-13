package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAOEnrolment {
	private MLecture mLecture;

	public DAOEnrolment() {
		// TODO Auto-generated constructor stub
	}

	public Vector<MLecture> getMiridamgiList(String studentNumber) {
		Vector<MLecture> mMiridamgiList = new Vector<MLecture>();
        DatabaseManager dbm = new DatabaseManager();
        String query = "SELECT lecture_number FROM enrolment WHERE student_number = '" + studentNumber + "' AND isEnrolled = 0;";
        
        try {
            ResultSet result = dbm.getQueryResult(query);
            while (result.next()) {
                int lectureNumber = result.getInt("lecture_number");
                String queryLecture = "SELECT * FROM lecture WHERE lecture_number = " + lectureNumber + ";";
                ResultSet resultLecture = dbm.getQueryResult(queryLecture);
                while (resultLecture.next()) {
                    MLecture mLecture = new MLecture();
                    mLecture.setLectureNumber(resultLecture.getInt(1));
                    mLecture.setName(resultLecture.getString(2));
                    mLecture.setProfessor(resultLecture.getString(3));
                    mLecture.setCredit(resultLecture.getInt(4));
                    mLecture.setTime(resultLecture.getString(5));
                    mMiridamgiList.add(mLecture);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mMiridamgiList;
    }

	public Vector<MLecture> getSugangList(String studentNumber) {
		Vector<MLecture> mSugangList = new Vector<MLecture>();
        DatabaseManager dbm = new DatabaseManager();
        String query = "SELECT lecture_number FROM enrolment WHERE student_number = '" + studentNumber + "' AND isEnrolled = 1;";
        
        try {
            ResultSet result = dbm.getQueryResult(query);
            while (result.next()) {
                int lectureNumber = result.getInt("lecture_number");
                String queryLecture = "SELECT * FROM lecture WHERE lecture_number = " + lectureNumber + ";";
                ResultSet resultLecture = dbm.getQueryResult(queryLecture);
                while (resultLecture.next()) {
                    MLecture mLecture = new MLecture();
                    mLecture.setLectureNumber(resultLecture.getInt(1));
                    mLecture.setName(resultLecture.getString(2));
                    mLecture.setProfessor(resultLecture.getString(3));
                    mLecture.setCredit(resultLecture.getInt(4));
                    mLecture.setTime(resultLecture.getString(5));
                    mSugangList.add(mLecture);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mSugangList;
	}
	
	public void insertMiridmagi(String studentNumber, int lectureNumber, int isEnrolled) {
        DatabaseManager dbm = new DatabaseManager();

		String query = "INSERT INTO enrolment (student_number, lecture_number, isEnrolled) VALUES (?, ?, ?)";
	    try (Connection conn = dbm.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setString(1, studentNumber);
	        pstmt.setInt(2, lectureNumber);
	        pstmt.setInt(3, isEnrolled);
	        int result = pstmt.executeUpdate();
	        System.out.println("return: " + result);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteLecture(String studentNumber, int lectureNumber) {
        DatabaseManager dbm = new DatabaseManager();

	    String deleteQuery = "DELETE FROM enrolment WHERE student_number = ? AND lecture_number = ?";
	    try (Connection conn = dbm.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
	        pstmt.setString(1, studentNumber);
	        pstmt.setInt(2, lectureNumber);
	        int result = pstmt.executeUpdate();
	        System.out.println("return: " + result);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void miriToSugang(String studentNumber, int lectureNumber) {
        DatabaseManager dbm = new DatabaseManager();

	    String updateQuery = "UPDATE enrolment SET isEnrolled = 1 WHERE student_number = ? AND lecture_number = ?";
	    try (Connection conn = dbm.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
	        pstmt.setString(1, studentNumber);
	        pstmt.setInt(2, lectureNumber);
	        int result = pstmt.executeUpdate();
	        System.out.println("return: " + result);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void sugangToMiri(String studentNumber, int lectureNumber) {
        DatabaseManager dbm = new DatabaseManager();

	    String updateQuery = "UPDATE enrolment SET isEnrolled = 0 WHERE student_number = ? AND lecture_number = ?";
	    try (Connection conn = dbm.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
	        pstmt.setString(1, studentNumber);
	        pstmt.setInt(2, lectureNumber);
	        int result = pstmt.executeUpdate();
	        System.out.println("return: " + result);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public int getCredit(int lectureNumber) {
        DatabaseManager dbm = new DatabaseManager();
		int credit = 0;
        String query = "SELECT credit FROM lecture WHERE lecture_number = ?";

        try (Connection conn = dbm.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, lectureNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    credit = rs.getInt("credit");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credit;
	}

}
