package main;

import View.VMainFrame;

public class Main {
	private VMainFrame vMainFrame;
	
	public Main() {
		this.vMainFrame = new VMainFrame();
		this.vMainFrame.setVisible(true);
	}
	public void initialize() {
	}
	public void run() {
	}

	public static void main(String[] args) {
		Main main = new Main();
		
		main.run();
	}

}
