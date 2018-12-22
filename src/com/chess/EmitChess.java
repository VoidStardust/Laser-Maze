package com.chess;

import java.awt.*;
import java.awt.image.ImageObserver;

public class EmitChess extends Chess {

	public EmitChess(Mode mode) {
		this.mode = mode;
		this.canRotate = false;
	}

	public EmitChess() {
		canRotate = true;
		mode = Mode.UP;
	}

	@Override
	public void rotate() {
		if(canRotate) {
			Mode modeArray[] = {Mode.UP, Mode.RIGHT, Mode.DOWN, Mode.LEFT};
			int i;
			for(i = 0; i < 4; i++)
				if(mode == modeArray[i])
					break;
			mode = modeArray[(i + 1) % 4];
		}
	}

	@Override
	public Direction route(Direction dir) {
		return Direction.NULL;
	}

	@Override
	public boolean equals(Chess obj) {
		return obj instanceof EmitChess && this.mode == obj.mode;
	}

	@Override
	public ChessType getType() {
		return ChessType.EmitChess;
	}

	@Override
	public void DrawChess(Graphics graphics, int x, int y, ImageObserver imageObserver) {
		Graphics2D g = (Graphics2D) graphics;
		String imageFile = "../img/empty_chess.jpg";
		Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
		g.drawImage(image, x, y, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
	}
}
