package com.chess;

import com.painter.Painter;

import java.awt.*;
import java.awt.image.ImageObserver;

public class ChannelChess extends Chess {
	boolean used;

	public ChannelChess(Mode mode) {
		this.canRotate = false;
		this.mode = mode;
		used = false;
	}

	public boolean used() {
		return used;
	}

	public ChannelChess() {
		canRotate = true;
		mode = Mode.HORIZONTAL;
	}

	@Override
	public void rotate() {
		if(canRotate) {
			mode = (mode == Mode.HORIZONTAL) ? Mode.VERTICAL : Mode.HORIZONTAL;
		}

	}

	@Override
	public Direction route(Direction dir) {
		if(mode == Mode.HORIZONTAL) {
			switch(dir) {
				case UP:
					return Direction.DOWN;
				case DOWN:
					return Direction.UP;
				default:
					return Direction.NULL;
			}
		} else if(mode == Mode.VERTICAL) {
			switch(dir) {
				case LEFT:
					return Direction.RIGHT;
				case RIGHT:
					return Direction.LEFT;
				default:
					return Direction.NULL;
			}
		}
		return Direction.NULL;
	}

	@Override
	public boolean equals(Chess obj) {
		return obj instanceof ChannelChess && obj.mode == this.mode;
	}

	@Override
	public ChessType getType() {
		return ChessType.ChannelChess;
	}

	public void setUsed() {
		used = true;
	}

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		String imageFile = "./img/channel_chess_vertical.png";

		switch(mode) {
			case HORIZONTAL:
				imageFile = "./img/channel_chess_horizontal.png";
				break;
			case VERTICAL:
				imageFile = "./img/channel_chess_vertical.png";
				break;
		}

		Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
		g.drawImage(image, x, y, Painter.width, Painter.height, imageObserver);
	}
}
