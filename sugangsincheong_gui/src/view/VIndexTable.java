package view;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CCampus;
import model.MCampus;

public class VIndexTable extends JScrollPane { // 안에 자식이 table과 model이 있
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private JTable table;
	private DefaultTableModel model;

	// associations
	private VIndexTable next;
	
	public Vector<MCampus> mCampusList;

	public void setNext(VIndexTable next) {
		this.next = next;
	}

	// methods
	public VIndexTable(String type) {
		// components
		// table
		this.table = new JTable();
		this.setViewportView(this.table); // 이 함수를 써서 자식을 만듦

		// model
		String[] campus_header = { "아이디", type };
		this.model = new DefaultTableModel(null, campus_header);

		// associate
		this.table.setModel(model);

	}

	public void show(String fileName) {
		// get data
		CCampus cCampus = new CCampus();
		mCampusList = cCampus.getList(fileName); // CCampus에게 전달해서 MCampus에게 전
		for (MCampus mCampus : mCampusList) {
			String[] row = new String[2];
			row[0] = String.valueOf(mCampus.getId());
			row[1] = mCampus.getName();

			this.model.addRow(row);

		}
//		if (this.next != null) {
//			this.next.show(mCampusList.get(0).getLink()); // 0번째 가져오기
//		}
	}

	public void initialize() {

	}
	
	public JTable getTable() {
		return this.table;
	}
	public DefaultTableModel getTableModel() {
		return this.model;
	}

}
