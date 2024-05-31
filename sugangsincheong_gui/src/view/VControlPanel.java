package view;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.MLecture;

public class VControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//components
	private JButton buttonLeft;
	private JButton buttonRight;

	//associations
	private VLectureTable vLectureTableLeft;
	private VLectureTable vLectureTableRight;

	public VControlPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		ActionHandler actionHandler = new ActionHandler();
		
		this.buttonLeft = new JButton("<<");
		this.buttonLeft.addActionListener(actionHandler);
		this.add(this.buttonLeft);
		
		this.buttonRight = new JButton(">>");
		this.buttonRight.addActionListener(actionHandler);
		this.add(this.buttonRight);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	public void associate(VLectureTable vLectureTableLeft, VLectureTable vLectureTableRight) {
		this.vLectureTableLeft = vLectureTableLeft;
		this.vLectureTableRight = vLectureTableRight;
		
	}

		private void moveLeft() {
			Vector<MLecture> selectedList = this.vLectureTableRight.getSelectedList();
			this.vLectureTableLeft.addSelectedList(selectedList);
			
		}
			
		private void moveRight() {
			Vector<MLecture> selectedList = this.vLectureTableLeft.getSelectedList();
			this.vLectureTableRight.addSelectedList(selectedList);
			
		}

	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonLeft) {
				moveLeft();
			}
			else if(e.getSource() == buttonRight) {
				moveRight();
			}
		}

	}


}
