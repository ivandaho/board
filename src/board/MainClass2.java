package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class MainClass2 extends JFrame{

	public static boolean oimagedebug = false;
	public static boolean custom = false;
	
	public static int imagescale = 2;
	//public static JFrame frame;
	//public static JPanel album;

	public static JFrame m;
	public static JPanel surface;
	public static JPanel surface_menu;
	public static JTable surface_table;

	public static JFrame cm;


    public static Point indyP;
    public static Image indyImg = Toolkit.getDefaultToolkit().createImage("images/indy_normal.png");
    public static Image indySH = Toolkit.getDefaultToolkit().createImage("images/indy_red.png");
    
    public static Point cableStart;
    public static Point cableEnd;
    public static Point newP;

    
	public static void main(String[] args) {
		
		///////////////////////////////////////////////////
		int boardl = 960;
		int boardw = 720;
		m = new MainBoard("MainBoard"); //MainBoard();
		m.setSize(boardl, boardw);
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		surface = new Surface();// or new JPanel
		surface_menu = new Surface();// or new JPanel
		surface_menu.setBackground(Color.LIGHT_GRAY);
		//surface_menu.setBorder(new LineBorder(Color.black, 1));
String boardName = "PT_Mini";
		//surface.setBackground(Color.darkGray);
		surface.setLayout(null);
		
		JButton jbnAddP_MXR = new JButton("add ehx bmp");
		jbnAddP_MXR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewPedal(5);
			}
		});

		JButton jbnAddP_MXR_BEF = new JButton("add MXR BEF");
		jbnAddP_MXR_BEF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewPedal(3);
			}
		});

		JButton jbnAddP_KORG_Pitchblack = new JButton("add Korg Pitchblack");
		jbnAddP_KORG_Pitchblack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewPedal(4);
			}
		});
		JButton jbnAddP_SANSAMP_BDDI = new JButton("add SansAmp BDDI");
		jbnAddP_SANSAMP_BDDI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewPedal(9);
			}
		});
		
		JButton jbnRemoveP = new JButton("remove last pedal");
		jbnRemoveP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				removePedal();
			}
		});

		JButton jbnTest = new JButton("test");
		jbnTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				testButtonFunc();
			}

		});

		JButton jbnTest2 = new JButton("test");
		jbnTest2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				testButton2Func();
			}

		});

		JButton jbnSpawn = new JButton("spawn chooser");
		jbnSpawn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				spawnBtnFunc();
			}

		});
		JButton jbnTest3 = new JButton("tb3");
		jbnTest3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				tbf4();
			}

		});
		

		cm = new CreateMenu("Spawn Custom Pedal");
		cm.setSize(300, 200);
		cm.setVisible(false);
		cm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//cm.sdfds();
		
		//cm.addWindowListener(

		surface_menu.add(jbnAddP_MXR, BorderLayout.CENTER);
		surface_menu.add(jbnAddP_MXR_BEF, BorderLayout.CENTER);
		surface_menu.add(jbnAddP_KORG_Pitchblack, BorderLayout.CENTER);
		surface_menu.add(jbnAddP_SANSAMP_BDDI, BorderLayout.CENTER);
		surface_menu.add(jbnRemoveP, BorderLayout.WEST);
		surface_menu.add(jbnTest, BorderLayout.WEST);
		surface_menu.add(jbnTest2, BorderLayout.WEST);
		surface_menu.add(jbnSpawn, BorderLayout.WEST);
		//surface_menu.add(jbnTest3, BorderLayout.WEST);

		m.add(surface, BorderLayout.CENTER);
		m.add(surface_menu, BorderLayout.SOUTH);

		/*Is good create a Thread to manipulate Forms and Files. In this particular
         * case an <b>invokeLater</b> is needed becaouse all Forms graphics operations
         * needs to be elaborated after pending events are processed
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                loadPedals();
                addIndicator();
                setBoard();
                Pedal.popBases();
                Pedal.popBasesText();
                Pedal.popKnobTypes();
                CreateMenu.sdfds();
                //attachCable();
            }

        });
        //////////////////////// pedal code //////////////////////
		Pedal pedalcreate;
		pedalcreate = getPedalData();
		//displayStuff(pedalcreate);
        surface.repaint();

        ////////////////////// end pedal code ////////////////////
	}
    //////////////////////// pedal code //////////////////////
	public static Pedal getPedalData(){
		return null;
	}
	
	public static void displayStuff(Pedal pedalcreate){
		System.out.println(pedalcreate);
		System.out.println("pedal width: " + pedalcreate.getWidth());
		System.out.println("pedal height: " + pedalcreate.getHeight());
		System.out.println("in coordinates: " + pedalcreate.getInJack_0_x()
				+ ", " + pedalcreate.getInJack_0_y());
		System.out.println("out coordinates: " + pedalcreate.getOutJack_0_x()
				+ ", " + pedalcreate.getOutJack_0_y());

	}
    ////////////////////// end pedal code ////////////////////
	
    public static void loadPedals() {
     //Generate names of files
        surface.removeAll();
        for (int i = 3; i <= 2; i++) {
        	//Pedal.pedalID = i;
            String fileName = i + ".png"; //String.valueOf(i)
            addPedals(fileName);
        }
        surface.repaint();
    }

    public static void addPedals(String fileName) {
        //Get resources from Directory or Jar file
        Image img = Toolkit.getDefaultToolkit().createImage("images/"+fileName);
        
        //Creates a draggableImageComponent and adds loaded image
        Pedal spawn = null ;
        if (spawn.pedalID == 1) {
            spawn = new Pedal_MXR();
            Pedal.pedalList.add(spawn);
        }
        else if (spawn.pedalID == 2) {
            spawn = new Pedal_BOSS();
            Pedal.pedalList.add(spawn);
        }
        else if (spawn.pedalID == 3) {
        	spawn = new Pedal_MXR_BEF();
        	Pedal.pedalList.add(spawn);
        }
        else if (spawn.pedalID == 4) {
        	spawn = new Pedal_MXR();
        	Pedal.pedalList.add(spawn);
        }
        else if (spawn.pedalID == 5) {
        	spawn = new Pedal_MXR();
        	Pedal.pedalList.add(spawn);
        }
        surface.add(spawn, 0);//Adds this component to main container
        spawn.setImage(img);//Sets image
        spawn.setAutoSize(false);//The component get ratio w/h of source image
        spawn.setOverbearing(true);//On click ,this panel gains lowest z-buffer
        //spawn.setBorder(new LineBorder(Color.black, 5));

        //A small randomization of object position
        int delta = surface.getWidth() / 4;
        int cx = surface.getWidth() / 2;
        int cy = surface.getHeight() / 2;
        int ix = (spawn.getWidth()*imagescale);
        int iy = (spawn.getHeight()*imagescale);

        
        spawn.setSize(ix, iy); // this is needed for picture to appear. 
                               // setWidth and setHeight does not replace this
        spawn.setWidth(ix);
        spawn.setHeight(iy);
        spawn.setLocation(cx + getRandom(delta / 2) - spawn.getWidth() / 2, cy + getRandom(delta / 2) - spawn.getHeight() / 2);

        surface.repaint();
    }
	////////////////////////////////////////////////////////////////

    public static void addNewCustomPedal(int t) {
    	custom = true;
    	addNewPedal(t);
    }
    public static void addNewPedal(int t) {

        Pedal spawn = null ;
    	//spawn.pedalID = t; // t is type.
    	if (cm.isVisible()){ //TODO: streamline this. shouldnt be needed.
    		custom = true;
    	}
    	if (custom == true){
    		System.out.println(custom);
    	}
    	else
    		System.out.println("NOT TRUE. FALSE.");
    	// drop down menu -> base shape

    	if (t == 1) {
            spawn = new Pedal_MXR();
            Pedal.pedalList.add(spawn);
        }
        else if (t == 3) {
        	spawn = new Pedal_MXR_BEF();
        	Pedal.pedalList.add(spawn);
        }
        else if (t == 4) {
        	spawn = new Pedal_KORG_Pitchblack();
        	Pedal.pedalList.add(spawn);
        }
        else if (t == 5) {
        	spawn = new Pedal_EHX_BigMuff();
        	Pedal.pedalList.add(spawn);
        }
        else if (t == 9) {
        	spawn = new Pedal_SANSAMP_BDDI();
        	Pedal.pedalList.add(spawn);
        }
        else if (t == 99) {
        	spawn = new Pedal_Custom();
        	System.out.println("CUSTOM PEDAL WOO");
        	Pedal.pedalList.add(spawn);
        }
		surface.add(spawn, 0);

    	int elements = 1 + spawn.getKnobCount() + spawn.getFsCount() + spawn.getInJackCount() + spawn.getOutJackCount();
        BufferedImage[] input = new BufferedImage[elements+1]; 	// create array for the layers of pngs. 
        														// elements is number of total components of a pedal.

    	//////////////////////////////////////////////////////////////
        try {
            File f = new File( "images/0_" + spawn.getColor() + ".png" );			// load base first
			input[0] = ImageIO.read( f );					// set bottom layer to base
		} 
        catch (IOException e) {
        	e.printStackTrace();
        }

        for ( int i = 1; i <= spawn.getKnobCount(); i++ ) {			// loop to get knob images
            try {
                File f2 = new File( "images/knobs/knob_" + spawn.getKnobType() + ".png" );
                input[i] = ImageIO.read( f2 );
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
        }

        int eleCount = spawn.getKnobCount();
        int eleCountNext = spawn.getFsCount();

        for ( int i = eleCount + 1; i < eleCount + eleCountNext + 1; i++ ) { // loop to get fs images
            try {
                File f2 = new File( "images/fs/fs_" + spawn.getFsType() + ".png" );
                input[i] = ImageIO.read( f2 );
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
        }

        System.out.println("starting loop to get injacks");

        eleCount = eleCount + eleCountNext;

        eleCountNext = spawn.getInJackCount();

        for ( int i = eleCount + 1; i < eleCount + eleCountNext + 1; i++ ) { // loop to get injack images
            try {
                File f2 = new File( "images/jacks/" + Pedal.getInJackDir(Pedal.pedalList.size()-1, i - eleCount) + "_" + spawn.getInJackType() + ".png" );
                input[i] = ImageIO.read( f2 );
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
        }

        System.out.println("starting loop to get outjacks");

        eleCount = eleCount + eleCountNext;
        eleCountNext = spawn.getOutJackCount();

        for ( int i = eleCount + 1; i < eleCount + eleCountNext + 1; i++ ) { // loop to get injack images
            try {
                File f2 = new File( "images/jacks/" + Pedal.getOutJackDir(Pedal.pedalList.size()-1, i - eleCount) + "_" + spawn.getOutJackType() + ".png" );
                input[i] = ImageIO.read( f2 );
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
        }

        // starting to draw image, after element images have been stored in an array
        BufferedImage output = new BufferedImage( 
                input[0].getWidth(), 
                input[0].getHeight(), 
                BufferedImage.TYPE_INT_ARGB );

        Graphics g = output.getGraphics();
        g.drawImage((input[0]), 0, 0, null);
        
        int fsRangeFirst = spawn.getKnobCount() + 1;
        int fsRangeLast = spawn.getKnobCount() + spawn.getFsCount();
        
        int inJackRangeFirst = fsRangeLast + 1;
        int inJackRangeLast = fsRangeLast + spawn.getInJackCount();

        int outJackRangeFirst = inJackRangeLast + 1;
        int outJackRangeLast = inJackRangeLast + spawn.getOutJackCount();

        for ( int i = 1; i < input.length; i++ ) {			// draws the rest of the elements
        	if (i <= (spawn.getKnobCount())){			// checks if element is a knob
                System.out.println("knob printing image, i is: " + i);
                double someval_x = Pedal.getKnob_x(Pedal.pedalList.size()-1, i);	// get knob i positions for latest pedal
                double someval_y = Pedal.getKnob_y(Pedal.pedalList.size()-1, i);	// get knob i positions for latest pedal
                double centerize_x = input[i].getWidth()/2;
                double centerize_y = input[i].getHeight()/2;
                g.drawImage( input[i],
                             (int)(input[0].getWidth()*someval_x - centerize_x),			// this one is the pos
                             (int)(input[0].getHeight()*someval_y - centerize_y), null );	// 
        	}
        	int fsNumber;
            if (i >= fsRangeFirst && i <= fsRangeLast){
                System.out.println("fs printing image, i is: " + i);
                fsNumber = i-spawn.getKnobCount();
                System.out.println("getting fs number " + fsNumber);
                double someval_x = Pedal.getFs_x(Pedal.pedalList.size()-1, fsNumber);	// get fs positions for latest pedal
                double someval_y = Pedal.getFs_y(Pedal.pedalList.size()-1, fsNumber);	// get fs positions for latest pedal
                double centerize_x = input[i].getWidth()/2;
                double centerize_y = input[i].getHeight()/2;
                g.drawImage( input[i],
                             (int)(input[0].getWidth()*someval_x - centerize_x),			// this one is the pos
                             (int)(input[0].getHeight()*someval_y - centerize_y), null );	// 
            }
            int inJackNumber;
            if (i >= inJackRangeFirst && i <= inJackRangeLast){
                System.out.println("injack printing image, i is: " + i);
                inJackNumber = i-spawn.getKnobCount()-spawn.getFsCount();
                double someval_x = Pedal.getInJack_x(Pedal.pedalList.size()-1, inJackNumber);	
                double someval_y = Pedal.getInJack_y(Pedal.pedalList.size()-1, inJackNumber);
                double centerize_x = input[i].getWidth()/2;
                double centerize_y = input[i].getHeight()/2;
                g.drawImage( input[i],
                             (int)(input[0].getWidth()*someval_x - centerize_x),			// this one is the pos
                             (int)(input[0].getHeight()*someval_y - centerize_y), null );	// 
            }
            int outJackNumber;
            if (i >= outJackRangeFirst && i <= outJackRangeLast){
            	outJackNumber = i-spawn.getKnobCount()-spawn.getFsCount()-spawn.getInJackCount();
                double someval_x = Pedal.getOutJack_x(Pedal.pedalList.size()-1, outJackNumber);
                double someval_y = Pedal.getOutJack_y(Pedal.pedalList.size()-1, outJackNumber);
                double centerize_x = input[i].getWidth()/2;
                double centerize_y = input[i].getHeight()/2;
                g.drawImage( input[i],
                             (int)(input[0].getWidth()*someval_x - centerize_x),			// this one is the pos
                             (int)(input[0].getHeight()*someval_y - centerize_y), null );	// 
                System.out.println("outjack printing image, i is: " + i + " somevals: " + 
                                 someval_x + ", " + 
                                		 someval_y);
            }
        }
        ////////////////////////////////////////////////////////////
    	String fileName = (spawn.pedalID + ".png");
    	Image img = Toolkit.getDefaultToolkit().createImage("images/"+fileName);
    	////////////////////////////////////////////////////////////
    	    spawn.setImage(output);
    	    if(oimagedebug == true) {
                try {
                    File outf = new File ("oimage_.png");
                    ImageIO.write( output, "PNG", outf );
                }
                catch ( IOException x ) {
                    // Complain if there was any problem writing 
                    // the output file.
                    x.printStackTrace();
                }
    	    }
    	spawn.setAutoSize(false);
    	spawn.setOverbearing(true);
    	//spawn.setBorder(new LineBorder(Color.black, 1));
    	
        //A small randomization of object position
        int delta = surface.getWidth() / 4;
        int cx = surface.getWidth() / 2;
        int cy = surface.getHeight() / 2;
        int ix = (spawn.getWidth()*imagescale);
        int iy = (spawn.getHeight()*imagescale);
        
        spawn.setSize(ix, iy); // this is needed for picture to appear. 
                               // setWidth and setHeight does not replace this
        spawn.setWidth(ix);
        spawn.setHeight(iy);
        spawn.setLocation(cx + getRandom(delta / 2) - spawn.getWidth() / 2, cy + getRandom(delta / 2) - spawn.getHeight() / 2);
        //spawn.setBorder(new LineBorder(Color.black, 1));
        System.out.println(spawn + ", spawned");
        System.out.println("######################");
        checkEvents();
        
        //this doesn't work
    	spawn.setOutPoint
        			(new Point(cx + getRandom(delta / 2) - spawn.getWidth() / 2 - 34, cy + getRandom(delta / 2) - spawn.getHeight() / 2 + spawn.getHeight()/2 - 79));
    		//(new Point((int)spawn.getLocation().getX() - 34,
    				   //(int)spawn.getLocation().getY() + spawn.getHeight()/2 - 79));

    	spawn.setInPoint
        			(new Point(cx + getRandom(delta / 2) - spawn.getWidth() / 2 + spawn.getWidth(), cy + getRandom(delta / 2) - spawn.getHeight() / 2 + spawn.getHeight()/2 - 79));
    		//(new Point((int)spawn.getLocation().getX() + spawn.getWidth(),
    				   //(int)spawn.getLocation().getY() + spawn.getHeight()/2 - 79));
        surface.repaint();
    }
    
    private static void setBoard() {
    	String boardName = "PT_Mini";
        Image img_board = Toolkit.getDefaultToolkit().createImage("images/"+boardName+ ".png");
        Board_PT_Mini bgBoard = new Board_PT_Mini();
        surface.add(bgBoard);//Adds this component to main container
        bgBoard.setImage(img_board);//Sets image
        bgBoard.setAutoSize(false);//The component get ratio w/h of source image

        int cx = surface.getWidth() / 2;
        int cy = surface.getHeight() / 2;
        int ix = (bgBoard.getWidth()*imagescale);
        int iy = (bgBoard.getHeight()*imagescale);

        
        bgBoard.setSize(ix, iy); // this is needed for picture to appear. 
                               // setWidth and setHeight does not replace this
        bgBoard.setWidth(ix);
        bgBoard.setHeight(iy);
        bgBoard.setLocation(cx - bgBoard.getWidth()/2, cy - bgBoard.getHeight()/2);
        surface.repaint();
    }

    private static void addIndicator() {
        Indicator indy = new Indicator();
        surface.add(indy);//Adds this component to main container
        indy.setImage(indyImg);//Sets image
        indy.setAutoSize(false);//The component get ratio w/h of source image

        int cx = 50;
        int cy = surface.getHeight() - 50;
        int ix = (indy.getWidth());
        int iy = (indy.getHeight());

        
        indy.setSize(ix, iy); // this is needed for picture to appear. 
                               // setWidth and setHeight does not replace this
        indy.setWidth(ix);
        indy.setHeight(iy);
        indyP = new Point(cx - indy.getWidth()/2, cy - indy.getHeight()/2);
        indy.setLocation(indyP);
        surface.repaint();
    }

    public static void removePedal() {
    	if (surface.getComponentCount() > 4) {
    	surface.remove(0);
    	//surface.remove(surface.getComponentCount()-2);
        surface.repaint();
    	}
    }
    public static int getRandom(int range) {
        int r = (int) (Math.random() * range) - range;
        return r;
    }
    public static void testButtonFunc() {
    	//attachCable();
    	for (int i = 0; i < surface.getComponentCount(); i++) {
    	System.out.print(i);
    	System.out.print("   " + surface.getComponent(i));
    	System.out.println();
    	}
        //detectProximity();
    	/*for (int i=0; i<test.length-2; i++){

            Point parentOnScreen = surface.getComponent(i).getParent().getLocation();
            System.out.println(surface.getComponent(i) + ", loc = " + surface.getComponent(i).getLocation());
            ((Indicator) surface.getComponentAt(indyP)).somethingHappened();
    	}  */
    }
    
    public static void testButton2Func() {
        System.out.println("PedalList size: " + Pedal.pedalList.size());
    	for (int i = 0; i <Pedal.pedalList.size(); i++) {
    		System.out.println(Pedal.pedalList.get(i));
            //System.out.println(Pedal.pedalList.get(i).getX());
            System.out.println();

            System.out.print(Pedal.inPoints.get(i));
            System.out.println();
            System.out.print(Pedal.outPoints.get(i));
            System.out.println();
    	}
            System.out.println("###########################");
    }
    
/*
	public static void detectProximity() {
		if (surface.getComponentCount() > 2) {
                
            int currentX, currentY;
            int compareToX, compareToY;

            Pedal lastTouch = (Pedal) surface.getComponent(0);
            currentX = (int) lastTouch.getLocation().getX() + lastTouch.getWidth();
            currentY = (int) lastTouch.getLocation().getY();

            Pedal compare = (Pedal) surface.getComponent(1);
            compareToX = (int) compare.getLocation().getX();
            compareToY = (int) compare.getLocation().getY();
            
            
            int distanceX = currentX - compareToX;
            int distanceY = currentY - compareToY;
            int distance = (int) Math.abs(Math.sqrt(distanceX * distanceX + distanceY * distanceY));
            
            if (distance < 83 && distance > 67) {
                ((Indicator) surface.getComponentAt(indyP)).somethingHappened();

                //cableStart = compare.getLocation();
                int getLocX = (int) compare.getLocation().getX();
                int getLocY = (int) compare.getLocation().getY();
                newP = new Point (getLocX - 34, getLocY + compare.getHeight()/2 - 79); 
                surface.getComponent(surface.getComponentCount()-4).setLocation(newP);
                surface.getComponent(surface.getComponentCount()-4).setVisible(true);

                int getLocX2 = (int) lastTouch.getLocation().getX() + lastTouch.getWidth();
                int getLocY2 = (int) lastTouch.getLocation().getY();
                newP = new Point (getLocX2, getLocY2 + lastTouch.getHeight()/2 - 79); 
                surface.getComponent(surface.getComponentCount()-3).setLocation(newP);
                surface.getComponent(surface.getComponentCount()-3).setVisible(true);
            }
            else {
                ((Indicator) surface.getComponentAt(indyP)).nothingToSee();
                //System.out.println("distance between pedals is: " + distance);
                surface.getComponent(surface.getComponentCount()-4).setVisible(false);
                surface.getComponent(surface.getComponentCount()-3).setVisible(false);
            }
        }
		
		
		//currentX = surface.getlocationI/();
	}
	*/
    public static void checkEvents() {
    	if (surface.getComponentCount() >= 2 + 2) {
            attachCable();
            System.out.println("over 4 elements, attached 2 cable joints (1 set)");
    	}
    }
	
	public static void attachCable() {
        Image img_cable = Toolkit.getDefaultToolkit().createImage("images/cables/l_1.png");
        Cable c = new Cable();
        surface.add(c, surface.getComponentCount()-2);
        c.setImage(img_cable);//Sets image
        c.setAutoSize(false);//The component get ratio w/h of source image
        int ix = (c.getWidth());
        int iy = (c.getHeight());
        c.setSize(ix, iy); // this is needed for picture to appear. 
        c.setWidth(ix);
        c.setHeight(iy);
        c.setLocation(200, 200);
        System.out.println(c);
        c.setVisible(false);
        surface.repaint();

		
        Image img_cable2 = Toolkit.getDefaultToolkit().createImage("images/cables/r_1.png");
        Cable c2 = new Cable();
        surface.add(c2, surface.getComponentCount()-2);
        c2.setImage(img_cable2);//Sets image
        c2.setAutoSize(false);//The component get ratio w/h of source image
        int ix2 = (c2.getWidth());
        int iy2 = (c2.getHeight());
        c2.setSize(ix2, iy2); // this is needed for picture to appear. 
        c2.setWidth(ix2);
        c2.setHeight(iy2);
        c2.setLocation(300, 200);
        System.out.println(c2);
        c2.setVisible(false);
        surface.repaint();
		
		
		
		//Cable cable = new Cable();
		//surface.getComponent(1).add(cable);
		//surface.add(cable);
	}

	public static void spawnBtnFunc(){
		cm.setVisible(true);
	}
	
	
	public static void tbf4(){
		//System.out.println()
		//Cable.checkProximity();
	}
	public static void tbf3(){
		for(int i = 0; i<Pedal.pedalList.size(); i++){
			System.out.println(Pedal.pedalList.get(i).inP);
			System.out.println(Pedal.pedalList.get(i).outP);
		}
	}
	
}
