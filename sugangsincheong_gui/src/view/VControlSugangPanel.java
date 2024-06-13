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
import model.MLecture;

public class VControlSugangPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// components
	private JButton buttonLeft;
	private JButton buttonRight;

	// associations
	private VLectureTable vLectureTableLeft;
	private VLectureTable vMiridamgiTable;
	private VLectureTable vSingcheongTable;
	private VMenuPanel vMenuPanel;
	private VMainFrame vMainFrame;
	private CLogin cLogin;

	private MLecture mLecture;
//	private CEnrolment cEnrolment;

	private int lectureNumber;
	private int sugangCredit;

	private int lectureCredit;

	public VControlSugangPanel(CLogin cLogin) {
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
		String studentNumber = cLogin.getStudentNumber();
		System.out.println("수강신청 학번: " + studentNumber);

		updateList(studentNumber);
	}

	public void associate1(VLectureTable vLectureTableLeft, VLectureTable vLectureTableRight) {
		this.vLectureTableLeft = vLectureTableLeft;
		this.vMiridamgiTable = vLectureTableRight;
	}

	public void associate2(VLectureTable vLectureTableLeft, VLectureTable vLectureTableRight) {
		this.vMiridamgiTable = vLectureTableLeft;
		this.vSingcheongTable = vLectureTableRight;
	}

	private void updateList(String studentNumber) {
		CEnrolment cEnrolment = new CEnrolment();

		Vector<MLecture> mLectureMiridamgi = cEnrolment.getMiridamgiList(studentNumber);
		this.vMiridamgiTable.addSelectedList(mLectureMiridamgi);

		Vector<MLecture> mLectureSugang = cEnrolment.getSugangList(studentNumber);
		this.vSingcheongTable.addSelectedList(mLectureSugang);

	}

	public void moveSugangsincheong() {
//		CLogin cLogin = new CLogin();
		String studentNumber = cLogin.getStudentNumber();
		CEnrolment cEnrolment = new CEnrolment();

		Vector<MLecture> selectedList = this.vMiridamgiTable.getSelectedList();
		for (int i = 0; i < selectedList.size(); i++) {
			this.sugangCredit = calculateSugangCredit();
			System.out.println("totalCredit: "+sugangCredit);

			mLecture = selectedList.get(i);
			this.lectureNumber = mLecture.getLectureNumber();
			this.lectureCredit = mLecture.getCredit();
			sugangCredit = sugangCredit+lectureCredit;
			if (sugangCredit > 17) {
				showMessage();
			} else {
				cEnrolment.miriToSugang(studentNumber, this.lectureNumber);
				updateList(studentNumber);
			}
		}
	}

	private void backMiridamgi() {
		CEnrolment cEnrolment = new CEnrolment();
		
		String studentNumber = this.cLogin.getStudentNumber();
		Vector<MLecture> selectedList = this.vSingcheongTable.getSelectedList();

		for (int i = 0; i < selectedList.size(); i++) {
			mLecture = selectedList.get(i);
			this.lectureNumber = mLecture.getLectureNumber();
			cEnrolment.sugangToMiri(studentNumber, this.lectureNumber);
		}
		updateList(studentNumber);
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonLeft) {
				backMiridamgi();
			} else if (e.getSource() == buttonRight) {
				moveSugangsincheong();
			}
		}

	}

	private void showMessage() {
		vMenuPanel = new VMenuPanel(cLogin);
		int totalCredit = calculateSugangCredit();
		System.out.println("total credit: "+ totalCredit);
	    int remainCredit = ControlPanel.MaximumCredit - totalCredit;
		System.out.println(ControlPanel.MaximumCredit);
	    System.out.println("remain credit: "+ remainCredit);
	    JOptionPane.showMessageDialog(vMainFrame, 
				String.format(ControlPanel.EControlMessage.eOverCreditMessage.getMessage(), totalCredit, remainCredit), 
				ControlPanel.EControlMessage.eOverCreditTitle.getMessage(), 
		        JOptionPane.ERROR_MESSAGE);

	}

	public int calculateSugangCredit() {
		String studentNumber = this.cLogin.getStudentNumber();
		CEnrolment cEnrolment = new CEnrolment();
		this.sugangCredit = cEnrolment.calculateSugangCredit(studentNumber);
		System.out.println(sugangCredit);
		return this.sugangCredit;
	}

}
