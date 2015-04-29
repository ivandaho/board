package board;

public class Pedal_BOSS extends Pedal {
	

	public Pedal_BOSS(){
		super("BOSS");
		setBase("BOSS");
		setPedalID(2);
		setWidth(70+5+5);
		setFsCount(0);
        setHeight(126);
        setInJack_0_y(0.4);
        setOutJack_0_y(0.4);
	}
	
	public void callAll(){
		setPedalID(2);
		setWidth(70+5+5);
		setFsCount(0);
        setHeight(126);
		
	}

}

