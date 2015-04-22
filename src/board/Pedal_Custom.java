package board;

import java.awt.Point;


public class Pedal_Custom extends Pedal {
	
	public Pedal_Custom(){
		super("custom");
		setBase((String) Pedal.bases[CreateMenu.optionBase.getSelectedIndex()]);
		setPedalID(CreateMenu.optionBase.getSelectedIndex());

/*
		if (CreateMenu.optionWidth.getText().equals("")){
			setWidth(70);
		} else {
		
*/
            //double width = Double.parseDouble(CreateMenu.optionWidth.getText());
            //setWidth(width);

            //setHeight((double)(getWidth()/getScale()));
            setWidth(widths[CreateMenu.optionBase.getSelectedIndex()]*CreateMenu.optionScale.getValue()/100);
            setHeight(heights[CreateMenu.optionBase.getSelectedIndex()]*CreateMenu.optionScale.getValue()/100);
        //}
/*
		if (CreateMenu.optionHeight.getText().equals("")){
			setHeight(111);
		} else {
            double height = Double.parseDouble(CreateMenu.optionHeight.getText());
            setHeight(height);
		}
*/


		Integer knobti = CreateMenu.optionKnobType.getSelectedIndex()+1;
		String knobt =  knobti.toString();
		setKnobType(knobt);

		int KnobCount = (int) CreateMenu.optionKnobNumber.getSelectedItem();
		setKnobCount(KnobCount);
		
		if ((int)CreateMenu.optionKnobNumber.getSelectedItem() == 2 &&
			(int)CreateMenu.optionKnobRows.getSelectedItem() == 1){
				
			// 2 knobs, 1 row
			setKnob_0_x(.35);
			setKnob_1_x(.65);
			setKnob_0_y(.2);
			setKnob_1_y(.2);
		}

		if ((int)CreateMenu.optionKnobRows.getSelectedItem() == 2 &&
		    (int)CreateMenu.optionKnobNumber.getSelectedItem() == 2) {
			
			// 2 knobs, 2 row
			setKnob_0_y(.12);
			setKnob_1_y(.32);
		}


		
        createInPoint(new Point(5, 5));
        createOutPoint(new Point(1, 1));
	}

}
