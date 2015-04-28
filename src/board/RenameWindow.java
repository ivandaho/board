package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RenameWindow extends JFrame {

	public static JTextField enterName = new JTextField();

	public RenameWindow(String string) {
		setTitle(string);
		this.setSize(500, this.getInsets().top+this.getInsets().bottom+300);
		enterName.setText("this is the text");
        enterName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	((Pedal)(MainClass2.surface.getComponent(0))).setPedalType(enterName.getText());
                    System.out.println("pedal renamed to: " + enterName.getText());
                }
        });
		add(enterName);
	}
}
