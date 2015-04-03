package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;




import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class CreateMenu extends JFrame{
	

	public static JComboBox optionBase;
	public static JTextField optionWidth;
	public static JTextField optionHeight;
	public static JButton testButton;
	public static JComboBox optionKnobType;

	public CreateMenu(String string) {
		setTitle(string);
	}
	
	
	
	public static void sdfds() {
        optionBase = new JComboBox();
        optionBase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionBase.getSelectedIndex());
		            System.out.println(((JComboBox) e.getSource()).getSelectedItem());

                }
        });
		for(String item:Pedal.bases) {
			if (item != null){
                optionBase.addItem(item);
			}
		}
		
		optionWidth = new JTextField();
        optionWidth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionWidth.getText());
                }
        });
		
        
		optionHeight = new JTextField();
        optionHeight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionHeight.getText());
                }
        });
		
        
		testButton = new JButton();
        testButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	MainClass2.addNewPedal(99);
                }
        });
        
        optionKnobType = new JComboBox();

		for(String item:Pedal.bases) {
			if (item != null){
                optionBase.addItem(item);
			}
		}
		for(int type:Pedal.knobTypes) {
			if (type != 0) {
                optionKnobType.addItem(type);
			}
		}
        MainClass2.cm.setLayout(new GridLayout(0, 1));
        MainClass2.cm.add(optionBase);
        MainClass2.cm.add(optionWidth);
        MainClass2.cm.add(optionHeight);
        MainClass2.cm.add(testButton);
        MainClass2.cm.add(optionKnobType);

	
	}
	
}
