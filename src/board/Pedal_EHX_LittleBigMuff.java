package board;

public class Pedal_EHX_LittleBigMuff extends Pedal {

	public Pedal_EHX_LittleBigMuff(){
		super("EHX_LittleBigMuff");
		setBase("EHX_lbmp");
		setPedalID(5);
		setWidth(89+5+5);
        setHeight(115);
        
        setKnobCount(3);
        setKnobType("6");
        
        setInJack_0_x(.99);
        
        setOutJack_0_x(.005);

        // setInPos();
        // setOutPos();
        
	}

}
