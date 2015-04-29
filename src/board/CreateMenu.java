package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;




import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CreateMenu extends JFrame{
	

	public static JLabel labelBase;
	public static JComboBox<String> optionBase;

	public static JLabel labelScale;
	public static JSlider optionScale;

	public static JLabel labelWidth;
	public static JTextField optionWidth;

	public static JLabel labelHeight;
	public static JTextField optionHeight;

	public static JLabel labelButton;
	public static JButton testButton;

	public static JLabel labelKnobType;
	public static JComboBox<String> optionKnobType;

	public static JLabel labelKnobNumber;
	public static JComboBox<Integer> optionKnobNumber;

	public static JLabel labelKnobRows;
	public static JComboBox<Integer> optionKnobRows;

	public CreateMenu(String string) {
		setTitle(string);
	}
	
	
    static int x;
    static int typewidth;
    static int typewidthmin;
    static int typewidthmax;
	
	public static void sdfds() {
		labelScale = new JLabel();
		labelScale.setText("Scale");
		//optionScale = new JSlider(JSlider.HORIZONTAL,typewidthmin,typewidthmax,typewidth);
		optionScale = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
		//optionScale.setMinimum(typewidthmin);
		//optionScale.setMaximum(typewidthmax);
        optionScale.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                }
        });
		
		
		
		labelBase = new JLabel();
		labelBase.setText("Base Color/type");
        optionBase = new JComboBox<String>();
		for(String item:Pedal.basesText) {
			if (item != null){
                optionBase.addItem(item);
			}
		}

        optionBase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionBase.getSelectedIndex());
		        //optionScale.enable();
		        /*

                    x = optionBase.getSelectedIndex();
                    typewidth = Pedal.widths[x];
                    typewidthmin = (int) (((double)typewidth)/2.0);
                    typewidthmax = typewidth*2;
                    
                    System.out.println("" + typewidth + " " + typewidthmin + " " + typewidthmax);
                    optionScale.setMinimum(typewidthmin);
                    optionScale.setMaximum(typewidthmax);
                */

                }
        });
		
		labelWidth = new JLabel();
		labelWidth.setText("Scale");
		optionWidth = new JTextField();
        optionWidth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		        System.out.println(optionWidth.getText());
                }
        });
		
        
		labelHeight = new JLabel();
		labelHeight.setText("Scale #2");
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
        optionKnobType = new JComboBox<String>();

		for(String type:Pedal.knobTypes) {
			if (type != "0" && type != null) {
                optionKnobType.addItem(type);
			}
		}
        //optionKnobType.setSelectedIndex(3);

		labelKnobNumber = new JLabel();
		labelKnobNumber.setText("Knob amount");
        optionKnobNumber = new JComboBox<Integer>();
        optionKnobNumber.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((int)optionKnobNumber.getSelectedItem() == 2 && (int)optionKnobRows.getSelectedItem() == 1){
                            System.out.println("knob number is 2");
                           // setKnob_0_x(.35);
                            //setKnob_1_x(.65);
                    }
                	if ((int)optionKnobNumber.getSelectedItem()==2){
                		optionKnobRows.setEnabled(true);
                	}
                }
        });

		for(int i = 0; i<=5;i++){
                optionKnobNumber.addItem(i);
		}

		labelKnobRows = new JLabel();
		labelKnobRows.setText("Knob rows");
        optionKnobRows = new JComboBox<Integer>();
        optionKnobRows.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
        });

        optionKnobRows.addItem(1);
        optionKnobRows.addItem(2);

        
        
        MainClass2.cm.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints d = new GridBagConstraints();
        GridBagConstraints e = new GridBagConstraints();
        b.gridx = 1;
        b.gridwidth = 1;
        b.fill = GridBagConstraints.HORIZONTAL;
        b.weightx = 0.5;
        b.insets = new Insets(3,0,3,0);

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
        e.insets = new Insets(5,5,5,5);
        //e.fill = GridBagConstraints.VERTICAL;

        MainClass2.cm.add(labelBase, c);
        MainClass2.cm.add(optionBase, d);

        //MainClass2.cm.add(labelWidth, c);
        //MainClass2.cm.add(optionWidth, d);

        MainClass2.cm.add(labelScale, c);
        MainClass2.cm.add(optionScale, b);
        //optionScale.setEnabled(false);

        //MainClass2.cm.add(labelHeight, c);
        //MainClass2.cm.add(optionHeight, d);

        MainClass2.cm.add(labelKnobType, c);
        MainClass2.cm.add(optionKnobType, d);

        MainClass2.cm.add(labelKnobNumber, c);
        MainClass2.cm.add(optionKnobNumber, d);

        MainClass2.cm.add(labelKnobRows, c);
        MainClass2.cm.add(optionKnobRows, d);
        optionKnobRows.setEnabled(false);

        MainClass2.cm.add(testButton, e);
	
	}
}