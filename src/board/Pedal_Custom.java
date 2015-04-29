package board;

import java.awt.Point;


public class Pedal_Custom extends Pedal {
	
	public Pedal_Custom(){
		super("custom");
		setBase((String) Pedal.bases[CreateMenu.optionBase.getSelectedIndex()]);
		if(getBase()== "BOSS"){
			setFsCount(0);
			setInJack_0_y(0.4);
			setOutJack_0_y(0.4);
		}
		if(getBase() == "Korg_PitchBlack"){
			setFs_0_y(.8);
		}
		if(getBase() == "SANSAMP_BDDI"){
            setPedalID(9);
            setWidth(131);
            setHeight(95);
            
            setKnobType("3");
            setKnobCount(6);

            setKnob_0_x(.16);
            setKnob_0_y(.23);

            setKnob_1_x(.33);
            setKnob_1_y(.23);
                    
            setKnob_2_x(.5);
            setKnob_2_y(.23);
                    
            setKnob_3_x(.67);
            setKnob_3_y(.23);
                    
            setKnob_4_x(.84);
            setKnob_4_y(.23);

            setKnob_5_x(.585);
            setKnob_5_y(.43);

            setFs_0_x(.85);
            setFs_0_y(.85);
            
            setInJackType("2");
            setOutJackType("2");
            
            setOutJackCount(2);

            setInJack_0_x(.9805);
            setInJack_0_y(.4);
            
            setOutJack_0_x(.025);
            setOutJack_0_y(.4);
            
            setOutJack_1_x(.9805);
            setOutJack_1_y(.6);

            return; // and stop
		}
		System.out.println("base selected index is: " + CreateMenu.optionBase.getSelectedIndex());
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
			setKnob_0_x(1/3.0);
			setKnob_1_x(2/3.0);
			setKnob_0_y(.2);
			setKnob_1_y(.2);
		}
		if ((int)CreateMenu.optionKnobNumber.getSelectedItem() == 3 &&
			(int)CreateMenu.optionKnobRows.getSelectedItem() == 1){
				
			// 3 knobs, 1 row
			setKnob_0_x(1/4.0);
			setKnob_1_x(2/4.0);
			setKnob_2_x(3/4.0);
			setKnob_0_y(.2);
			setKnob_1_y(.2);
		}
		if ((int)CreateMenu.optionKnobNumber.getSelectedItem() == 4 &&
			(int)CreateMenu.optionKnobRows.getSelectedItem() == 1){
				
			// 4 knobs, 1 row
			setKnob_0_x(1/5.0);
			setKnob_1_x(2/5.0);
			setKnob_2_x(3/5.0);
			setKnob_3_x(4/5.0);
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
