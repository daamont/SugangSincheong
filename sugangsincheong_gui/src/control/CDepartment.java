package control;

import java.util.Vector;

import model.DAOCampus;
import model.DAODepartment;
import model.MCampus;
import model.MDepartment;

public class CDepartment{
	
	private DAODepartment daoDepartment;

	public CDepartment() {
		this.daoDepartment = new DAODepartment();
	}
	
	public Vector<MDepartment> getList() {
		this.daoDepartment = new DAODepartment();
		Vector<MDepartment> mDepartmentList = this.daoDepartment.getList();
		//mCampusList는 vo
		return mDepartmentList;

	}
	
	public Vector<MDepartment> getList(int collegeNumber) {
		this.daoDepartment = new DAODepartment();
		Vector<MDepartment> mDepartmentList = this.daoDepartment.getList(collegeNumber);
		//mCampusList는 vo
		return mDepartmentList;

	}

}
