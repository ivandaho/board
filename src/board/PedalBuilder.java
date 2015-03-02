package board;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PedalBuilder {
	
	public static void main(String[] args) {
		JFrame j = new JFrame("test builder");
		j.setSize(800, 600);
		j.setVisible(true);
		j.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
