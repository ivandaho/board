package board;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NotificationWindow extends JFrame{

	public static JLabel labelHeight = new JLabel();

	public NotificationWindow(String string) {
		setTitle(string);
		this.setSize(500, this.getInsets().top+this.getInsets().bottom+300);
		labelHeight.setText("this is the text");
		add(labelHeight);
	}

}
