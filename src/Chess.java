
public abstract class Chess {
	//enum Direction;
	boolean canRotate;
	boolean used;
	int position[];
	public abstract void rotate();
	public void setUsed() {
		//used=!used;
		used=true;
	}
	
}
