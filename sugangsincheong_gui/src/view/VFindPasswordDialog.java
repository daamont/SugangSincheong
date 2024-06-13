package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constants.Constant.FindDialog;
import control.CLogin;
import control.CStudent;

public class VFindPasswordDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JPanel findStudentNumberPanel, findEmailPanel, contentPane;
	private JLabel labelStudentNumber, labelEmail, labelInfo, labelIdInfo;
	private JTextField textStudentNumber, textEmail;
	private JButton buttonFind;
	
	private CStudent cStudent;

	public VFindPasswordDialog() {
		cStudent = new CStudent();
	    
	    setTitle(FindDialog.PWTITLE);
	    
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(dim.width * 1 / 5, dim.height * 1 / 4);
	    this.setLocationRelativeTo(null);
	    
	    Dimension buttonSize = new Dimension(FindDialog.EFindnSize.eButtonWidth.getSize(),
	    		FindDialog.EFindnSize.eButtonHeight.getSize());
	    Dimension textFieldSize = new Dimension(FindDialog.EFindnSize.eTextFieldWidth.getSize(),
	    		FindDialog.EFindnSize.eTextFieldHeight.getSize());
	    
	    ActionHandler actionHAndler = new ActionHandler();
	    
	    findStudentNumberPanel = new JPanel();
	    findEmailPanel = new JPanel();
	    
	    labelInfo = new JLabel(FindDialog.EFindTitle.ePwInfoLabel.getTitle());
	    labelInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
	    labelIdInfo = new JLabel(FindDialog.EFindTitle.eIdInfoLabel.getTitle());
	    labelIdInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
	    labelStudentNumber = new JLabel(FindDialog.EFindTitle.eStudentNumberLabel.getTitle());
	    labelEmail = new JLabel(FindDialog.EFindTitle.eEmailLabel.getTitle());
	    
	    textStudentNumber = new JTextField();
	    textStudentNumber.setPreferredSize(textFieldSize);
	    textEmail = new JTextField();
	    textEmail.setPreferredSize(textFieldSize);
	    
	    buttonFind = new JButton(FindDialog.EFindTitle.eFindPwButton.getTitle());
	    buttonFind.setPreferredSize(buttonSize);
	    buttonFind.addActionListener(actionHAndler);
	    buttonFind.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    findStudentNumberPanel.add(new JLabel("  "));
	    findStudentNumberPanel.add(labelStudentNumber);
	    findStudentNumberPanel.add(textStudentNumber);
	    findStudentNumberPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬

	    findEmailPanel.add(labelEmail);
	    findEmailPanel.add(textEmail);
	    findEmailPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    this.contentPane = new JPanel();
	    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	    
	    contentPane.add(new JLabel(" "));
	    contentPane.add(labelInfo);
	    contentPane.add(labelIdInfo);
	    contentPane.add(new JLabel(" "));
	    contentPane.add(findStudentNumberPanel);
	    contentPane.add(new JLabel(" "));
	    contentPane.add(findEmailPanel);
	    contentPane.add(new JLabel(" "));
	    contentPane.add(buttonFind);
	    contentPane.add(new JLabel(" "));
	    setContentPane(contentPane);
	    
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==buttonFind) {
				findPassword();
			}
			
		}
		
	}

	public void findPassword() {
		String inputStudentNumber = textStudentNumber.getText();
		String inputEmail = textEmail.getText();
		
		boolean isUserInfoCorrect = this.cStudent.findPassword(inputStudentNumber, inputEmail);
		if(isUserInfoCorrect) {
		String userPassword = this.cStudent.getUserPassword();
		JOptionPane.showMessageDialog(this, 
	            String.format(FindDialog.EMenuMessage.eFindPasswordSuccessMessage.getMessage(), userPassword), 
	            FindDialog.EMenuMessage.eFindPasswordSuccessTitle.getMessage(), 
	            JOptionPane.PLAIN_MESSAGE);
		this.setVisible(false);
		} 
		else {
			JOptionPane.showMessageDialog(this, 
					FindDialog.EMenuMessage.eFindpasswordFailureMessage.getMessage(), 
					FindDialog.EMenuMessage.eFindPasswordFailureTitle.getMessage(), 
		            JOptionPane.ERROR_MESSAGE);
			textStudentNumber.setText("");
			textEmail.setText("");
		}
	}

}
