package view;

import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.VIndexTable.ListSelectionHandler;

import Constants.Constant.IndexTable;
import control.CLecture;
import model.MLecture;

public class VLectureTable extends VIndexTable{

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
		String [] header = getHeader();
		header = new String[] {IndexTable.EHeader.eId.getTitle(), 
				IndexTable.EHeader.eLectureName.getTitle(),
				IndexTable.EHeader.eProfessor.getTitle(),
				IndexTable.EHeader.eCredit.getTitle(),
				IndexTable.EHeader.eTime.getTitle()
				};
		return header;
	}
	

	public void show(String filename) {
		CLecture cLecture = new CLecture();
		mLectureList = cLecture.getList(filename);
		getTableModel().setRowCount(0);

		// 가져온 강의 목록을 테이블에 추가
		for (MLecture mLecture : mLectureList) {
			String[] row = new String[5];
			row[0] = String.valueOf(mLecture.getId());
			row[1] = mLecture.getName();
			row[2] = mLecture.getProfessor();
			row[3] = String.valueOf(mLecture.getCredit());
			row[4] = mLecture.getTime();
//	        System.out.println(row[1]);

			getTableModel().addRow(row); // 행 추가
		}
	}
	
//	public class ListSelectionHandler implements ListSelectionListener {
//		public void valueChanged(ListSelectionEvent e) {
//			if (!e.getValueIsAdjusting()) {
//				int row = getTable().getSelectedRow();				
//				showNext(row);
//				System.out.println("강의 선택까지 했으니 이제 미리담기로");
//			}
////			int row = e.getFirstIndex(); //용인이야 서울이야 물어보기
////			showNext(row);
//		}
//	}
	public Vector<MLecture> getSelectedList() {
		int[] selectedIndies = getTable().getSelectedRows();
		Vector<MLecture> selectedList = new Vector<MLecture>();
		for(int index : selectedIndies) {
			selectedList.add(mLectureList.get(index));
		}
		return selectedList;
	}
	
	public void addSelectedList(Vector<MLecture> selectedList) {
		// TODO Auto-generated method stub
		for(MLecture mLecture : selectedList) {
			mLectureList.add(mLecture);
			String[] row = new String[5];
	        row[0] = String.valueOf(mLecture.getId());
	        row[1] = mLecture.getName();
	        row[2] = mLecture.getProfessor();
	        row[3] = String.valueOf(mLecture.getCredit());
	        row[4] = mLecture.getTime();
	        getTableModel().addRow(row);
		}
		getTable().updateUI();
	}

}