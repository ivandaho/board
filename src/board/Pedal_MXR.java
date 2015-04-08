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

        int locX = (int) this.getLocation().getX();
        int locY = (int) this.getLocation().getY();
        createInPoint(new Point(locX, locY + this.getHeight()/2 - 79));
        createOutPoint(new Point(locX - 34, locY + this.getHeight()/2 -79));
        

        // setInPos();
        // setOutPos();
        
	}

}

