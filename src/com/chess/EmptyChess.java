package com.chess;

public class EmptyChess extends Chess {
	public EmptyChess() {
		mode = Mode.NULL;
		canRotate = false;
	}

	@Override
	public void rotate() {
	}

	@Override
	public Direction route(Direction dir) {
		switch(dir) {
			case UP:
				return Direction.DOWN;
			case DOWN:
				return Direction.UP;
			case LEFT:
				return Direction.RIGHT;
			case RIGHT:
				return Direction.LEFT;
		}
		return Direction.NULL;
	}

	@Override
	public boolean equals(Chess obj) {
		return obj instanceof EmptyChess;
	}
}
