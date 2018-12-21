package com.chess;

public abstract class Chess {
	public Mode mode;
	public boolean canRotate;

	public abstract void rotate();

	public abstract Direction route(Direction dir);

	public abstract boolean equals(Chess obj);

	public abstract ChessType getType();
}
