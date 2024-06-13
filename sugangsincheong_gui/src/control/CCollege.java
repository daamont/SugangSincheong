package control;

import java.util.Vector;

import model.DAOCollege;
import model.MCollege;
import model.MLecture;

public class CCollege{
	
	private DAOCollege daoCollege;

	public CCollege() {
		this.daoCollege = new DAOCollege();
	}
	
	public Vector<MCollege> getList() {
		this.daoCollege = new DAOCollege();
		Vector<MCollege> mCollegeList = this.daoCollege.getList();
		//mCampusList는 vo
		return mCollegeList;

	}

	public Vector<MCollege> getList(int campusNumber) {
		this.daoCollege = new DAOCollege();
		Vector<MCollege> mCollegeList = this.daoCollege.getList(campusNumber);
		return mCollegeList;
	}
	

}
