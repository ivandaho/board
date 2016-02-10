package board;

import java.awt.Image;
import java.awt.Toolkit;

public class Indicator extends UndraggableImageThing{

	private double w = 75; 
    private double h = 75;
    public Indicator(){
    }

	public int getWidth() {
		return (int) w;
	}
	public int getHeight() {
		return (int) h;
	}

	public void setWidth(double setw) {
		w = setw;
	}
	public void setHeight(double seth) {
		h = seth;
	}
	
	public void somethingHappened() {
        setImage(MainClass.indySH);//Sets image
	}

	public void nothingToSee() {
        setImage(MainClass.indyImg);//Sets image
	}
}
