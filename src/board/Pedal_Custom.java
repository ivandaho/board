package board;

import java.awt.Point;


public class Pedal_Custom extends Pedal {
	
	public Pedal_Custom(){
		super("custom");
		setBase((String) Pedal.bases[CreateMenu.optionBase.getSelectedIndex()]);
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

		Integer knobti = CreateMenu.optionKnobType.getSelectedIndex()+1;
		String knobt =  knobti.toString();
		setKnobType(knobt);

		int KnobCount = (int) CreateMenu.optionKnobNumber.getSelectedItem();
		setKnobCount(KnobCount);


		
        createInPoint(new Point(5, 5));
        createOutPoint(new Point(1, 1));
	}

}
