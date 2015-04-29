package board;

public class Pedal_TC extends Pedal {

	public Pedal_TC(){
		super("TC");
		setBase("TC");
		setPedalID(7);
		setWidth(64+5+5);
        setHeight(120);
        setInJack_0_x(0.965);
        setOutJack_0_x(0.035);
        
        setInJack_0_y(0.51);
        setOutJack_0_y(0.51);
       
        setKnobCount(4);
        setKnobType("5");
        
        setKnob_0_x(1/3.0-0.05);
        setKnob_1_x(2/3.0+0.05);
        setKnob_2_x(1/3.0-0.05);
        setKnob_3_x(2/3.0+0.05);

        setKnob_0_y(0.15);
        setKnob_1_y(0.15);
        setKnob_2_y(0.38);
        setKnob_3_y(0.38);
        

        // setInPos();
        // setOutPos();
        
	}
}
