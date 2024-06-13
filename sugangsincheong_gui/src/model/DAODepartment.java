package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAODepartment {

	private MDepartment mDepartment;

	public DAODepartment() {
		this.mDepartment = new MDepartment();
	}

	public Vector<MDepartment> getList() {

		Vector<MDepartment> mDepartmentList = new Vector<MDepartment>();
		DatabaseManager dbm = new DatabaseManager();

		String query = "SELECT * FROM department;";
		ResultSet result = dbm.getQueryResult(query);
		try {
			while (result.next()) {
				mDepartment = new MDepartment();

				mDepartment.setDepartmentNumber(result.getInt(1));
				mDepartment.setName(result.getString(2));
				mDepartment.setCollegeNumber(result.getInt(3));

				mDepartmentList.add(mDepartment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mDepartmentList;

	}

	public Vector<MDepartment> getList(int collegeNumber) {

		Vector<MDepartment> mDepartmentList = new Vector<MDepartment>();
		DatabaseManager dbm = new DatabaseManager();

		String query = "SELECT * FROM department WHERE college_number = "+collegeNumber+";";
		ResultSet result = dbm.getQueryResult(query);
		try {
			while (result.next()) {
				mDepartment = new MDepartment();

				mDepartment.setDepartmentNumber(result.getInt(1));
				mDepartment.setName(result.getString(2));
				mDepartment.setCollegeNumber(result.getInt(3));

				mDepartmentList.add(mDepartment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mDepartmentList;

	}

}
