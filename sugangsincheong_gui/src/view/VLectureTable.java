package view;

import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.VIndexTable.ListSelectionHandler;

import Constants.Constant.IndexTable;
import control.CLecture;
import model.MLecture;

public class VLectureTable extends VIndexTable {

	private static final long serialVersionUID = 1L;

	// components
	private Vector<MLecture> mLectureList;

//	private String[] header;

	public VLectureTable() {
		super();
		// 모델만들고 다 해야 함
		// model
		// associate
		// get data
		this.mLectureList = new Vector<MLecture>();
	}

	public void initialize() {
		
	}

	public String[] setHeader() {
		String[] header = getHeader();
		header = new String[] { IndexTable.EHeader.eId.getTitle(), IndexTable.EHeader.eLectureName.getTitle(),
				IndexTable.EHeader.eProfessor.getTitle(), IndexTable.EHeader.eCredit.getTitle(),
				IndexTable.EHeader.eTime.getTitle() };
		return header;
	}

	public void show() {
		CLecture cLecture = new CLecture();
		mLectureList = cLecture.getList();
		getTableModel().setRowCount(0);

		// 가져온 강의 목록을 테이블에 추가
		for (MLecture mLecture : mLectureList) {
			String[] row = new String[5];
			row[0] = String.valueOf(mLecture.getLectureNumber());
			row[1] = mLecture.getName();
			row[2] = mLecture.getProfessor();
			row[3] = String.valueOf(mLecture.getCredit());
			row[4] = mLecture.getTime();
//	        System.out.println(row[1]);

			getTableModel().addRow(row); // 행 추가
		}
	}

	public void show(int id, String type) {
		this.model.setRowCount(0);
		if (type == "lecture") {
			CLecture cLecture = new CLecture();
			mLectureList = cLecture.getList(id);
			for (MLecture mLecture : mLectureList) {
				String[] row = new String[5];
				row[0] = String.valueOf(mLecture.getLectureNumber());
				row[1] = mLecture.getName();
				row[2] = mLecture.getProfessor();
				row[3] = String.valueOf(mLecture.getCredit());
				row[4] = mLecture.getTime();
				this.model.addRow(row);
			}
		}

	}

	public Vector<MLecture> getSelectedList() {
		int[] selectedIndies = getTable().getSelectedRows();
		Vector<MLecture> selectedList = new Vector<MLecture>();
		for (int index : selectedIndies) {
			selectedList.add(mLectureList.get(index));
		}
		return selectedList;
	}

	public void addSelectedList(Vector<MLecture> selectedList) {
		getTableModel().setRowCount(0);

		for (MLecture mLecture : selectedList) {
			this.mLectureList.add(mLecture);
			String[] row = new String[5];
			row[0] = String.valueOf(mLecture.getLectureNumber());
			row[1] = mLecture.getName();
			row[2] = mLecture.getProfessor();
			row[3] = String.valueOf(mLecture.getCredit());
			row[4] = mLecture.getTime();
			getTableModel().addRow(row);
		}
		getTable().updateUI();
	}

}