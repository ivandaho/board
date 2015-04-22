package board;

import java.awt.Point;

public class Cable extends UndraggableImageThing{

	private double w = 34; 
    private double h = 92;
    private static int pt = 60; // pixel tolerance for cable detection
    
    private int from = 1;
    private int to = 0;

    public Cable(){
    	int OldestPedal = Pedal.pedalList.size()-1;
    	int NewestPedal = Pedal.pedalList.size()-2;
    	from = OldestPedal;
    	to = NewestPedal;
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
	
	public int getFrom() {
		return from;
	}
	
	public int getTo() {
		return to;
	}
	
	public void setTo(int p) {
		to = p;
	}

	public void setFrom(int p) {
		from = p;
	}

	public String toString() {
		return "from: " + from + "   to: " + to;
	}

	public static void detectProximity(Surface surface) {
		if (surface.getComponentCount() > 2) {
                
            int currentX, currentY;
            int compareToX, compareToY;
            
            int draggingP, draggingFrom;

            Pedal lastTouch = (Pedal) surface.getComponent(0);
            currentX = (int) lastTouch.getLocation().getX() + lastTouch.getWidth();
            currentY = (int) lastTouch.getLocation().getY();

            Pedal compare = (Pedal) surface.getComponent(1);
            compareToX = (int) compare.getLocation().getX();
            compareToY = (int) compare.getLocation().getY();
            
            
            int distanceX = currentX - compareToX;
            int distanceY = currentY - compareToY;
            int distance = (int) Math.abs(Math.sqrt(distanceX * distanceX + distanceY * distanceY));
            
            //Pedal lt = (Pedal)I/
            //int dX, cX, oX;
            
            //for(Point nextP:Pedal.inPoints) {
            //	dX =nextP.getX();
            //}
            //dX = 
            draggingP = Pedal.pedalList.size(); // if pedalList size is 2, the location of elements index 2 and 2+1 will be changed
                                                // the Z value of pedals will be brought to front whenever it is dragged
                                                //
            draggingFrom = Pedal.pedalList.size()+1; // change this to be more dynamic, maybe the closest pedal towards
                                                     // the right.
            
            if (distance < 83 && distance > 67) {
                ((Indicator) surface.getComponentAt(MainClass2.indyP)).somethingHappened();

                //cableStart = compare.getLocation();
                
                int getLocX = (int) compare.getLocation().getX();
                int getLocY = (int) compare.getLocation().getY();
                MainClass2.newP = new Point (getLocX - 34, getLocY + compare.getHeight()/2 - 79); 
                surface.getComponent(draggingP).setLocation(MainClass2.newP); // change location of 4th
                surface.getComponent(draggingP).setVisible(true);

                
                int getLocX2 = (int) lastTouch.getLocation().getX() + lastTouch.getWidth();
                int getLocY2 = (int) lastTouch.getLocation().getY();
                MainClass2.newP = new Point (getLocX2, getLocY2 + lastTouch.getHeight()/2 - 79); 
                surface.getComponent(draggingFrom).setLocation(MainClass2.newP); 
                surface.getComponent(draggingFrom).setVisible(true);
                
            }
            else {
                ((Indicator) surface.getComponentAt(MainClass2.indyP)).nothingToSee();
                //System.out.println("distance between pedals is: " + distance);
                surface.getComponent(draggingP).setVisible(false);
                surface.getComponent(draggingFrom).setVisible(false);
            }
        }
		
	/*each pedal has 2 zones that check for
	 *proximity for other pedals' hot zones
	 *
	 *after they detect, draw a cable (with
	 *correct facing direction) connected 
	 *to each side
	 *
	 *if they are too far
	 *apart, hide them
*/	
		
		
		//currentX = surface.getlocationI/();
	}
    public static void updatePointArray(Surface surface, int touchedp){
    	Pedal.inPoints.set(touchedp,(surface.getComponent(touchedp).getLocationOnScreen()));
    }
    public static void updatePoint(){
    	Pedal selectedPedal = (Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP);
    	((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)).setOutPoint
    		(new Point((int)selectedPedal.getLocation().getX() - 34,
    				   (int)selectedPedal.getLocation().getY() + selectedPedal.getHeight()/2 - 79));

    	((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)).setInPoint
    		(new Point((int)selectedPedal.getLocation().getX() + selectedPedal.getWidth(),
    				   (int)selectedPedal.getLocation().getY() + selectedPedal.getHeight()/2 - 79));

    }
    public static void printProximity(){
    	//Pedal selectedPedal = (Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP);
    	for(int i = 0; i<Pedal.pedalList.size(); i++){
    		 // for eac element in the pedallist....
    		//if (!(((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)) == Pedal.pedalList.get(i))){
    			// if its not itself
                if(((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)).inP.distance(Pedal.pedalList.get(i).outP) < pt &&
                   ((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)).inP.distance(Pedal.pedalList.get(i).outP) > 34){ 
                	// check distance (inP to outP)
                	System.out.println("dragging inP close to " + i + " outP");

                    // this is to set IN of the last selected pedal from out 
                	
                    MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-3).setLocation(
                    ((Pedal)(MainClass2.surface.getComponentAt(DraggableThing.clickP))).inP);
                    /*
                            (new Point((int)selectedPedal.getLocation().getX() + selectedPedal.getWidth(),
                                               (int)selectedPedal.getLocation().getY() + selectedPedal.getHeight()/2 - 79)));
                                               */

                    // this is to set (from the OUT of the pedal closest  not the last selected pedal
                    MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-4).setLocation(Pedal.pedalList.get(i).outP);

                	MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-4).setVisible(true);
                	MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-3).setVisible(true);
                }
                else if(((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)).outP.distance(Pedal.pedalList.get(i).inP) < pt &&
                        ((Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP)).outP.distance(Pedal.pedalList.get(i).inP) > 34){
                	// check distance (outP to inP)
                	System.out.println("dragging outP close to " + i + " inP");

                	// set cables
                    // this is to set IN of the last selected pedal from out 
                    MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-4).setLocation(
                    ((Pedal)(MainClass2.surface.getComponentAt(DraggableThing.clickP))).outP);
                    /*
                    			   ((new Point((int)selectedPedal.getLocation().getX() - 34,
                                               (int)selectedPedal.getLocation().getY() + selectedPedal.getHeight()/2 - 79)));
                                               */

                    // this is to set (from the OUT of the pedal closest  not the last selected pedal
                    MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-3).setLocation
                    (Pedal.pedalList.get(i).inP);
                                    /*
                                    (int)MainClass2.surface.getComponentAt(selectedPedal.getLocation()).getLocation().getX() + selectedPedal.getWidth(),
                                    (int)MainClass2.surface.getComponentAt(selectedPedal.getLocation()).getLocation().getY() + selectedPedal.getHeight()/2 - 79
                                    )
                                    .setLocation(Pedal.pedalList.get(i).inP);
                                    */

                	MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-4).setVisible(true);
                	MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-3).setVisible(true);
                }
                /*
                else {
                	MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-4).setVisible(false);
                	MainClass2.surface.getComponent(MainClass2.surface.getComponentCount()-3).setVisible(false);
                }
                */
    		}
    	//}
    }
    
    public static void cableTest(){
    	Pedal selectedPedal = (Pedal)MainClass2.surface.getComponentAt(DraggableThing.clickP);
    	System.out.println(
    			MainClass2.surface.getComponentAt(
    			(int)MainClass2.surface.getComponentAt(selectedPedal.getLocation()).getLocation().getX() + selectedPedal.getWidth(),
    			(int)MainClass2.surface.getComponentAt(selectedPedal.getLocation()).getLocation().getY() + selectedPedal.getHeight()/2 - 79
    			)
    			);
                            //(new Point((int)selectedPedal.getLocation().getX() + selectedPedal.getWidth(),
                                               //(int)selectedPedal.getLocation().getY() + selectedPedal.getHeight()/2 - 79))));


    }
}
