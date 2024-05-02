package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Control.CCampus;

public class VSugangSincheong extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private VCampus vCampus;

	public VSugangSincheong() {
		this.vCampus = new VCampus();
		
		JScrollPane scrollPane = new JScrollPane(vCampus); // VCampus를 JScrollPane에 추가
		this.add(scrollPane);
		
	}
	
	public void initialize() {
		
	}
	public void run() {
		
	}

}
