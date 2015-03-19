package board;

import java.awt.Point;

public class Cable extends UndraggableImageThing{

	private double w = 34; 
    private double h = 92;
    
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
            int dX, cX, oX;
            
            //for(Point nextP:Pedal.inPoints) {
            //	dX =nextP.getX();
            //}
            //dX = 
            
            if (distance < 83 && distance > 67) {
                ((Indicator) surface.getComponentAt(MainClass2.indyP)).somethingHappened();

                //cableStart = compare.getLocation();
                int getLocX = (int) compare.getLocation().getX();
                int getLocY = (int) compare.getLocation().getY();
                MainClass2.newP = new Point (getLocX - 34, getLocY + compare.getHeight()/2 - 79); 
                
                draggingP = Pedal.pedalList.size();
                draggingFrom = Pedal.pedalList.size()+1;
                surface.getComponent(draggingP).setLocation(MainClass2.newP); // last 4th element
                surface.getComponent(draggingP).setVisible(true);

                int getLocX2 = (int) lastTouch.getLocation().getX() + lastTouch.getWidth();
                int getLocY2 = (int) lastTouch.getLocation().getY();
                MainClass2.newP = new Point (getLocX2, getLocY2 + lastTouch.getHeight()/2 - 79); 
                surface.getComponent(draggingFrom).setLocation(MainClass2.newP); // last 4th element
                surface.getComponent(draggingFrom).setVisible(true);
            }
            else {
                ((Indicator) surface.getComponentAt(MainClass2.indyP)).nothingToSee();
                //System.out.println("distance between pedals is: " + distance);
                surface.getComponent(Pedal.pedalList.size()).setVisible(false);
                surface.getComponent(Pedal.pedalList.size()+1).setVisible(false);
            }
        }
		
		
		
		//currentX = surface.getlocationI/();
	}
    public static void updateJacks(Surface surface, int p){

        
    }
}
