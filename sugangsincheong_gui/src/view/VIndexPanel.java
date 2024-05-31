package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VIndexPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private VIndexTable vCampus;
	private VIndexTable vCollege;
	private VIndexTable vDepartment;
		
	VIndexPanel() {
		
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);

		this.vCampus = new VIndexTable(new String[] {"아이디", "캠퍼스"});
		this.add(vCampus);

		this.vCollege = new VIndexTable(new String[] {"아이디","대학"});
		this.add(vCollege);

		this.vDepartment = new VIndexTable(new String[] {"아이디","학과"});
		this.add(vDepartment);
		

		// associations
		this.vCampus.setNext(vCollege);
		this.vCollege.setNext(vDepartment); // vCollege가 vDepartmnet로 변하는걸 저장
	}
	
	
	public void initialize() {

		this.vCampus.initialize();
		this.vCollege.initialize();
		this.vDepartment.initialize();

		this.vCampus.show("root"); // 자기가 자기친구한데 그리라고 해야함. 어떤 파일을 그려야할지 주어야 함
		
	}


	public void associate(VLectureTable vLectureTable) {
		this.vDepartment.setNext(vLectureTable);

	}

}