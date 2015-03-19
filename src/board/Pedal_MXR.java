package board;

import java.awt.Point;

public class Pedal_MXR extends Pedal {
	

	public Pedal_MXR(){
		super("MXR");
		setBase("MXR_orange");
		setPedalID(1);
		setWidth(70);
        setHeight(111);
        
        setKnobType("4");
        Point ip = new Point(5, 5);
        Point op = new Point(1, 1);
        createInPoint(ip);
        createOutPoint(op);
        

        // setInPos();
        // setOutPos();
        
	}

}

