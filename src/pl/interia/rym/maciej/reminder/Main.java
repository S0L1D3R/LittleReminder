package pl.interia.rym.maciej.reminder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.PaintEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import pl.interia.rym.maciej.reminder.Configuration.Config;

public class Main {
	
	public Listeners listeners = new Listeners();
	
	private Window mainWindow;
	private Window readNoteWindow;
	
	public static Main reminder;
	
	public static void main(String[] args) {
		//Config.loadConfigs();Zmieni³em to
		reminder = new Main();
		reminder.listeners = new Listeners();
		
		reminder.setMainWindow(reminder, reminder.createMainWindow(reminder, "MyReminder"));	
		reminder.setNoteReadWindow(reminder, reminder.createNoteReadWindow(reminder, "Little Reminder", "Notes"));
	}
	
	public Window createMainWindow(Main m, String name) {
		Window window = new Window("Little Reminder");
		window.setSize(600, 600);
		window.setLocation(200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setResizable(false);
		
		
		//Labels		
		JLabel lTypeHere = new JLabel("Wpisz nastepna notatke:");
		Font fType = new Font(lTypeHere.getFont().getName(), lTypeHere.getFont().getStyle(), 17); 
		lTypeHere.setFont(fType);
		lTypeHere.setBounds(10, 10, 400, 30);
		window.add(lTypeHere);
		
		
		JLabel lDescr = new JLabel("Twoje ostatnie notatki:");
		Font fDescr = new Font(lDescr.getFont().getName(), lDescr.getFont().getStyle(), 17);
		lDescr.setFont(fDescr);
		lDescr.setBounds(10, 160, 400, 30);
		window.add(lDescr);
		
		
		
		//TextAreas
		JTextArea taTemp = new JTextArea("Text Area!!");
		taTemp.setBounds(10, 50, 400, 110);
		taTemp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		window.add(taTemp);
		
		
		
		
		//Lists
		DefaultListModel<String> p = new DefaultListModel<>();
		p.addElement("Jakis tam tekst.");
		p.addElement("Inny tekst!");
		p.addElement("Calkowicie odmienny tekst!");
		p.addElement("Jeszcze cos innego..");
		JList<String> lRecent = new JList<>(p);
		lRecent.setFont(new Font(lRecent.getFont().getName(), lRecent.getFont().getStyle(), 30));
		lRecent.setBounds(10, 190, 400, 370);
		lRecent.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		window.add(lRecent);
		
		

		
		
		//Buttons
		JButton bAddNote = new JButton("Dodaj punkt");
		bAddNote.setBounds(420, 50, 160, 40);
		bAddNote.setName("Add");
		bAddNote.addActionListener(listeners);
		window.add(bAddNote);
		
		JButton bShow = new JButton("Poka¿ listê");
		bShow.setBounds(420, 190, 160, 40);
		bShow.setName("Show");
		bShow.addActionListener(listeners);
		window.add(bShow);
		
		JButton bClose = new JButton("Zamknij");
		bClose.setBounds(420, 520, 160, 40);
		bClose.setName("Close");
		bClose.addActionListener(listeners);
		window.add(bClose);
		
		//window.setAlwaysOnTop(true);
		window.setVisible(true);
		return window;
	}
	
	public Window createNoteReadWindow(Main m, String name, String nameAddon) {
		Window window = new Window("Little Reminder", "Notes");
		window.setBounds(300, 200, 1000, 700);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLayout(null);
		window.addWindowListener(new WindowListener() {

			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				reminder.readNoteWindow = null;
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JLabel descr = new JLabel("Twoje notatki/lista rzeczy do zrobienia:");
		descr.setBounds(300, 5, 800, 30);
		descr.setFont(new Font(descr.getFont().getName(), 4, 20));
		window.add(descr);
		
		
		JList<String> notes = new JList<String>();
		notes.setBounds(5, 40, 970, 610);
		notes.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		window.add(notes);
		
		window.setVisible(true);
		return window;
	}
	
	public void setMainWindow(Main m, Window window) {
		m.mainWindow = window;
	}
	
	public void setNoteReadWindow(Main m, Window window) {
		m.readNoteWindow = window;
	}
	
	public Window getMainWindow() {
		return mainWindow;
	}
	
	public Window getNoteReadWindow() {
		return readNoteWindow;
	}

}