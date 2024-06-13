package model;

import java.util.Vector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLecture {
	
	private MLecture mLecture;

	public DAOLecture() {
		this.mLecture = new MLecture();
	}

	public Vector<MLecture> getList() {
		
		Vector<MLecture> mLectureList = new Vector<MLecture>();
		DatabaseManager dbm = new DatabaseManager();

		String query = "SELECT * FROM lecture;";
		ResultSet result = dbm.getQueryResult(query);
		try {
			while (result.next()) {
				mLecture = new MLecture();
				
				mLecture.setLectureNumber(result.getInt(1));
				mLecture.setName(result.getString(2));
				mLecture.setProfessor(result.getString(3));
				mLecture.setCredit(result.getInt(4));
				mLecture.setTime(result.getString(5));

				mLectureList.add(mLecture);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mLectureList;

	}

	public Vector<MLecture> getList(int departmentNumber) {
		Vector<MLecture> mLectureList = new Vector<MLecture>();
        DatabaseManager dbm = new DatabaseManager();

        String query = "SELECT * FROM lecture WHERE department_number = " + departmentNumber + ";";
        ResultSet result = dbm.getQueryResult(query);
        try {
            while (result.next()) {
                mLecture = new MLecture();
                mLecture.setLectureNumber(result.getInt(1));
                mLecture.setName(result.getString(2));
                mLecture.setProfessor(result.getString(3));
                mLecture.setCredit(result.getInt(4));
                mLecture.setTime(result.getString(5));
                mLectureList.add(mLecture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mLectureList;
    }

}
