package Control;

import java.util.Vector;

import Model.DAOCampus;
import Model.MCampus;

public class CCampus {
	
	private DAOCampus daoCampus;
	public CCampus() {
	}

	public Vector<MCampus> getList() {
		this.daoCampus = new DAOCampus();
		Vector<MCampus> mCampusList = this.daoCampus.getList();
		//mCampusList는 vo
		return mCampusList;

	}

}
