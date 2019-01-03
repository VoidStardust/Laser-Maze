package com.chess;

import com.painter.Painter;

import java.awt.*;
import java.awt.image.ImageObserver;

public class EmptyChess extends Chess {
	private static final Image image = Toolkit.getDefaultToolkit().getImage("./img/empty_chess.png");

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

	@Override
	public boolean equalsIgnoreMode(Chess obj){
		return obj instanceof EmptyChess;
	}

	@Override
	public ChessType getType() {
		return ChessType.EmptyChess;
	}

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		g.drawImage(image, x, y, Painter.width, Painter.height, imageObserver);
	}
}
