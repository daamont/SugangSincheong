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
import control.CCampus;
import control.CCollege;
import control.CDepartment;
//import control.CIndex;
import control.CLecture;
import model.MCampus;
import model.MCollege;
import model.MDepartment;
import model.MIndex;
import model.MLecture;

public class VIndexTable extends JScrollPane implements IIndexTable { // 안에 자식이 table과 model이 있
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private JTable table;
	protected DefaultTableModel model;

	// associations
	private IIndexTable next;

	private Vector<MCampus> mCampusList;
	private Vector<MCollege> mCollegeList;
	private Vector<MDepartment> mDepartmentList;
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
		this.mCampusList = new Vector<MCampus>();
		this.mCollegeList = new Vector<MCollege>();
		this.mDepartmentList = new Vector<MDepartment>();
	}

	public String[] setHeader() {
		header = new String[] { IndexTable.EHeader.eId.getTitle(), IndexTable.EHeader.eTitle.getTitle() };
		return header;
	}

	public String[] getHeader() {
		return header;
	}

	public void setNext(IIndexTable next) {
		this.next = next;
	}
	
	public void show(int id, String type) {
        this.model.setRowCount(0);
        switch (type) {
            case "campus":
                CCampus cCampus = new CCampus();
                mCampusList = cCampus.getList();
                for (MCampus mCampus : mCampusList) {
                    String[] row = new String[2];
                    row[0] = String.valueOf(mCampus.getCampusNumber());
                    row[1] = mCampus.getName();
                    this.model.addRow(row);
                }
                break;

            case "college":
                CCollege cCollege = new CCollege();
                this.mCollegeList = cCollege.getList(id);
                for (MCollege mCollege : mCollegeList) {
                    String[] row = new String[2];
                    row[0] = String.valueOf(mCollege.getCollegeNumber());
                    row[1] = mCollege.getName();
                    this.model.addRow(row);
                }
                break;

            case "department":
                CDepartment cDepartment = new CDepartment();
                mDepartmentList = cDepartment.getList(id);
                for (MDepartment mDepartment : mDepartmentList) {
                    String[] row = new String[2];
                    row[0] = String.valueOf(mDepartment.getDepartmentNumber());
                    row[1] = mDepartment.getName();
                    this.model.addRow(row);
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid entity type: " + type);
        }
    }

	public void showNext(int rowIndex) {
		if (!mCampusList.isEmpty()) {
			int campusNumber = this.mCampusList.get(rowIndex).getCampusNumber();
			this.next.show(campusNumber, "college");
		} else if (!mCollegeList.isEmpty()) {
			int collegeNumber = mCollegeList.get(rowIndex).getCollegeNumber();
			this.next.show(collegeNumber, "department");
		} else if (!mDepartmentList.isEmpty()) {
			int departmentNumber = mDepartmentList.get(rowIndex).getDepartmentNumber();
			this.next.show(departmentNumber, "lecture");
		}
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

	public void initialize() {

	}

	public JTable getTable() {
		return this.table;
	}

	public DefaultTableModel getTableModel() {
		return this.model;
	}

}