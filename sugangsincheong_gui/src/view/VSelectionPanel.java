package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

//public class VSelectionPanel extends VIndexPanel {
public class VSelectionPanel extends JPanel {

	
	//attributes
	private static final long serialVersionUID = 1L;
	
	//components
	private VIndexPanel vIndexPanel;
	private VLectureTable vLectureTable;

	public VSelectionPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		this.vLectureTable = new VLectureTable();
		this.vIndexPanel = new VIndexPanel();
		
		this.add(this.vIndexPanel);	
		this.add(this.vLectureTable);
		
		this.vIndexPanel.associate(this.vLectureTable);

	}

	public void initialize() {
		this.vIndexPanel.initialize();
		this.vLectureTable.initialize();
	}

	public VLectureTable getLectureTable() {
		// TODO Auto-generated method stub
		return vLectureTable;
	}

	
}