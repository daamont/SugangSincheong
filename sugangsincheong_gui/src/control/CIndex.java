package control;

import java.util.Vector;

import model.DAOIndex;
import model.MIndex;

public class CIndex {
	
	private DAOIndex daoIndex;
	
	public CIndex() {
		this.daoIndex = new DAOIndex();
	}

	public Vector<MIndex> getList() {
		this.daoIndex = new DAOIndex();
		Vector<MIndex> mIndexList = this.daoIndex.getList();
		//mCampusList는 vo
		return mIndexList;

	}

}
