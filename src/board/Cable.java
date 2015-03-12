package board;

public class Cable extends UndraggableImageThing{

	private double w = 34; 
    private double h = 92;
    public Cable(){
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
