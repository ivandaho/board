package board;

import java.awt.Point;

public class Pedal_KORG_Pitchblack extends Pedal{

	public Pedal_KORG_Pitchblack(){
		super("KORG_Pitchblack");
		setBase("KORG_Pitchblack");
		setPedalID(4);
		setWidth(68);
        setHeight(120);
        
        setKnobCount(0);
        setFs_0_y(.8);
        
        createInPoint(new Point(5, 5));
        createOutPoint(new Point(1, 1));

        // setInPos();
        // setOutPos();
        
	}
}
