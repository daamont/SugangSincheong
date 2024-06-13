package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAOCampus {
	
	private MCampus mCampus;

	public DAOCampus() {
		this.mCampus = new MCampus();
	}

	public Vector<MCampus> getList() {
		
		Vector<MCampus> mCampusList = new Vector<MCampus>();
		DatabaseManager dbm = new DatabaseManager();
		
		String query = "SELECT * FROM campus;";
		ResultSet result = dbm.getQueryResult(query);
		try {
			while (result.next()) {
				mCampus = new MCampus();
				
				mCampus.setCampusNumber(result.getInt(1));
				mCampus.setName(result.getString(2));
				
				mCampusList.add(mCampus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mCampusList;
		
	}


}
