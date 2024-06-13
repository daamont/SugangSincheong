package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Constants.Constant.ControlPanel;
import Constants.Constant.MenuPanel;
import control.CLogin;

public class VMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton buttonLogout, buttonCredit;
	private JLabel labelUserName, labelTime;
	
	private CLogin cLogin;
	private VControlSugangPanel vControlSugangPanel;
	private VMainFrame vMainFrame;

	private Timer timer;

	public VMenuPanel(CLogin cLogin) {
		this.vControlSugangPanel = new VControlSugangPanel(cLogin);
		this.cLogin = cLogin;
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		this.setBackground(Color.LIGHT_GRAY);

		ActionHandler actionHandler = new ActionHandler();

		this.labelUserName = new JLabel(this.cLogin.getUserName() + MenuPanel.EMenuTitle.eUserIntroduce.getTitle());

		this.buttonCredit = new JButton(MenuPanel.EMenuTitle.eCreditButton.getTitle());
		this.buttonCredit.addActionListener(actionHandler);
		this.buttonLogout = new JButton(MenuPanel.EMenuTitle.eLogoutButton.getTitle());
		this.buttonLogout.addActionListener(actionHandler);

		this.labelTime = new JLabel(MenuPanel.EMenuTitle.eLogoutButton.getTitle());
		labelTime.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(Box.createHorizontalStrut(15));
		this.add(this.labelUserName);
		this.add(Box.createHorizontalGlue()); // 가변적 공간
		this.add(this.labelTime);
		this.add(Box.createHorizontalGlue()); // 가변적 공간
		this.add(buttonCredit);
		this.add(this.buttonLogout);
		this.add(Box.createHorizontalStrut(15));

		startTimer();
	}

	private void startTimer() {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTime();
			}
		});
		timer.start();
	}

	private void updateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(MenuPanel.DATE_TIME_FORMAT);
		Date date = new Date();
		this.labelTime.setText(MenuPanel.EMenuTitle.eTimeLabel.getTitle() + formatter.format(date));

	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonLogout) {
				doLogout();
				}
			else if(e.getSource() == buttonCredit) {
				showCredit();
			}
		}
	}


	public void doLogout() {
		this.vMainFrame = new VMainFrame(cLogin);
		this.vMainFrame.logout();

	}

	public void showCredit() {
		int sugangCredit = vControlSugangPanel.calculateSugangCredit();
	    int maxCredit = ControlPanel.MaximumCredit;
	    int remainCredit = maxCredit - sugangCredit;
	    JOptionPane.showMessageDialog(vMainFrame, 
	    		String.format(MenuPanel.EMenuMessage.eCurrentCreditMessage.getMessage(),
	    				sugangCredit, remainCredit, maxCredit),
	    		MenuPanel.EMenuMessage.eCreditMessageTitle.getMessage(), 
	    		JOptionPane.PLAIN_MESSAGE);
	}

	public void initialize() {
		// TODO Auto-generated method stub

	}
}
