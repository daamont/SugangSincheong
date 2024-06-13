package main;

import view.VLoginDialog;
import view.VMainFrame;

public class Main {
	
	public Main() {
		VLoginDialog loginDialog = new VLoginDialog();
		loginDialog.setVisible(true);
		
	}
	public void initialize() {
	}
	public void run() {
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
//		main.run();
	}

}
