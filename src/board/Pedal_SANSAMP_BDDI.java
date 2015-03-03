package board;

public class Pedal_SANSAMP_BDDI extends Pedal{

	public Pedal_SANSAMP_BDDI(){
		super("SANSAMP_BDDI");
		setBase("SANSAMP_BDDI");
		setPedalID(9);
		setWidth(121);
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
        

        // setInPos();
        // setOutPos();
        
	}

}
