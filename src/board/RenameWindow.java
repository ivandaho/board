package board;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RenameWindow extends JFrame {

	public static JTextField enterName = new JTextField();
	public static JButton confirmRename = new JButton();

	public RenameWindow(String string) {
		setTitle(string);
		this.setSize(250, this.getInsets().top+this.getInsets().bottom+70);
		Font f = new Font("Myriad Pro", Font.PLAIN, 14);
		enterName.setFont(f);
        enterName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(Pedal.pedalList.size()>0){
                        ((Pedal)(MainClass2.surface.getComponent(0))).setPedalType(enterName.getText());
                        System.out.println("pedal renamed to: " + enterName.getText());
                	}
                }
        });
        
        confirmRename.setText("Rename");
        confirmRename.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(Pedal.pedalList.size()>0){
                        ((Pedal)(MainClass2.surface.getComponent(0))).setPedalType(enterName.getText());
                        System.out.println("pedal renamed to: " + enterName.getText());
                	}
                }
        });
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl.rowWeights = new double[] {1.0, Double.MIN_VALUE};
        setLayout(gbl);
        GridBagConstraints tf = new GridBagConstraints();
        tf.gridx = 0;
        tf.gridwidth = 5;
        tf.fill = GridBagConstraints.BOTH;
        tf.insets = new Insets(3,3,3,3);
        tf.weightx = 0.8;
		add(enterName, tf);

        GridBagConstraints btn = new GridBagConstraints();
        btn.gridx = 5;
        btn.gridwidth = 1;
        btn.fill = GridBagConstraints.BOTH;
        btn.insets = new Insets(3,0,3,1);
		add(confirmRename, btn);
		
	}
}
