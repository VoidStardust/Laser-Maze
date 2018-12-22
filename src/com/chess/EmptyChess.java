package com.chess;

import java.awt.*;
import java.awt.image.ImageObserver;

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

	@Override
	public ChessType getType() {
		return ChessType.EmptyChess;
	}

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		String imageFile = "../img/empty_chess.jpg";
		Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
		g.drawImage(image, x, y, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
	}
}
