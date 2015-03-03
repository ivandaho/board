package board;

public class Board_PT_Mini extends UndraggableImageThing{

	private double w = 508; 
    private double h = 178;
    public Board_PT_Mini(){
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
}
