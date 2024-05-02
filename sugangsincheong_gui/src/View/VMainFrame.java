package View;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private VSugangSincheong vSugangSincheong;
	private VCampus vCampus;

	public VMainFrame() throws HeadlessException {
		this.setTitle("수강신청"); //이 코드는 변화하지 않음. 변화 가능한 코드로 짜야함
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim.width*2/3, dim.height*2/3);
		this.setLocationRelativeTo(null);

		this.vCampus = new VCampus();
		
		//components
		this.vSugangSincheong = new VSugangSincheong();
		this.add(vSugangSincheong);
		
	}

}
