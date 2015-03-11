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
    
    // knob stuff
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

    private double knob_5_x = .5;
    private double knob_5_y = .2;

    private double knob_6_x = .5;
    private double knob_6_y = .2;
    
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
		case 6:
			return Pedal.pedalList.get(thisPedal).knob_5_x;
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
		case 6:
			return Pedal.pedalList.get(thisPedal).knob_5_y;
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
		knob_0_x = v;
	}
	public void setKnob_0_y(double v) {
		knob_0_y = v;
	}

	public double getKnob_1_x() {
		return knob_1_x;
	}
	public double getKnob_1_y() {
		return knob_1_y;
	}
	public void setKnob_1_x(double v) {
		knob_1_x = v;
	}
	public void setKnob_1_y(double v) {
		knob_1_y = v;
	}

	public double getKnob_2_x() {
		return knob_2_x;
	}
	public double getKnob_2_y() {
		return knob_2_y;
	}
	public void setKnob_2_x(double v) {
		knob_2_x = v;
	}
	public void setKnob_2_y(double v) {
		knob_2_y = v;
	}

	public double getKnob_3_x() {
		return knob_3_x;
	}
	public double getKnob_3_y() {
		return knob_3_y;
	}
	public void setKnob_3_x(double v) {
		knob_3_x = v;
	}
	public void setKnob_3_y(double v) {
		knob_3_y = v;
	}

	public double getKnob_4_x() {
		return knob_4_x;
	}
	public double getKnob_4_y() {
		return knob_4_y;
	}
	public void setKnob_4_x(double v) {
		knob_4_x = v;
	}
	public void setKnob_4_y(double v) {
		knob_4_y = v;
	}

	public double getKnob_5_x() {
		return knob_5_x;
	}
	public double getKnob_5_y() {
		return knob_5_y;
	}
	public void setKnob_5_x(double v) {
		knob_5_x = v;
	}
	public void setKnob_5_y(double v) {
		knob_5_y = v;
	}

    // fs stuff
    private String fsType = "2";

    private int fsCount = 1;
    
    private double fs_0_x = .5;
    private double fs_0_y = .7;
    
	public void setFsType(String t) {
		fsType = t;
	}
	public String getFsType() {
		return fsType;
	}

	public void setFsCount(int c) {
		fsCount = c;
	}
	public int getFsCount() {
		return fsCount;
	}

	public static double getFs_x(int thisPedal, int i) {
		switch (i) {
		case 1:
            return Pedal.pedalList.get(thisPedal).fs_0_x;
        default:
        	return 0;
		}
	}
	public static double getFs_y(int thisPedal, int i) {
		switch (i) {
		case 1:
            return Pedal.pedalList.get(thisPedal).fs_0_y;
        default:
        	return 0;
		}
	}

	public double getFs_0_x() {
		return fs_0_x;
	}
	public double getFs_0_y() {
		return fs_0_y;
	}

	public void setFs_0_x(double v) {
		fs_0_x = v;
	}
	public void setFs_0_y(double v) {
		fs_0_y = v;
	}

    // input jack stuff
	private String inJackType = "1";

    private int inJackCount = 1;
    
    private double inJack_0_x = 0.945;
    private double inJack_0_y = .5;
    private String inJack_0_dir = "r";
    
	public void setInJackType(String t) {
		inJackType = t;
	}
	public String getInJackType() {
		return inJackType;
	}

	public void setInJackCount(int c) {
		inJackCount = c;
	}
	public int getInJackCount() {
		return inJackCount;
	}
	
	public static double getInJack_x(int thisPedal, int i) {
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).inJack_0_x;
			default:
				return 0;
		}
	}
	public static double getInJack_y(int thisPedal, int i) {
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).inJack_0_y;
			default:
				return 0;
		}
	}

	public static String getInJackDir(int thisPedal, int i) {
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).inJack_0_dir;
			default:
				return "r";
		}
	}
	
	public double getInJack_0_x() {
		return inJack_0_x;
	}
	public double getInJack_0_y() {
		return inJack_0_y;
	}

	public void setInJack_0_x(double v) {
		inJack_0_x = v;
	}
	public void setInJack_0_y(double v) {
		inJack_0_y = v;
	}

	// outjack (incomplete)

	private String outJackType = "1";

    private int outJackCount = 1;
    
    private double outJack_0_x = 0.055;
    private double outJack_0_y = .5;
    private String outJack_0_dir = "l";
    
	public void setOutJackType(String t) {
		outJackType = t;
	}
	public String getOutJackType() {
		return outJackType;
	}

	public void setOutJackCount(int c) {
		outJackCount = c;
	}
	public int getOutJackCount() {
		return outJackCount;
	}
	
	public static double getOutJack_x(int thisPedal, int i) {
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).outJack_0_x;
			default:
				return 0;
		}
	}
	public static double getOutJack_y(int thisPedal, int i) {
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).outJack_0_y;
			default:
				return 0;
		}
	}
	
	public static String getOutJackDir(int thisPedal, int i) {
		switch (i) {
		case 1:

			return Pedal.pedalList.get(thisPedal).outJack_0_dir;
			default:
				return "r";
		}
	}
	public double getOutJack_0_x() {
		return outJack_0_x;
	}
	public double getOutJack_0_y() {
		return outJack_0_y;
	}

	public void setOutJack_0_x(double v) {
		outJack_0_x = v;
	}
	public void setOutJack_0_y(double v) {
		outJack_0_y = v;
	}
	
    // constructors and other stuff
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
	
	
	public void setPedalID(int id) {
		pedalID = 1;
	}

	public int getWidth() {
		return (int) w;
	}
	public int getHeight() {
		return (int) h;
	}


	public String toString() {
		return "pedal type is: " + PedalType;
	}
	public int getPedalID() {
		return pedalID;
	}
    // public abstract stuff



}