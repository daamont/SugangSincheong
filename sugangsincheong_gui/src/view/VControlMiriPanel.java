package view;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Constants.Constant.ControlPanel;
import control.CEnrolment;
import control.CLogin;
import model.DAOEnrolment;
import model.MLecture;

public class VControlMiriPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// components
	private JButton buttonLeft;
	private JButton buttonRight;

	// associations
	private VLectureTable vLectureTableLeft;
	private VLectureTable vMiridamgiTable;
	private VLectureTable vSingcheongTable;
	private VMainFrame vMainFrame;
	private MLecture mLecture;
//	private CEnrolment cEnrolment;

	private int lectureNumber;
	private CLogin cLogin;
	
	public VControlMiriPanel(CLogin cLogin) {
		this.cLogin = cLogin;
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		Dimension buttonSize = new Dimension(ControlPanel.EControlSize.eButtonWidth.getSize(),
				ControlPanel.EControlSize.eButtonHeight.getSize());
		ActionHandler actionHandler = new ActionHandler();

		this.buttonLeft = new JButton("<<");
		this.buttonLeft.setPreferredSize(buttonSize);
		this.buttonLeft.addActionListener(actionHandler);
		this.add(this.buttonLeft);

		this.buttonRight = new JButton(">>");
		this.buttonRight.setPreferredSize(buttonSize);
		this.buttonRight.addActionListener(actionHandler);
		this.add(this.buttonRight);
	}

	public void initialize() {
		// TODO Auto-generated method stub

	}

	public void associate1(VLectureTable vLectureTableLeft, VLectureTable vLectureTableRight) {
		this.vLectureTableLeft = vLectureTableLeft;
		this.vMiridamgiTable = vLectureTableRight;

	}

	public void associate2(VLectureTable vLectureTableLeft, VLectureTable vLectureTableRight) {
		this.vMiridamgiTable = vLectureTableLeft;
		this.vSingcheongTable = vLectureTableRight;

	}

	private void moveMiridamgi() {
//		CLogin cLogin = new CLogin();
		String studentNumber = cLogin.getStudentNumber();
		System.out.println(studentNumber);
		CEnrolment cEnrolment = new CEnrolment();

		Vector<MLecture> selectedList = this.vLectureTableLeft.getSelectedList();
		for (int i = 0; i < selectedList.size(); i++) {
			mLecture = selectedList.get(i);
			this.lectureNumber = mLecture.getLectureNumber();
			//다중선택 되는지 아래 if 문 넣어보기
		}

		boolean checkOverlap = cEnrolment.checkOverlap(studentNumber, this.lectureNumber);
		if (checkOverlap) {
			cEnrolment.insertMiridmagi(studentNumber, lectureNumber, 0);
		} else {
			JOptionPane.showMessageDialog(vMainFrame, 
					ControlPanel.EControlMessage.eOverlapMessage.getMessage(), 
					ControlPanel.EControlMessage.eOverlapMessageTitle.getMessage(), 
			        JOptionPane.ERROR_MESSAGE);
			}

		Vector<MLecture> mLectureMiridamgi = cEnrolment.getMiridamgiList(studentNumber);
		this.vMiridamgiTable.addSelectedList(mLectureMiridamgi);
	}

	private void backLecture() {
		CEnrolment cEnrolment = new CEnrolment();
//		CLogin cLogin = new CLogin();
		String studentNumber = cLogin.getStudentNumber();
		Vector<MLecture> selectedList = this.vMiridamgiTable.getSelectedList();
	
		for (int i = 0; i < selectedList.size(); i++) {
			mLecture = selectedList.get(i);
			this.lectureNumber = mLecture.getLectureNumber();
			System.out.println(lectureNumber);

			cEnrolment.deleteLecture(studentNumber, this.lectureNumber);
		}
		Vector<MLecture> mLectureMiridamgi = cEnrolment.getMiridamgiList(studentNumber);
		this.vMiridamgiTable.addSelectedList(mLectureMiridamgi);
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonLeft) {
				backLecture();
			} else if (e.getSource() == buttonRight) {
				moveMiridamgi();
			}
		}

	}

}
