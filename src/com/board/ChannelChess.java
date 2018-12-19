public class ChannelChess extends Chess{

	public ChannelChess(Mode mode) {
		this.canRotate=false;
		this.mode=mode;
	}
	public ChannelChess() {
		canRotate=true;
		mode=Mode.HORIZONTAL;
	}
	@Override
	public void rotate() {
		if(canRotate) {
			mode=(mode==Mode.HORIZONTAL)?Mode.VERTICAL:Mode.HORIZONTAL;
		}
		
	}

	@Override
	public Direction route(Direction dir) {
		if(mode==Mode.HORIZONTAL) {
			switch(dir){
			case UP:
				return Direction.DOWN;
			case DOWN:
				return Direction.UP;
			default:
				return Direction.NULL;
			}
		}
		else if(mode==Mode.VERTICAL) {
			switch (dir) {
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

}