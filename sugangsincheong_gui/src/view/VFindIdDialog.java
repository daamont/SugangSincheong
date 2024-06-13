package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class VFindIdDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JPanel findNamePanel, findEmailPanel, contentPane;
	private JLabel labelName, labelEmail, labelInfo, labelIdInfo;
	private JTextField textName, textEmail;
	private JButton buttonFind;
	
	private CStudent cStudent;

	public VFindIdDialog() {
		cStudent = new CStudent();
		
		this.setTitle(FindDialog.IDTITLE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(dim.width * 1 / 5, dim.height * 1 / 4);
		this.setLocationRelativeTo(null);
		
		Dimension buttonSize = new Dimension(FindDialog.EFindnSize.eButtonWidth.getSize(),
	    		FindDialog.EFindnSize.eButtonHeight.getSize());
	    Dimension textFieldSize = new Dimension(FindDialog.EFindnSize.eTextFieldWidth.getSize(),
	    		FindDialog.EFindnSize.eTextFieldHeight.getSize());
	    
		ActionHandler actionHAndler = new ActionHandler();
		
		findNamePanel = new JPanel();
		findEmailPanel = new JPanel();
		
		labelInfo = new JLabel(FindDialog.EFindTitle.eFindInfoLabel.getTitle());
		labelInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelIdInfo = new JLabel(FindDialog.EFindTitle.eIdInfoLabel.getTitle());
		labelIdInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelName = new JLabel(FindDialog.EFindTitle.eNameLabel.getTitle());
		labelEmail = new JLabel(FindDialog.EFindTitle.eEmailLabel.getTitle());
		
		textName = new JTextField();
		textName.setPreferredSize(textFieldSize);
		textEmail = new JTextField();
		textEmail.setPreferredSize(textFieldSize);
		
		buttonFind = new JButton(FindDialog.EFindTitle.eFindIdButton.getTitle());
		buttonFind.setBackground(Color.BLUE);
		buttonFind.setPreferredSize(buttonSize);
		buttonFind.addActionListener(actionHAndler);
		buttonFind.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		findNamePanel.add(new JLabel("  "));
		findNamePanel.add(labelName);
		findNamePanel.add(textName);
		findNamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		findEmailPanel.add(labelEmail);
		findEmailPanel.add(textEmail);
		findEmailPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.contentPane = new JPanel();
	    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	    
		contentPane.add(new JLabel(" "));
		contentPane.add(labelInfo);
		contentPane.add(labelIdInfo);
		contentPane.add(new JLabel(" "));
		contentPane.add(findNamePanel);
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
				findId();
			}
			
		}
		
	}

	public void findId() {
		String inputName = textName.getText();
		String inputEmail = textEmail.getText();
		
		boolean isUserInfoCorrect = this.cStudent.findUserId(inputName, inputEmail);
		if(isUserInfoCorrect) {
		String userId = this.cStudent.getUserId();
		JOptionPane.showMessageDialog(this, 
	            String.format(FindDialog.EMenuMessage.eFindIDSuccessMessage.getMessage(), userId), 
	            FindDialog.EMenuMessage.eFindIDSuccessTitle.getMessage(), 
	            JOptionPane.PLAIN_MESSAGE);
		this.setVisible(false);
		} 
		else {
			JOptionPane.showMessageDialog(this, 
					FindDialog.EMenuMessage.eFindIDFailureMessage.getMessage(), 
					FindDialog.EMenuMessage.eFindIDFailureTitle.getMessage(), 
		            JOptionPane.ERROR_MESSAGE);
			textName.setText("");
			textEmail.setText("");
		}
	}

}
