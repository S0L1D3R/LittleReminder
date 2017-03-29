package pl.interia.rym.maciej.reminder;

import javax.swing.JFrame;

public class Window extends JFrame {

	Window(String nameOfApp) {
		super(nameOfApp);
	}
	public Window(String nameOfApp, String nameAddon) {
		super(nameOfApp+ " - " +nameAddon);
	}

}
