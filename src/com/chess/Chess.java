package com.chess;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Chess {
	public Mode mode;
	public boolean canRotate;

	public abstract void rotate();

	public abstract Direction route(Direction dir);

	public abstract boolean equals(Chess obj);

	public abstract ChessType getType();

	public abstract void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver);
}
