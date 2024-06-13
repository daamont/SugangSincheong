package control;

import java.util.Vector;

import model.DAOLecture;
import model.MLecture;

public class CLecture {
	
	private DAOLecture daoLecture;

	public CLecture() {
		this.daoLecture = new DAOLecture();
	}
	
	public Vector<MLecture> getList() {
		this.daoLecture = new DAOLecture();
		Vector<MLecture> mLectureList = this.daoLecture.getList();
		//mCampusList는 vo
		return mLectureList;

	}

	public Vector<MLecture> getList(int departmentNumber) {
		this.daoLecture = new DAOLecture();
		Vector<MLecture> mLectureList = this.daoLecture.getList(departmentNumber);
		//mCampusList는 vo
		return mLectureList;
	}

}
