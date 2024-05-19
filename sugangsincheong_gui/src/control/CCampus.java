package control;

import java.util.Vector;

import model.DAOCampus;
import model.MCampus;

public class CCampus {
	
	private DAOCampus daoCampus;
	
	public CCampus() {
		this.daoCampus = new DAOCampus();
	}

	public Vector<MCampus> getList(String fileName) {
		this.daoCampus = new DAOCampus();
		Vector<MCampus> mCampusList = this.daoCampus.getList(fileName);
		//mCampusList는 vo
		return mCampusList;

	}

}
