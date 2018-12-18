
public class ReflectorChess extends Chess {

	public ReflectorChess(Mode mode) {
		this.canRotate=false;
		this.mode=mode;
	}
	public ReflectorChess() {
		canRotate=true;
		mode=Mode.LEFT;
	}
	@Override
	public void rotate() {
		if(canRotate) {
			mode=(mode==Mode.LEFT)?Mode.RIGHT:Mode.LEFT;
		}
	}

	@Override
	public Direction route(Direction dir) {
		if(mode==Mode.RIGHT) {
			switch (dir) {
			case UP:
				return Direction.LEFT;
		    case DOWN:
		    	return Direction.RIGHT;
		    case LEFT:
		    	return Direction.UP;
		    case RIGHT:
		    	return Direction.DOWN;	
			}
		}
		else if(mode==Mode.LEFT) {
			switch (dir) {
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
}
