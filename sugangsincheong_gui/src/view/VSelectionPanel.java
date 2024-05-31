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

	private VLectureTable vMiridamgi;

	public VSelectionPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		this.vLectureTable = new VLectureTable(new String[] {"아이디", "강의명","교수명","학점","시간" });
		this.vIndexPanel = new VIndexPanel();
		
		this.add(this.vIndexPanel);	
		this.add(this.vLectureTable);
		
		this.vIndexPanel.associate(this.vLectureTable);
//		this.vLectureTable.associate(this.vMiridamgi);

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