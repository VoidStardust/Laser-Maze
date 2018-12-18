import java.util.ArrayList;
public class Board {
	public Chess board[][];
	private ArrayList<Route> routeArray;
	int level;
	Position start;
	Position end;
	public Board(int level) {
		board=new Chess[5][5];
		routeArray=new ArrayList<Route>();
		initChess();
		this.level=level;
		start=new Position(-1, -1);
		end=new Position(-1, -1);
	}
	private void initChess() {
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				addChess(new EmptyChess(), i, j);
	}
	public void addChess(Chess chess,int x,int y) {
		if(!inArea(x, y))
			return;
		if(board[x][y] instanceof BlockChess)
			return;
		board[x][y]=chess;
		if(chess instanceof EmitChess) {
			setBegin(x, y);
		}
	}
	public void deleteChess(int x,int y) {
		board[x][y]=new EmptyChess();
	}
	public void setBegin(int x,int y) {
		start=new Position(x, y);
	}
	public void setEnd(int x,int y) {
		end=new Position(x, y);
	}
	public ArrayList<Route> getRoute() {
		return routeArray;
	}
	public void formRoute() {
		int x=start.getX();
		int y=start.getY();
		if(x!=-1&&y!=-1) {
			Route rt=new Route();
			rt.line.add(new Position(x, y));
			Mode mode=board[x][y].mode;
			Direction dir=Direction.NULL;
			switch (mode) {
			case UP:
				x=x-1;
				dir=Direction.DOWN;
				break;
			case DOWN:
				x=x+1;
				dir=Direction.UP;
				break;
			case LEFT:
				y=y-1;
				dir=Direction.RIGHT;
				break;
			case RIGHT:
				y=y+1;
				dir=Direction.LEFT;
				break;
			default:
				return;
			}
			formRoute(x,y,dir,rt);
		}
	}
	private boolean inArea(int x,int y) {
		return 0<=x&&x<5&&0<=y&&y<5;
	}
	private void formRoute(int x,int y,Direction dir,Route rt) {
		if(!inArea(x, y))
			return;
		rt.line.add(new Position(x, y));
		Chess chess=board[x][y];
		if(chess instanceof ReceiveChess){
			chess.route(dir);
			if(((ReceiveChess) chess).isReceived()) {
				routeArray.add(rt);
				//System.out.println("received");
				return;
			}
		}
		int tmpx=x;
		int tmpy=y;
		Direction newDir=chess.route(dir);
			switch (newDir) {
			case UP: 
				System.out.println("("+x+","+y+")"+"up");
				x=x-1;
				dir=Direction.DOWN;
				break;
			case DOWN:
				System.out.println("("+x+","+y+")"+"down");
				x=x+1;
				dir=Direction.UP;
				break;
			case LEFT:
				System.out.println("("+x+","+y+")"+"left");
				y=y-1;
				dir=Direction.RIGHT;
				break;
			case RIGHT:
				System.out.println("("+x+","+y+")"+"right");
				y=y+1;
				dir=Direction.LEFT;
				break;
			default:
				break;
			}		
			formRoute(x,y,dir,rt);	
		/*if(chess instanceof DualReflectorChess) {
			Route newRt=new Route(rt);
			Direction straightDir=((DualReflectorChess) chess).goStraight(dir);
			switch (straightDir) {
			case UP:
				tmpx=tmpx-1;
				System.out.println("up"+"("+tmpx+","+tmpy+")");
				dir=Direction.DOWN;
			case DOWN:
				tmpx=tmpx+1;
				System.out.println("down"+"("+tmpx+","+tmpy+")");
				dir=Direction.UP;
			case LEFT:
				tmpy=tmpy-1;
				System.out.println("left"+"("+tmpx+","+tmpy+")");
				dir=Direction.RIGHT;
			case RIGHT:
				tmpy=tmpy+1;
				System.out.println("right"+"("+tmpx+","+tmpy+")");
				dir=Direction.LEFT;
			default:
				return;
			}
			//formRoute(tmpx, tmpy, dir, newRt);		
		}*/
	}
	public void solve() {
		
	}
	public void giveHint() {
		
	}
	public int getGrade() {
		return level*100;
	}
	public static void main(String[]args) {
		Board board12=new Board(3);
		board12.addChess(new EmitChess(Mode.LEFT), 3, 4);
		board12.addChess(new ReflectorChess(Mode.LEFT), 3, 3);
		board12.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 0);
		board12.addChess(new BlockChess(), 4, 0);
		board12.addChess(new ReceiveChess(Mode.LEFTUP), 4, 3);
		board12.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 0);
		board12.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 0);
		board12.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		board12.formRoute();
		ArrayList<Route>routeArray=board12.getRoute();
		for(Route route:routeArray){
			for(Position pos:route.line) {
			System.out.println(pos);
			}
		}
	}
}
