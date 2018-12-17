package com.chess;

public abstract class Chess {
	public Mode mode;
	public boolean canRotate;
	//boolean used;
	public int position[];
	public abstract void rotate();
	public abstract Direction route(Direction dir);
	/*public void setUsed() {
		//used=!used;
		used=true;
	}*/
	
}
