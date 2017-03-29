package pl.interia.rym.maciej.reminder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Listeners implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton b = (JButton) e.getSource();
			if (b.getName() == "Close") {
				Main.reminder.getMainWindow().dispose();
				if(Main.reminder.getNoteReadWindow() != null) {
					Main.reminder.getNoteReadWindow().dispose();
				}
			}
			else if (b.getName() == "Show") {
				if(Main.reminder.getNoteReadWindow() == null) {
					Main.reminder.setNoteReadWindow(Main.reminder, Main.reminder.createNoteReadWindow(Main.reminder, "Little Reminder", "Notes"));
				}
			}
		}
	}
}