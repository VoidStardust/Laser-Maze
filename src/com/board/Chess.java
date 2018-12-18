
public abstract class Chess {
	public Mode mode;
	public boolean canRotate;
	public abstract void rotate();
	public abstract Direction route(Direction dir);
}
