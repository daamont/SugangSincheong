package main;

import view.VMainFrame;

public class Main {
	private VMainFrame vMainFrame;
	
	public Main() {
		this.vMainFrame = new VMainFrame();
		this.vMainFrame.setVisible(true);
	}
	public void initialize() {
		this.vMainFrame.initailize();
	}
	public void run() {
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.run();
	}

}
