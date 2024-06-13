package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAOCollege{
	
	private MCollege mCollege;
	
	public DAOCollege() {
		this.mCollege = new MCollege();
	}

	public Vector<MCollege> getList() {
		
		Vector<MCollege> mCollegeList = new Vector<MCollege>();
		DatabaseManager dbm = new DatabaseManager();
		
		String query = "SELECT * FROM college;";
		ResultSet result = dbm.getQueryResult(query);
		try {
			while (result.next()) {
				mCollege = new MCollege();
				
				mCollege.setCollegeNumber(result.getInt(1));
				mCollege.setName(result.getString(2));
				mCollege.setCampusNumber(result.getInt(3));
				
				mCollegeList.add(mCollege);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mCollegeList;
		
	}

	public Vector<MCollege> getList(int campusNumber) {
		Vector<MCollege> mCollegeList = new Vector<MCollege>();
        DatabaseManager dbm = new DatabaseManager();

        String query = "SELECT * FROM college WHERE campus_number = " + campusNumber + ";";
        ResultSet result = dbm.getQueryResult(query);
        try {
            while (result.next()) {
            	mCollege = new MCollege();
            	
            	mCollege.setCollegeNumber(result.getInt(1));
				mCollege.setName(result.getString(2));
				mCollege.setCampusNumber(result.getInt(3));
				
                mCollegeList.add(mCollege);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mCollegeList;
    }

}
