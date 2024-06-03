package view;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.table.DefaultTableModel;

import Constants.Constant.IndexTable;
import Constants.Constant.IndexTable.EHeader;
import control.CIndex;
import model.MIndex;
import model.MLecture;

public class VIndexTable extends JScrollPane implements IIndexTable{ // 안에 자식이 table과 model이 있
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private JTable table;
	protected DefaultTableModel model;

	// associations
	private IIndexTable next;

	private Vector<MIndex> mIndexList;
	private String[] header;

	// methods
	public VIndexTable() {
		// components
		// table
		this.table = new JTable();
		this.setViewportView(this.table); // 이 함수를 써서 자식을 만듦
		
		// model
		this.model = new DefaultTableModel(null, setHeader());

		// associate
		this.table.setModel(model);

		ListSelectionHandler listSelectionHandler = new ListSelectionHandler();
		this.table.getSelectionModel().addListSelectionListener(listSelectionHandler);
		this.mIndexList = new Vector<MIndex>();
	}
	
	public String[] setHeader() {
		header = new String[] {IndexTable.EHeader.eId.getTitle(), IndexTable.EHeader.eTitle.getTitle() };
		return header;
	}
	
	public String[] getHeader() {
		return header;
	}
 
	public void setNext(IIndexTable next) {
		this.next = next;
	}
	
	public void show(String fileName) {
		// get data
		CIndex cINdex = new CIndex();
		mIndexList = cINdex.getList(fileName); // CCampus에게 전달해서 MCampus에게 전달
		this.model.setRowCount(0);

		for (MIndex mIndex : mIndexList) {
			String[] row = new String[2];
			row[0] = String.valueOf(mIndex.getId());
			row[1] = mIndex.getName();

			this.model.addRow(row);

		}
	}

	public void initialize() {

	}

	public void showNext(int rowIndex) {
		if (this.next != null) {
			String filename = this.mIndexList.get(rowIndex).getLink();
			this.next.show(filename);
			System.out.println(filename);
		}
	}

	public JTable getTable() {
		return this.table;
	}

	public DefaultTableModel getTableModel() {
		return this.model;
	}

	public class ListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					showNext(row);
				}
			}
		}

	}

}