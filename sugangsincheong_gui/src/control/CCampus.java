package control;

import java.util.Vector;

import model.DAOCampus;
import model.DAOIndex;
import model.MCampus;
import model.MIndex;

public class CCampus{
	
	private DAOCampus daoCampus;
	private DAOIndex daoIndex;

	public CCampus() {
		this.daoCampus = new DAOCampus();
	}
	
	public Vector<MCampus> getList() {
		this.daoCampus = new DAOCampus();
		Vector<MCampus> mCampusList = this.daoCampus.getList();
		//mCampusList는 vo
		return mCampusList;

	}

}
