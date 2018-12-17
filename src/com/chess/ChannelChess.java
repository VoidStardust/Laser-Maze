package com.chess;

public class ChannelChess extends Chess{

	public ChannelChess(boolean canRotate,Mode mode) {
		this.canRotate=canRotate;
		this.mode=mode;
	}
	public ChannelChess() {
		canRotate=true;
	}
	@Override
	public void rotate() {
		
		
	}

	@Override
	public Direction route(Direction dir) {
		// TODO Auto-generated method stub
		return null;
	}

}
