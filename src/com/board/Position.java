package com.board;

public class Position implements Cloneable{
	int x;
	int y;
	@Override
	public Object clone() {
		Position pos=null;
		try {
			pos=(Position) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pos;
	}
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Position pos) {
		return this.x == pos.getX() && this.y == pos.getY();
	}
}
