package board;

public class Pedal_EHX_LittleBigMuff extends Pedal {

	public Pedal_EHX_LittleBigMuff(){
		super("EHX_LittleBigMuff");
		setBase("EHX_lbmp");
		setPedalID(5);
		setWidth(89+5+5);
        setHeight(115);
        
        setKnobCount(3);
        setKnobType("4");
        
        setKnob_0_x(1/4.0); // divided by knob count + 1
        setKnob_1_x(2/4.0);
        setKnob_2_x(3/4.0);
        //setKnob_0_y(.2);
        //setKnob_1_y(.2);

        setInJack_0_x(.96);
        
        setOutJack_0_x(.04);

        // setInPos();
        // setOutPos();
        
	}

}
