package view;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLogin;

public class VSugangSincheong extends JPanel {
	private static final long serialVersionUID = 1L;

	// 데이터를 주고받고할 자
	private VSelectionPanel vSelectionPanel;
	private VControlMiriPanel vControlPanel1;
	private VLectureTable vMiridamgiTable;
	private VControlSugangPanel vControlPanel2;
	private VLectureTable vSingcheongTable;

//	private VIndexTable vCampus;

	public VSugangSincheong(CLogin cLogin) {

		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS); // 이거 대신 setLayout안에 넣어도 되는데 layout 이름이 없음.
		this.setLayout(layoutManager); // 자식들을 관리하는 자

		this.vSelectionPanel = new VSelectionPanel();
		this.add(this.vSelectionPanel); // add는 자식을 만든다는 것

		this.vControlPanel1 = new VControlMiriPanel(cLogin);
		this.add(this.vControlPanel1);

		this.vMiridamgiTable = new VLectureTable();
		this.add(vMiridamgiTable);

		this.vControlPanel2 = new VControlSugangPanel(cLogin);
		this.add(this.vControlPanel2);

		this.vSingcheongTable = new VLectureTable();
		this.add(vSingcheongTable);

		this.vControlPanel1.associate1(vSelectionPanel.getLectureTable(), vMiridamgiTable); // 버튼이 눌려지면 데이터가 옮겨지는 일 만들
		this.vControlPanel2.associate2(vMiridamgiTable, vSingcheongTable);

	}

	public void initialize() {

		this.vSelectionPanel.initialize();
		this.vControlPanel1.initialize();
		this.vMiridamgiTable.initialize();
		this.vControlPanel2.initialize();
		this.vSingcheongTable.initialize();
	}

}