package board;

import java.util.ArrayList;

public abstract class Pedal extends DraggableImageThing{
	private String PedalType = "default";
	public static int pedalID = 0;
    static ArrayList<Pedal> pedalList = new ArrayList<Pedal>(20);
    ArrayList<Double> knobXs = new ArrayList<Double>(20);

    private String base = "MXR_orange";
	private double w = 100; 
    private double h = 100;
    
    private double in_0_x = w;
    private double in_0_y = h/2;
    
    private double out_0_x = 0;
    private double out_0_y = h/2;

    private String knobType = "1";
    
    private int knobCount = 1;
    
    private double knob_0_x = .5;
    private double knob_0_y = .2;

    private double knob_1_x = .5;
    private double knob_1_y = .2;

    private double knob_2_x = .5;
    private double knob_2_y = .2;

    private double knob_3_x = .5;
    private double knob_3_y = .2;

    private double knob_4_x = .5;
    private double knob_4_y = .2;

    public Pedal(){
    	this.PedalType = "MXR";
    }

    public Pedal(String type){
    	this.PedalType = type;
	}
	
	public void setBase(String c) {
		base = c;
	}
	public String getColor() {
		return base;
	}

	public void setSize(double setw, double seth) {
		w = setw;
	}
	public void setWidth(double setw) {
		w = setw;
	}
	public void setHeight(double seth) {
		h = seth;
	}
	
	public void setInPos(double setx, double sety) {
		in_0_x = setx;
		in_0_y = sety;
	}
	public void setOutPos(double setx, double sety) {
		out_0_y = setx;
		out_0_y = sety;
	}
	
	public void setPedalID(int id) {
		pedalID = 1;
	}

	public int getWidth() {
		return (int) w;
	}
	public int getHeight() {
		return (int) h;
	}

	public double getIn_0_x() {
		return in_0_x;
	}
	public double getIn_0_y() {
		return in_0_y;
	}
	public double getOut_0_x() {
		return out_0_x;
	}
	public double getOut_0_y() {
		return out_0_y;
	}
	
	public void setKnobType(String t) {
		knobType = t;
	}
	public String getKnobType() {
		return knobType;
	}

	public void setKnobCount(int c) {
		knobCount = c;
	}
	public int getKnobCount() {
		return knobCount;
	}

	public static double getKnob_x(int thisPedal, int i) {
		switch (i) {
		case 1:
            return Pedal.pedalList.get(thisPedal).knob_0_x;
		case 2:
			return Pedal.pedalList.get(thisPedal).knob_1_x;
		case 3:
			return Pedal.pedalList.get(thisPedal).knob_2_x;
		case 4:
			return Pedal.pedalList.get(thisPedal).knob_3_x;
		case 5:
			return Pedal.pedalList.get(thisPedal).knob_4_x;
        default:
        	return 0;
		}
	}

	public static double getKnob_y(int thisPedal, int i) {
		switch (i) {
		case 1:
            return Pedal.pedalList.get(thisPedal).knob_0_y;
		case 2:
			return Pedal.pedalList.get(thisPedal).knob_1_y;
		case 3:
			return Pedal.pedalList.get(thisPedal).knob_2_y;
		case 4:
			return Pedal.pedalList.get(thisPedal).knob_3_y;
		case 5:
			return Pedal.pedalList.get(thisPedal).knob_4_y;
        default:
        	return 0;
		}
	}

	public double getKnob_0_x() {
		return knob_0_x;
	}
	public double getKnob_0_y() {
		return knob_0_y;
	}

	public void setKnob_0_x(double v) {
		knob_0_x = (v);
	}
	public void setKnob_0_y(double v) {
		knob_0_y = (v);
	}

	public double getKnob_1_x() {
		return knob_1_x;
	}
	public double getKnob_1_y() {
		return knob_1_y;
	}

	public void setKnob_1_x(double v) {
		knob_1_x = (v);
	}
	public void setKnob_1_y(double v) {
		knob_1_y = (v);
	}

	public double getKnob_2_x() {
		return knob_2_x;
	}
	public double getKnob_2_y() {
		return knob_2_y;
	}

	public void setKnob_2_x(double v) {
		knob_2_x = (v);
	}
	public void setKnob_2_y(double v) {
		knob_2_y = (v);
	}
	public double getKnob_3_x() {
		return knob_3_x;
	}
	public double getKnob_3_y() {
		return knob_3_y;
	}

	public void setKnob_3_x(double v) {
		knob_3_x = (v);
	}
	public void setKnob_3_y(double v) {
		knob_3_y = (v);
	}
	public double getKnob_4_x() {
		return knob_4_x;
	}
	public double getKnob_4_y() {
		return knob_4_y;
	}

	public void setKnob_4_x(double v) {
		knob_4_x = (v);
	}
	public void setKnob_4_y(double v) {
		knob_4_y = (v);
	}

	public String toString() {
		return "pedal type is: " + PedalType;
	}
	public int getPedalID() {
		return pedalID;
	}
    // public abstract stuff


}