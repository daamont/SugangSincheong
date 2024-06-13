package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Constants.Constant.LoginDialog;
import control.CLogin;
import main.Main;

public class VLoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel labelId;
	private JTextField textId;
	private JLabel lablePassword;
	private JPasswordField textPassword;

	private JButton buttonOk, buttonCancel;
	private JButton buttonFindId, buttonFindPassword;

	private JPanel idPanel, passwordPanel, buttonPanel, findButtonPanel, contentPane;
	private CLogin cLogin;
	private VFindIdDialog vFindIdDialog;
	private VFindPasswordDialog vFindPasswordDialog;

	private VMainFrame vMainFrame;

	public VLoginDialog() {
		cLogin = new CLogin();
		vFindIdDialog = new VFindIdDialog();
		vFindPasswordDialog = new VFindPasswordDialog();

		setTitle(LoginDialog.TITLE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(dim.width * 2 / 9, dim.height * 1 / 5);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		Dimension buttonSize = new Dimension(LoginDialog.ELoginSize.eButtonWidth.getSize(),
				LoginDialog.ELoginSize.eButtonHeight.getSize());
		Dimension textFieldSize = new Dimension(LoginDialog.ELoginSize.eTextFieldWidth.getSize(),
				LoginDialog.ELoginSize.eTextFieldHeight.getSize());

		ActionHandler actionHandler = new ActionHandler();

		idPanel = new JPanel();
		passwordPanel = new JPanel();
		buttonPanel = new JPanel();
		findButtonPanel = new JPanel();

		labelId = new JLabel(LoginDialog.ELoginTitle.eID.getTitle());
		lablePassword = new JLabel(LoginDialog.ELoginTitle.ePassword.getTitle());

		textId = new JTextField();
		textId.setPreferredSize(textFieldSize);
		textPassword = new JPasswordField();
		textPassword.setPreferredSize(textFieldSize);

		buttonOk = new JButton(LoginDialog.ELoginTitle.eOKButton.getTitle());
		buttonOk.addActionListener(actionHandler);
		buttonOk.setPreferredSize(buttonSize);

		buttonCancel = new JButton(LoginDialog.ELoginTitle.eCANCELButton.getTitle());
		buttonCancel.addActionListener(actionHandler);
		buttonCancel.setPreferredSize(buttonSize);

		buttonFindId = new JButton(LoginDialog.ELoginTitle.eFINDIDButton.getTitle());
		buttonFindId.addActionListener(actionHandler);
		buttonFindId.setPreferredSize(buttonSize);

		buttonFindPassword = new JButton(LoginDialog.ELoginTitle.eFINDPWButton.getTitle());
		buttonFindPassword.addActionListener(actionHandler);
		buttonFindPassword.setPreferredSize(buttonSize);

		idPanel.add(new JLabel("            "));
		idPanel.add(labelId);
		idPanel.add(textId);
		idPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬

		passwordPanel.add(lablePassword);
		passwordPanel.add(textPassword);
		passwordPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬

		buttonPanel.add(buttonOk);
		buttonPanel.add(buttonCancel);
		buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬

		findButtonPanel.add(buttonFindId);
		findButtonPanel.add(buttonFindPassword);
		findButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬

		this.contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(new JLabel(" "));
		contentPane.add(idPanel);
		contentPane.add(passwordPanel);
		contentPane.add(buttonPanel);
		contentPane.add(findButtonPanel);
		setContentPane(contentPane);

		this.setVisible(true);
	}

	private void doOk() {
		String inputID = textId.getText();
		String inputPW = new String(textPassword.getPassword());

		boolean isLoginSucceed = this.cLogin.checkLogin(inputID, inputPW);

		String studentNumber = this.cLogin.getStudentNumber();
		System.out.println("학번: " + studentNumber);

		if (isLoginSucceed) {
			this.vMainFrame = new VMainFrame(cLogin);

			if (cLogin.checkDate()) {
				if (cLogin.checkTime()) {
					vMainFrame.setVisible(true);
					vMainFrame.initailize();
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(this, 
							LoginDialog.ELoginMessage.eTimeAlarmMessage.getMessage(),
							LoginDialog.ELoginMessage.eSugangsincheongAlarmTitle.getMessage(), 
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, 
						LoginDialog.ELoginMessage.eDateAlarmMessage.getMessage(),
						LoginDialog.ELoginMessage.eSugangsincheongAlarmTitle.getMessage(), 
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(this, 
					LoginDialog.ELoginMessage.eLoginFAILEDMessage.getMessage(),
					LoginDialog.ELoginMessage.eLoginFAILEDTitle.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			textId.setText("");
			textPassword.setText("");
		}
	}

	private void doCancel() {
		System.exit(0);
	}

	public void findId() {
		vFindIdDialog.setVisible(true);

	}

	public void findPassword() {
		vFindPasswordDialog.setVisible(true);

	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == buttonOk) {
				doOk();
			} else if (e.getSource() == buttonCancel) {
				doCancel();
			} else if (e.getSource() == buttonFindId) {
//				System.out.println("id find");
//				vFindIdDialog.setVisible(true);
				findId();
			} else if (e.getSource() == buttonFindPassword) {
				findPassword();
			}
		}

	}

}
