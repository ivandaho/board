package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	
	public static int imagescale = 2;
	//public static JFrame frame;
	//public static JPanel album;

	public static JFrame m;
	public static JPanel surface;
	public static JPanel surface_menu;
	public static JTable surface_table;

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
		
		JButton jbnAddP_MXR = new JButton("add MXR");
		jbnAddP_MXR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewPedal(1);
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

		surface_menu.add(jbnAddP_MXR, BorderLayout.CENTER);
		surface_menu.add(jbnAddP_MXR_BEF, BorderLayout.CENTER);
		surface_menu.add(jbnAddP_KORG_Pitchblack, BorderLayout.CENTER);
		surface_menu.add(jbnAddP_SANSAMP_BDDI, BorderLayout.CENTER);
		surface_menu.add(jbnRemoveP, BorderLayout.WEST);
		//surface_menu.add(jbnTest, BorderLayout.WEST);

		m.add(surface, BorderLayout.CENTER);
		m.add(surface_menu, BorderLayout.SOUTH);

		/*Is good create a Thread to manipulate Forms and Files. In this particular
         * case an <b>invokeLater</b> is needed becaouse all Forms graphics operations
         * needs to be elaborated after pending events are processed
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                loadPedals();
                setBoard();
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
		System.out.println("in coordinates: " + pedalcreate.getIn_0_x()
				+ ", " + pedalcreate.getIn_0_y());
		System.out.println("out coordinates: " + pedalcreate.getOut_0_x()
				+ ", " + pedalcreate.getOut_0_y());

	}
    ////////////////////// end pedal code ////////////////////
	
    public static void loadPedals() {
     //Generate names of files
        surface.removeAll();
        for (int i = 2; i <= 2; i++) {
        	Pedal.pedalID = i;
            String fileName = Pedal.pedalID + ".png"; //String.valueOf(i)
            addPedals(fileName);
        }
        surface.repaint();
    }

    public static void addPedals(String fileName) {
        //Get resources from Directory or Jar file
        Image img = Toolkit.getDefaultToolkit().createImage("images/"+fileName);
        
        //Creates a draggableImageComponent and adds loaded image
        Pedal spawn = null ;
        if (Pedal.pedalID == 1) {
            spawn = new Pedal_MXR();
            Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 2) {
            spawn = new Pedal_BOSS();
            Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 3) {
        	spawn = new Pedal_MXR_BEF();
        	Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 4) {
        	spawn = new Pedal_MXR();
        	Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 5) {
        	spawn = new Pedal_MXR();
        	Pedal.pedalList.add(spawn);
        }
        surface.add(spawn);//Adds this component to main container
        spawn.setImage(img);//Sets image
        spawn.setAutoSize(false);//The component get ratio w/h of source image
        spawn.setOverbearing(true);//On click ,this panel gains lowest z-buffer
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

        surface.repaint();
    }
	////////////////////////////////////////////////////////////////

    public static void addNewPedal(int t) {

        Pedal spawn = null ;
    	Pedal.pedalID = t;

    	boolean testbuilder = true;
    	if (Pedal.pedalID == 1) {
            spawn = new Pedal_MXR();
            Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 3) {
        	spawn = new Pedal_MXR_BEF();
        	Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 4) {
        	spawn = new Pedal_KORG_Pitchblack();
        	Pedal.pedalList.add(spawn);
        }
        else if (Pedal.pedalID == 9) {
        	spawn = new Pedal_SANSAMP_BDDI();
        	Pedal.pedalList.add(spawn);
        }
		surface.add(spawn, 0);

    	int elements = 1 + spawn.getKnobCount() + spawn.getFsCount();
        BufferedImage[] input = new BufferedImage[elements+1]; 	// create array for the layers of pngs. 
        System.out.println("input length: " + input.length);
        														// total elements is base + knobCount + fsCount

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
                //System.out.println(f2);
                System.out.println("i is: " + i + " ok loop");
                input[i] = ImageIO.read( f2 );
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
            

        }
        for ( int i = spawn.getKnobCount()+1; i <= spawn.getKnobCount()+1+spawn.getFsCount(); i++ ) { // loop to get fs images
            try {
                File f2 = new File( "images/fs/fs_" + spawn.getFsType() + ".png" );
                System.out.println("i is: " + i);
                input[i] = ImageIO.read( f2 );
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
            

        }
        BufferedImage output = new BufferedImage( 
                input[0].getWidth(), 
                input[0].getHeight(), 
                BufferedImage.TYPE_INT_ARGB );

        Graphics g = output.getGraphics();
        g.drawImage((input[0]), 0, 0, null);
        for ( int i = 1; i < input.length; i++ ) {			// draws the rest of the elements
        	if (i <= (spawn.getKnobCount())){			// checks if element is a knob
        			
                	System.out.println("knob printing image, i is: " + i);
        			double someval_x = Pedal.getKnob_x(Pedal.pedalList.size()-1, i);	// get knob positions for latest pedal
        			double someval_y = Pedal.getKnob_y(Pedal.pedalList.size()-1, i);	// get knob positions for latest pedal
                    double centerize_x = input[i].getWidth()/2;
                    double centerize_y = input[i].getHeight()/2;
                    g.drawImage( input[i],
                                 (int)(input[0].getWidth()*someval_x - centerize_x),			// this one is the pos
                                 (int)(input[0].getHeight()*someval_y - centerize_y), null );	// 
        	}
        	if (i > spawn.getKnobCount()) {
                if (i <= (spawn.getKnobCount() + spawn.getFsCount())){			// checks if element is a fs
                        
                	System.out.println("fs printing image, i is: " + i);
                        double someval_x = Pedal.getFs_x(Pedal.pedalList.size()-1, i-spawn.getKnobCount());	// get knob positions for latest pedal
                        double someval_y = Pedal.getFs_y(Pedal.pedalList.size()-1, i-spawn.getKnobCount());	// get knob positions for latest pedal
                        double centerize_x = input[i].getWidth()/2;
                        double centerize_y = input[i].getHeight()/2;
                        System.out.println(someval_x);
                        System.out.println(someval_y);
                        g.drawImage( input[i],
                                     (int)(input[0].getWidth()*someval_x - centerize_x),			// this one is the pos
                                     (int)(input[0].getHeight()*someval_y - centerize_y), null );	// 
                }
        	}
        }
        ////////////////////////////////////////////////////////////
    	String fileName = (Pedal.pedalID + ".png");
    	Image img = Toolkit.getDefaultToolkit().createImage("images/"+fileName);
    	////////////////////////////////////////////////////////////
    	if (testbuilder == true){
    	    spawn.setImage(output);
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
    	else{
            spawn.setImage(img);
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
        System.out.println(spawn);
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

        System.out.println(ix + "  " + iy);
        
        bgBoard.setSize(ix, iy); // this is needed for picture to appear. 
                               // setWidth and setHeight does not replace this
        bgBoard.setWidth(ix);
        bgBoard.setHeight(iy);
        bgBoard.setLocation(cx - bgBoard.getWidth()/2, cy - bgBoard.getHeight()/2);
        System.out.println(bgBoard);
        System.out.println(surface.getComponentCount());
        surface.repaint();

            
            
    }
    public static void removePedal() {
    	if (surface.getComponentCount() > 1) {
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
        System.out.println(surface.getComponents());
        
    }
}
