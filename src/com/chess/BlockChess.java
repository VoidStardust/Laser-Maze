package com.chess;

public class BlockChess extends Chess{
	@Override
	public void rotate() {}
	public BlockChess() {
		mode=Mode.NULL;
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

	
}
