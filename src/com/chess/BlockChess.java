package com.chess;

import com.chess.Chess;
import com.chess.Direction;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BlockChess extends Chess {
	private static final Image image = Toolkit.getDefaultToolkit().getImage("./img/block_chess.png");

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

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		g.drawImage(image, x, y, 100, 100, imageObserver);
	}
}
