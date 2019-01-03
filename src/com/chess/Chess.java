package com.chess;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Chess implements Cloneable {
	public Mode mode;
	public boolean canRotate;

	public abstract void rotate();

	public abstract Direction route(Direction dir);

	public abstract boolean equals(Chess obj);

	public abstract boolean equalsIgnoreMode(Chess obj);

	public abstract ChessType getType();

	public abstract void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver);

	public void resetMode() {
		mode = Mode.NULL;
	}

	@Override
	public Object clone() {
		Chess chess = null;
		try {
			chess = (Chess) super.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return chess;
	}
}
