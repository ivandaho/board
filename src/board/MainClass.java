package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainClass {
	
	public static JFrame frame;
	public static JPanel album;

	public static JFrame m;
	public static JPanel surface;

	public static void main(String[] args) {
		
		frame = new JFrame("Photo Album");
		frame.setVisible(true);
		frame.setSize(1000, 740);
		frame.setLayout(new BorderLayout());
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		album = new JPanel();
		album.setBackground(Color.darkGray);
		album.setLayout(null);	//!! IMPORTAN !! you have to set 
								//a free layout at least ( FREE,
								//ABSOLUTE, NULL is best)
		frame.add(album, BorderLayout.CENTER);
		
		///////////////////////////////////////////////////
		int boardl = 1000;
		int boardw = 740;
		m = new MainBoard("MainBoard"); //MainBoard();
		m.setSize(boardl, boardw);
		m.setVisible(true);
		m.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		surface = new JPanel();
		surface.setBackground(Color.darkGray);
		surface.setLayout(null);
		
		m.add(surface, BorderLayout.CENTER);

		/*Is good create a Thread to manipulate Forms and Files. In this particular
         * case an <b>invokeLater</b> is needed becaouse all Forms graphics operations
         * needs to be elaborated after pending events are processed
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                loadPhotos();
                loadPedals();
            }
        });
        //////////////////////// pedal code //////////////////////
		Pedal pedalcreate;
		pedalcreate = getPedalData();
		displayStuff(pedalcreate);
        surface.repaint();

		//System.exit(0);
        ////////////////////// end pedal code ////////////////////
	}
		
    //////////////////////// pedal code //////////////////////
	public static Pedal getPedalData(){
		Scanner in = new Scanner(System.in);
		System.out.print("enter pedal type: ");
		String pedtype = in.next();
		
		if (pedtype.equalsIgnoreCase("mxr")){
			return new Pedal_MXR();
		}
		if (pedtype.equalsIgnoreCase("boss")){
			return new Pedal_BOSS();
		}
		else return null;
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
        surface.removeAll();
        for (int i = 1; i <= 8; i++) {
            String fileName = String.valueOf(i) + ".jpg";
            addNewPedal(fileName);
        }
        surface.repaint();
    }

    public static void addNewPedal(String fileName) {
        //Get resources from Directory or Jar file
        Image img = Toolkit.getDefaultToolkit().createImage("images/"+fileName);
        
        //Creates a draggableImageComponent and adds loaded image
        DraggableImageThing pedal = new DraggableImageThing();
        surface.add(pedal);//Adds this component to main container
        pedal.setImage(img);//Sets image
        pedal.setAutoSize(true);//The component get ratio w/h of source image
        pedal.setOverbearing(true);//On click ,this panel gains lowest z-buffer
        pedal.setBorder(new LineBorder(Color.black, 1));

        //A small randomization of object size/position
        int delta = surface.getWidth() / 4;
        int randomGrow = getRandom(getRandom(delta * 2));
        int cx = surface.getWidth() / 2;
        int cy = surface.getHeight() / 2;
        pedal.setSize(delta + randomGrow, delta + randomGrow);
        pedal.setLocation(cx + getRandom(delta / 2) - pedal.getWidth() / 2, cy + getRandom(delta / 2) - pedal.getHeight() / 2);
        surface.repaint();
    }
	////////////////////////////////////////////////////////////////
	/**
     * Generate names of files
     */
    public static void loadPhotos() {
        album.removeAll();
        for (int i = 1; i <= 8; i++) {
            String fileName = String.valueOf(i) + ".jpg";
            addNewPhoto(fileName);
        }
        album.repaint();
    }

    public static void addNewPhoto(String fileName) {
        //Get resources from Directory or Jar file
        Image img = Toolkit.getDefaultToolkit().createImage("images/"+fileName);
        
        //Creates a draggableImageComponent and adds loaded image
        DraggableImageThing photo = new DraggableImageThing();
        album.add(photo);//Adds this component to main container
        photo.setImage(img);//Sets image
        photo.setAutoSize(true);//The component get ratio w/h of source image
        photo.setOverbearing(true);//On click ,this panel gains lowest z-buffer
        photo.setBorder(new LineBorder(Color.black, 1));

        //A small randomization of object size/position
        int delta = album.getWidth() / 4;
        int randomGrow = getRandom(getRandom(delta * 2));
        int cx = album.getWidth() / 2;
        int cy = album.getHeight() / 2;
        photo.setSize(delta + randomGrow, delta + randomGrow);
        photo.setLocation(cx + getRandom(delta / 2) - photo.getWidth() / 2, cy + getRandom(delta / 2) - photo.getHeight() / 2);
        album.repaint();
    }

    public static int getRandom(int range) {
        int r = (int) (Math.random() * range) - range;
        return r;
    }
}
