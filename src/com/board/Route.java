package com.board;

import java.util.ArrayList;

public class Route implements Cloneable{
	public ArrayList <Position> line;
	@Override
	public Object clone() {
		Route route=null;
		try {
			route=(Route) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return route;
	}
	public Route() {
		line = new ArrayList <>();
	}

	public Route(Route rt) {
		line = new ArrayList <Position>();
		for(Position pos : rt.line) {
			line.add(pos);
		}
	}
}
