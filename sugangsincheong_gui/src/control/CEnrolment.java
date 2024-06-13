package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.DAOEnrolment;
import model.DAOLecture;
import model.DatabaseManager;
import model.MLecture;

public class CEnrolment {

	private DAOEnrolment daoEnrolment;

	public CEnrolment() {
		this.daoEnrolment = new DAOEnrolment();
	}
	
	public Vector<MLecture> getMiridamgiList(String studentNumber) {
		this.daoEnrolment = new DAOEnrolment();
		Vector<MLecture> mLectureList = this.daoEnrolment.getMiridamgiList(studentNumber);
		//mCampusList는 vo
		return mLectureList;
	}

	public Vector<MLecture> getSugangList(String studentNumber) {
		this.daoEnrolment = new DAOEnrolment();
		Vector<MLecture> mLectureList = this.daoEnrolment.getSugangList(studentNumber);
		//mCampusList는 vo
		return mLectureList;
	}

	public boolean checkOverlap(String studentNumber, int lectureNumber) {
		DatabaseManager dbm = new DatabaseManager();

		String query = "SELECT * FROM enrolment WHERE student_number = '" + studentNumber + "' AND lecture_number = " + lectureNumber + ";";
		ResultSet result = dbm.getQueryResult(query);
		try {
	        if (result.next()) {
	            return false; // 중복이므로 false 반환
	        } else {
	            return true; // 중복이 아니므로 true 반환
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // 오류 발생 시 false 반환
	    }
	}

	public void insertMiridmagi(String studentNumber, int lectureNumber, int isEnrolled) {
        daoEnrolment.insertMiridmagi(studentNumber, lectureNumber, isEnrolled);

	}

	public void deleteLecture(String studentNumber, int lectureNumber) {
        daoEnrolment.deleteLecture(studentNumber, lectureNumber);

	}

	public void miriToSugang(String studentNumber, int lectureNumber) {
        daoEnrolment.miriToSugang(studentNumber, lectureNumber);

	}

	public void sugangToMiri(String studentNumber, int lectureNumber) {
        daoEnrolment.sugangToMiri(studentNumber, lectureNumber);

	}

	public int calculateSugangCredit(String studentNumber) {
		int sugangCredit = 0;
		this.daoEnrolment = new DAOEnrolment();
		Vector<MLecture> mSugangList = this.daoEnrolment.getSugangList(studentNumber);
		for (MLecture lecture : mSugangList) {
            int credit = daoEnrolment.getCredit(lecture.getLectureNumber());
            sugangCredit += credit;
        }
        return sugangCredit;
	}


}
