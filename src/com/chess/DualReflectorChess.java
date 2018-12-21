package com.chess;

public class DualReflectorChess extends Chess {
	public DualReflectorChess(Mode mode) {
		this.canRotate = false;
		this.mode = mode;
	}

	public DualReflectorChess() {
		canRotate = true;
		mode = Mode.LEFT;
	}

	@Override
	public void rotate() {
		if(canRotate) {
			mode = (mode == Mode.LEFT) ? Mode.RIGHT : Mode.LEFT;
		}
	}

	@Override
	public Direction route(Direction dir) {
		if(mode == Mode.RIGHT) {
			switch(dir) {
				case UP:
					return Direction.LEFT;
				case DOWN:
					return Direction.RIGHT;
				case LEFT:
					return Direction.UP;
				case RIGHT:
					return Direction.DOWN;
			}
		} else if(mode == Mode.LEFT) {
			switch(dir) {
				case UP:
					return Direction.RIGHT;
				case DOWN:
					return Direction.LEFT;
				case LEFT:
					return Direction.DOWN;
				case RIGHT:
					return Direction.UP;
			}
		}
		return Direction.NULL;
	}

	public Direction fork(Direction dir) {
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

		return obj instanceof DualReflectorChess && obj.mode == this.mode;
	}

	@Override
	public ChessType getType() {
		return ChessType.DualReflectorChess;
	}
}
