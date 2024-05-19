package view;

import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VSugangSincheong extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//데이터를 주고받고할 자
	private VSelectionPanel vSelectionPanel;
	private VControlPanel vControlPanel1;
	private VLectureTable vMiridamgiTable;
	private VControlPanel vControlPanel2;
	private VLectureTable vSingcheongTable;

//	private VIndexTable vCampus;

	public VSugangSincheong() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS); //이거 대신 setLayout안에 넣어도 되는데 layout 이름이 없음.
		this.setLayout(layoutManager); // 자식들을 관리하는 자
		
        this.vSelectionPanel = new VSelectionPanel();
        this.add(this.vSelectionPanel); //add는 자식을 만든다는 것

        this.vControlPanel1 = new VControlPanel();
        this.add(this.vControlPanel1);

        this.vMiridamgiTable = new VLectureTable();
        this.add(vMiridamgiTable);

        this.vControlPanel2 = new VControlPanel();
        this.add(this.vControlPanel2);

        this.vSingcheongTable = new VLectureTable();
        this.add(vSingcheongTable);

}

	public void initialize() {
		this.vSelectionPanel.initialize();
		this.vControlPanel1.initialize();
		this.vMiridamgiTable.initialize();
		this.vControlPanel2.initialize();
		this.vSingcheongTable.initialize();
	}

}
