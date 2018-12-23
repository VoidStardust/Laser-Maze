package com.chess;

import com.painter.Painter;

import java.awt.*;
import java.awt.image.ImageObserver;

public class DualReflectorChess extends Chess {
	public DualReflectorChess(Mode mode) {
		this.canRotate = false;
		this.mode = mode;
	}

	public DualReflectorChess() {
		canRotate = true;
		mode = Mode.NULL;
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

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		String imageFile = "./img/dual_reflector_chess_left.jpg";

		switch(mode) {
			case LEFT:
				imageFile = "./img/dual_reflector_chess_left.png";
				break;
			case RIGHT:
				imageFile = "./img/dual_reflector_chess_right.png";
				break;
		}

		Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
		g.drawImage(image, x, y, Painter.width, Painter.height, imageObserver);
	}
}
