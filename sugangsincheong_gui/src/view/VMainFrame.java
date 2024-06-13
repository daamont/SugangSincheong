package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Constants.Constant.MainFrame;
import control.CLogin;

public class VMainFrame extends JFrame {
	private static final long serialVersionUID = MainFrame.VERSION_NUM;

	private VSugangSincheong vSugangSincheong;
	private VMenuPanel vMenuPanel;

	public VMainFrame(CLogin cLogin) throws HeadlessException {
		this.setTitle(MainFrame.TITLE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim.width * 2 / 3, dim.height * 2 / 3);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		// components
		this.vMenuPanel = new VMenuPanel(cLogin);
		container.add(vMenuPanel);

		this.vSugangSincheong = new VSugangSincheong(cLogin);
		container.add(vSugangSincheong);
	}

	public void initailize() {
		this.vSugangSincheong.initialize();
		this.vMenuPanel.initialize();
	}

	public void logout() {
		System.exit(0);
	}

	public void login() {
		this.setVisible(true);
		
	}

}
