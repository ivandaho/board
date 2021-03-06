package board;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Pedal extends DraggableImageThing{

	public Point inP = new Point((int)this.getLocation().getX(),
			(int)this.getLocation().getY() + this.getHeight()/2 - 79); 
	
	//eventually have individual locations for the cable sockets for
	//each individual pedal type
	
	public Point outP = new Point((int)this.getLocation().getX() - 34,
			(int)this.getLocation().getY() + this.getHeight()/2 - 79);
	
	public static String[] bases = new String[20];
	public static void popBases() {
	bases[0] = "MXR_Orange";
	bases[1] = "MXR_Purple";
	bases[2] = "BOSS";
	bases[3] = "MXR_Purple";
	bases[4] = "Korg_PitchBlack";
	bases[5] = "EHX_lbmp";
	bases[6] = "CryBaby";
	bases[7] = "TC";
	bases[8] = "SANSAMP_BDDI";
	bases[9] = "SANSAMP_BDDI";
	}

	public static String[] basesText = new String[20];
	public static void popBasesText() {
	basesText[0] = "MXR (orange)";
	basesText[1] = "MXR (purple)";
	basesText[2] = "BOSS";
	basesText[3] = "Square Template";
	basesText[4] = "Korg PitchBlack";
	basesText[5] = "EHX little big muff pi";
	basesText[6] = "Dunlop CryBaby";
	basesText[7] = "TC regulars (not working)";
	//basesText[8] = "TC_BIG (not working)";
	//basesText[9] = "SANSAMP_BDDI (width not set)";
	}

	public static int[] widths = new int[20];
	public static void popWidths() {
		widths[0] = 70;
		widths[1] = 70; //boss...
		widths[2] = 80; //boss
		widths[3] = 70;
		widths[4] = 68;
		widths[5] = 99; // ehx bmp
		widths[6] = 110;// crybaby
		widths[7] = 74; // tc regular
		widths[8] = 70;
		widths[9] = 131; // sansamp bddi
	}

	public static int[] heights = new int[20];
	public static void popHeights() {
		heights[0] = 111;
		heights[1] = 111;
		heights[2] = 126;
		heights[3] = 70;
		heights[4] = 120;
		heights[5] = 115; // ehx bmp
		heights[6] = 250;
		heights[7] = 120; // tc regular
		heights[8] = 70;
		heights[9] = 95; // sansamp bddi
	}

	public static String[] knobTypes = new String[20];
	public static void popKnobTypes() {
		knobTypes[0] = "phase90";
		knobTypes[1] = "MXR small";
		knobTypes[2] = "sansamp";
		knobTypes[3] = "EHX";
		knobTypes[4] = "TC (Black)";
		//for (int i = 0; i < 5; i++){
		//	knobTypes[i] = i;
		//}
	}

	private String pedalType = "default";
	public int pedalID = 0;
    static ArrayList<Pedal> pedalList = new ArrayList<Pedal>(20);
    static ArrayList<Point> inPoints = new ArrayList<Point> (50);
    static ArrayList<Point> outPoints = new ArrayList<Point> (50);

    private int x, y;
    private String base = "MXR_orange";
	private double w = 100; 
    private double h = 100;
    
    private double ratio = w/h;
    
    public double getRatio(){
    	return ratio;
    }
    public void setRatio(){
    	System.out.println("w: " + w);
    	System.out.println("h: " + h);
    	ratio = (double)w/h;
    }
    
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
    
    private double inJack_0_x = 0.985;
    private double inJack_0_y = .5;
    private String inJack_0_dir = "r";

    //private double inJack_1_x = 0.985;  not needed yet
    //private double inJack_1_y = .5;
    //private String inJack_1_dir = "r";


    
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
	/**
	 * returns the x value of a Pedal's input jack center 
	 * position.
	 * 
	 * 
	 * @param thisPedal the Pedal to get the input jack number 
	 * @param i	the input jack number, starting from 0.
	 * @return the x value of that specific input jack's center.
	 */
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

	/**
	 * Sets the x value of the Pedal's input jack center 
	 * position.
	 * 
	 * The default value is 0.985.
	 * 
	 * 
	 * @param v the multiplier to position the jack relative to the total width
	 * 			(width * v where v is a number 0-1.0)
	 */
	public void setInJack_0_x(double v) {
		inJack_0_x = v;
	}
	/**
	 * Sets the y value of the Pedal's input jack center 
	 * position.
	 * 
	 * The default value is 0.5.
	 * 
	 * 
	 * @param v the multiplier to position the jack relative to the total height
	 * 			(height * v where v is a number 0-1.0)
	 */
	public void setInJack_0_y(double v) {
		inJack_0_y = v;
	}
	
	public void createInPoint(Point p) {
		inPoints.add(p);
	}
	public void setInPoint(Point p){ // THIS IS WHERE YOU SET THE IN/OUT POINTS OF JACKS FOR THE PEDALS IN ORDER FOR CABLES TO WORK
									// reminder: for y axis, more = upwards
		if (pedalID == 2){
    		inP = (new Point((int)getLocation().getX() + getWidth(),
    				   (int)getLocation().getY() + getHeight()/2 - 105));
		} else if (pedalID == 4){
    		inP = (new Point((int)getLocation().getX() + getWidth(),
    				   (int)getLocation().getY() + getHeight()/2 - 68));
		} else if (pedalID == 6){
    		inP = (new Point((int)getLocation().getX() + getWidth() - 13,
    				   (int)getLocation().getY() + getHeight()/2 - 110));
		} else if (pedalID == 7){
    		inP = (new Point((int)getLocation().getX() + getWidth() - 3,
    				   (int)getLocation().getY() + getHeight()/2 - 77));
		}
		else if (pedalID == 9){
    		inP = (new Point((int)getLocation().getX() + getWidth(),
    				   (int)getLocation().getY() + getHeight()/2 - 98));
		} else { 
    		inP = (new Point((int)getLocation().getX() + getWidth(),
    				   (int)getLocation().getY() + getHeight()/2 - 79));
		}
	}
	public Point getInPoint(){
		return inP;
	}

	// outjack 

	private String outJackType = "1";

    private int outJackCount = 1;
    
    private double outJack_0_x = 0.015;
    private double outJack_0_y = .5;
    private String outJack_0_dir = "l";

    private double outJack_1_x = 0.055;
    private double outJack_1_y = .5;
    private String outJack_1_dir = "r";
    
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
		System.out.println("starting getOutJack_x method with i: " + i);
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).outJack_0_x;
		case 2:
			return Pedal.pedalList.get(thisPedal).outJack_1_x;
			default:
				return 0;
		}
	}
	public static double getOutJack_y(int thisPedal, int i) {
		System.out.println("starting getOutJack_y method with i: " + i);
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).outJack_0_y;
		case 2:
			return Pedal.pedalList.get(thisPedal).outJack_1_y;
			default:
				return 0;
		}
	}
	
	public static String getOutJackDir(int thisPedal, int i) {
		switch (i) {
		case 1:
			return Pedal.pedalList.get(thisPedal).outJack_0_dir;
		case 2:
			return Pedal.pedalList.get(thisPedal).outJack_1_dir;

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

	/**
	 * Sets the x value of the Pedal's output jack center 
	 * position.
	 * 
	 * The default value is 0.015.
	 * 
	 * 
	 * @param v the multiplier to position the jack relative to the total width
	 * 			(width * v where v is a number 0-1.0)
	 */
	public void setOutJack_0_x(double v) {
		outJack_0_x = v;
	}
	/**
	 * Sets the y value of the Pedal's output jack center 
	 * position.
	 * 
	 * The default value is 0.5.
	 * 
	 * 
	 * @param v the multiplier to position the jack relative to the total height
	 * 			(height * v where v is a number 0-1.0)
	 */
	public void setOutJack_0_y(double v) {
		outJack_0_y = v;
	}

	public void setOutJack_1_x(double v) {
		outJack_1_x = v;
	}
	public void setOutJack_1_y(double v) {
		outJack_1_y = v;
	}
	
	public void createOutPoint(Point p) {
		outPoints.add(p);
	}
	public void setOutPoint(Point p){
		if (pedalID == 2){
    		outP = (new Point((int)getLocation().getX() - 34,
    				   (int)getLocation().getY() + getHeight()/2 - 106));
		} else if (pedalID == 4){
    		outP = (new Point((int)getLocation().getX() - 34,
    				   (int)getLocation().getY() + getHeight()/2 - 68));
		} else if (pedalID == 6){
    		outP = (new Point((int)getLocation().getX() -34 + 15,
    				   (int)getLocation().getY() + getHeight()/2 - 110));
		} else if (pedalID == 7){
    		outP = (new Point((int)getLocation().getX() -34 + 6,
    				   (int)getLocation().getY() + getHeight()/2 - 77));
		} else if (pedalID == 9){
    		outP = (new Point((int)getLocation().getX() - 34,
    				   (int)getLocation().getY() + getHeight()/2 - 98));
		} else {
    		outP = (new Point((int)getLocation().getX() - 34,
    				   (int)getLocation().getY() + getHeight()/2 - 79));
		}
	}
	public Point getOutPoint(){
		return outP;
	}
    // constructors and other stuff
    public Pedal(){
    	this.pedalType = "MXR";
    	x = (int) MainClass.surface.getComponent(0).getLocation().getX();
    	y = (int) MainClass.surface.getComponent(0).getLocation().getY();
    }

    public Pedal(String type){
    	this.pedalType = type;
	}
	
	public void setBase(String c) {
		base = c;
	}
	public String getBase() {
		return base;
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
		pedalID = id;
	}
	public String getPedalType() {
		return pedalType;
	}
	public void setPedalType(String pt) {
		pedalType = pt;
	}

	public int getWidth() {
		return (int) w;
	}
	public int getHeight() {
		return (int) h;
	}


	public String toString() {
		return "pedal type is: " + pedalType; //+ " pedalID: " + pedalID;
	}
	public int getPedalID() {
		return pedalID;
	}
	
	
	
    // public abstract stuff



}