package board;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NotificationWindow extends JFrame{

	public static JTextArea labelChain = new JTextArea();

	public NotificationWindow(String string) {
		setTitle(string);
		setResizable(false);
		this.setSize(400, this.getInsets().top+this.getInsets().bottom+200);
		labelChain.setText("this is the text");
		labelChain.setWrapStyleWord(true);
		labelChain.setLineWrap(true);
		labelChain.setAlignmentX(50);
		labelChain.setCaretPosition(0);
		labelChain.setAlignmentY(50);
		labelChain.setEditable(false);
		//labelChain.setwra
		add(labelChain);
	}

}
