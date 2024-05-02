package View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.CCampus;
import Model.MCampus;

public class VCampus extends JTable {
	//attributes
	private static final long serialVersionUID = 1L;
	
	//components
	private DefaultTableModel model;
	
	//methods
	public VCampus() {
		String[] campus_header = { "아이디", "캠퍼스"};
		this.model = new DefaultTableModel(null, campus_header);
		this.setModel(model);
		
		CCampus cCampus = new CCampus();
		Vector<MCampus> mCampusList = cCampus.getList();
		for(MCampus mCampus: mCampusList) {
			String[] row = new String[2];
			row[0] = String.valueOf(mCampus.getId());
			row[1] = mCampus.getName();
			
			this.model.addRow(row);
			
		}


	}

}
