package board;

import java.awt.Point;


public class Pedal_Custom extends Pedal {
	
	public Pedal_Custom(){
		super("custom");
		setBase((String) CreateMenu.optionBase.getSelectedItem());
		setPedalID(CreateMenu.optionBase.getSelectedIndex());

		if (CreateMenu.optionWidth.getText().equals("")){
			setWidth(70);
		} else {
            double width = Double.parseDouble(CreateMenu.optionWidth.getText());
            setWidth(width);
        }

		if (CreateMenu.optionHeight.getText().equals("")){
			setHeight(111);
		} else {
            double height = Double.parseDouble(CreateMenu.optionHeight.getText());
            setHeight(height);
		}

		String knobt = ((CreateMenu.optionKnobType.getSelectedItem().toString()));
		setKnobType(knobt);

		
        createInPoint(new Point(5, 5));
        createOutPoint(new Point(1, 1));
	}

}
