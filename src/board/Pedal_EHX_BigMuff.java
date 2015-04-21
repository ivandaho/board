package board;

public class Pedal_EHX_BigMuff extends Pedal {

	public Pedal_EHX_BigMuff(){
		super("EHX_BigMuff");
		setBase("EHX_bmp");
		setPedalID(5);
		setWidth(140+5+5);
        setHeight(174);
        
        setKnobCount(3);
        setKnobType("6");
        
        setInJack_0_x(.99);
        
        setOutJack_0_x(.005);

        // setInPos();
        // setOutPos();
        
	}

}
