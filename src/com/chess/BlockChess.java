package com.chess;

import com.chess.Chess;
import com.chess.Direction;

public class BlockChess extends Chess {
	@Override
	public void rotate() {
	}

	public BlockChess() {
		mode = Mode.NULL;
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
			default:
				return Direction.NULL;
		}
	}

	@Override
	public boolean equals(Chess obj) {
		return obj instanceof BlockChess;
	}

	@Override
	public ChessType getType() {
		return ChessType.BlockChess;
	}
}
