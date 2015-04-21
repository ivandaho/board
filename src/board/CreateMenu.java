package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;




import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTextField;

public class CreateMenu extends JFrame{
	

	public static JLabel labelBase;
	public static JComboBox optionBase;

	public static JLabel labelWidth;
	public static JTextField optionWidth;

	public static JLabel labelHeight;
	public static JTextField optionHeight;

	public static JLabel labelButton;
	public static JButton testButton;

	public static JLabel labelKnobType;
	public static JComboBox optionKnobType;

	public static JLabel labelKnobNumber;
	public static JComboBox optionKnobNumber;

	public CreateMenu(String string) {
		setTitle(string);
	}
	
	
	
	public static void sdfds() {
		labelBase = new JLabel();
		labelBase.setText("base Color/type");
        optionBase = new JComboBox();
        optionBase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionBase.getSelectedIndex());
		            System.out.println(((JComboBox) e.getSource()).getSelectedItem());

                }
        });
		for(String item:Pedal.basesText) {
			if (item != null){
                optionBase.addItem(item);
			}
		}
		
		labelWidth = new JLabel();
		labelWidth.setText("Ratio");
		optionWidth = new JTextField();
        optionWidth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionWidth.getText());
                }
        });
		
        
		labelHeight = new JLabel();
		labelHeight.setText("Ratio #2");
		optionHeight = new JTextField();
        optionHeight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionHeight.getText());
                }
        });
		
		testButton = new JButton();
		testButton.setText("Spawn custom pedal");
        testButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	MainClass2.addNewPedal(99);
                }
        });

		labelKnobType = new JLabel();
		labelKnobType.setText("Knob type");
        optionKnobType = new JComboBox();

		for(String type:Pedal.knobTypes) {
			if (type != "0" && type != null) {
                optionKnobType.addItem(type);
			}
		}
        optionKnobType.setSelectedIndex(3);

		labelKnobNumber = new JLabel();
		labelKnobNumber.setText("Knob amount");
        optionKnobNumber = new JComboBox();
        optionKnobNumber.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionKnobNumber.getSelectedItem());
                }
        });

		for(int i = 1; i<=5;i++){
                optionKnobNumber.addItem(i);
		}

        
        
        MainClass2.cm.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints d = new GridBagConstraints();
        GridBagConstraints e = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipadx = 2;

        d.gridx = 1;
        d.gridwidth = 1;
        d.fill = GridBagConstraints.HORIZONTAL;
        d.weightx = 0.5;

        e.gridx = 0;
        e.ipadx = 2;
        e.gridwidth = 1;
        e.weightx = 0.5;
        e.weighty = 1;
        e.gridwidth = 2;
        e.anchor = GridBagConstraints.PAGE_END;
        e.insets = new Insets(10,5,5,5);
        e.fill = GridBagConstraints.BOTH;

        MainClass2.cm.add(labelBase, c);
        MainClass2.cm.add(optionBase, d);

        MainClass2.cm.add(labelWidth, c);
        MainClass2.cm.add(optionWidth, d);

        MainClass2.cm.add(labelHeight, c);
        MainClass2.cm.add(optionHeight, d);

        MainClass2.cm.add(labelKnobType, c);
        MainClass2.cm.add(optionKnobType, d);

        MainClass2.cm.add(labelKnobNumber, c);
        MainClass2.cm.add(optionKnobNumber, d);

        MainClass2.cm.add(testButton, e);

	
	}
}