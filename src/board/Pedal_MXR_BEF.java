package board;

public class Pedal_MXR_BEF extends Pedal_MXR{



	public Pedal_MXR_BEF() {
		setBase("MXR_purple");
        setKnobCount(5);
        setKnobType("2");
        
        // comment values are old values before changing from 60 pixels to 70 pixels to accommodate jacks

        setKnob_0_x(.35);	// .33
        setKnob_0_y(.12);

        setKnob_1_x(.65);	// .67
        setKnob_1_y(.12);
		
        setKnob_2_x(.20);	// .15
        setKnob_2_y(.32);
		
        setKnob_3_x(.5);	// .5
        setKnob_3_y(.32);
		
        setKnob_4_x(.80);	// .85
        setKnob_4_y(.32);
        
		
	}
}
