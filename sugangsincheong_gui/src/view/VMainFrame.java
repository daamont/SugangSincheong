package view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Constants.Constant.MainFrame;

public class VMainFrame extends JFrame {
	private static final long serialVersionUID = MainFrame.VERSION_NUM;
	
	private VSugangSincheong vSugangSincheong;

	public VMainFrame() throws HeadlessException {
		this.setTitle(MainFrame.TITLE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim.width*2/3, dim.height*2/3);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components
		this.vSugangSincheong = new VSugangSincheong();
		this.add(vSugangSincheong);
		
	}

	public void initailize() {
		this.vSugangSincheong.initialize();
		
	}

}
