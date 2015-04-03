package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JTextField;

public class CreateMenu extends JFrame{

	public CreateMenu(String string) {
		setTitle(string);
	}
	
	public static void sdfds() {
        JComboBox optionBase = new JComboBox();
        optionBase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
        });
        optionBase.setSize(250, 100);
		for(String item:Pedal.bases) {
			if (item != null){
                optionBase.addItem(item);
			}
		}
        
        
        MainClass2.cm.setLayout(new FlowLayout());
        MainClass2.cm.add(optionBase);
	
	}
}
