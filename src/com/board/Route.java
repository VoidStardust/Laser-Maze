import java.util.ArrayList;

public class Route {
	public ArrayList<Position> line;
	public Route() {
		line=new ArrayList<>();
	}
	public Route(Route rt) {
		line=new ArrayList<Position>();
		for(Position pos:rt.line) {
			line.add(pos);
		}
	}
}
