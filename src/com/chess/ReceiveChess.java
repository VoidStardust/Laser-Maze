package com.chess;

import com.painter.Painter;

import java.awt.*;
import java.awt.image.ImageObserver;

public class ReceiveChess extends Chess {
	private boolean received;

	public ReceiveChess(Mode mode) {
		this.canRotate = false;
		this.mode = mode;
		received = false;
	}

	public ReceiveChess() {
		canRotate = true;
		received = false;
		mode = Mode.NULL;
	}

	@Override
	public void rotate() {
		if(canRotate) {
			received = false;
			Mode[] modeArray = {Mode.LEFTDOWN, Mode.RIGHTLEFT, Mode.LEFTUP, Mode.RIGHTRIGHT};
			int i;
			for(i = 0; i < 4; i++)
				if(mode == modeArray[i])
					break;
			mode = modeArray[(i + 1) % 4];
		}

	}

	@Override
	public Direction route(Direction dir) {
		if(mode == Mode.LEFTDOWN) {
			switch(dir) {
				case UP:
					return Direction.RIGHT;
				case DOWN:
					received = true;
					return Direction.NULL;
				case LEFT:
					return Direction.NULL;
				case RIGHT:
					return Direction.UP;
			}
		} else if(mode == Mode.RIGHTLEFT) {
			switch(dir) {
				case UP:
					return Direction.NULL;
				case DOWN:
					return Direction.RIGHT;
				case LEFT:
					received = true;
					return Direction.NULL;
				case RIGHT:
					return Direction.DOWN;
			}
		} else if(mode == Mode.LEFTUP) {
			switch(dir) {
				case UP:
					received = true;
					return Direction.NULL;
				case DOWN:
					return Direction.LEFT;
				case LEFT:
					return Direction.DOWN;
				case RIGHT:
					return Direction.NULL;
			}
		} else if(mode == Mode.RIGHTRIGHT) {
			switch(dir) {
				case UP:
					return Direction.LEFT;
				case DOWN:
					return Direction.NULL;
				case LEFT:
					return Direction.UP;
				case RIGHT:
					received = true;
					return Direction.NULL;
			}
		}
		return Direction.NULL;
	}

	public boolean isReceived() {
		return received;
	}

	@Override
	public boolean equals(Chess obj) {
		return obj instanceof ReceiveChess && obj.mode == this.mode;
	}

	@Override
	public ChessType getType() {
		return ChessType.ReceiveChess;
	}

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		String imageFile = "./img/receive_chess.png";

		switch(mode) {
			case LEFTDOWN:
				imageFile = "./img/receive_chess_leftdown.png";
				break;
			case RIGHTLEFT:
				imageFile = "./img/receive_chess_rightleft.png";
				break;
			case LEFTUP:
				imageFile = "./img/receive_chess_leftup.png";
				break;
			case RIGHTRIGHT:
				imageFile = "./img/receive_chess_rightright.png";
				break;
		}

		Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
		g.drawImage(image, x, y, Painter.width, Painter.height, imageObserver);
	}
}
