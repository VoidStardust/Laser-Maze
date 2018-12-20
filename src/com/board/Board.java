import java.util.ArrayList;
public class Board {
	public Chess board[][];
	private ArrayList<Route> routeArray;
	int level;
	int roundNum;
	Position start;
	Position end;
	public Board(int level,int roundNum) {
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
				return;
			}
		}
		int tmpx=x;
		int tmpy=y;
		Direction tmpdir=dir;
		Direction newDir=chess.route(dir);
		switch (newDir) {
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
				break;
			}		
		if(chess instanceof DualReflectorChess) {
			Route newRt=new Route(rt);
			Direction forkDir=((DualReflectorChess) chess).fork(tmpdir);
			switch (forkDir) {
			case UP:
				tmpx=tmpx-1;
				tmpdir=Direction.DOWN;
				break;
			case DOWN:
				tmpx=tmpx+1;
				tmpdir=Direction.UP;
				break;
			case LEFT:
				tmpy=tmpy-1;
				tmpdir=Direction.RIGHT;
				break;
			case RIGHT:
				tmpy=tmpy+1;
				tmpdir=Direction.LEFT;
				break;
			default:
				break;
			}
			formRoute(tmpx, tmpy, tmpdir, newRt);		
		}
		formRoute(x,y,dir,rt);	
	}
	/*
	public boolean isCorrect() {
		boolean res=false;
		int i=0,j=0;
		for(;i<5;i++) {
			for(;j<5;j++) {
				if(board[i][j] instanceof EmitChess) {
					res=true;
					break;
				}
			}
		}
		if(res) {
			setBegin(i, j);
			Mode mode=board[i][j].mode;
			Direction dir=Direction.NULL;
			switch (mode) {
			case UP:
				i=i-1;
				dir=Direction.DOWN;
				break;
			case DOWN:
				i=i+1;
				dir=Direction.UP;
				break;
			case LEFT:
				j=j-1;
				dir=Direction.RIGHT;
				break;
			case RIGHT:
				j=j+1;
				dir=Direction.LEFT;
				break;
			default:
				break;
			}
			return isCorrect(i,j,dir);
		}
		return false;
	}
	private boolean isCorrect(int x,int y,Direction dir) {
		if(!inArea(x, y))
			return false;
		
		return true;
	}*/
	public void giveSolution() {
		Board solutionBoard=Rounds.getInstance().solutions.get(roundNum);
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				this.board[i][j]=solutionBoard.board[i][j];
			}
		}
		//repaint
	}
	public void giveHint() {
		Board solutionBoard=Rounds.getInstance().solutions.get(roundNum);
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(solutionBoard.board[i][j].equals(this.board[i][j])) {
					continue;
				}
				else {
					this.board[i][j]=solutionBoard.board[i][j];
					break;
					//repaint
				}
			}
		}
	}
	public int getGrade() {
		return level*100;
	}
	public static void main(String[]args) {
		Board board20=new Board(4,20);
		board20.addChess(new EmitChess(Mode.LEFT),2,4);
		board20.addChess(new DualReflectorChess(Mode.RIGHT), 1, 1);
		board20.addChess(new DualReflectorChess(Mode.RIGHT), 3, 2);
		board20.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 1);
		board20.addChess(new ReceiveChess(Mode.RIGHTLEFT), 1, 4);
		board20.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 2);
		board20.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 1);
		board20.addChess(new ReceiveChess(Mode.LEFTUP), 4, 2);
		board20.formRoute();
		ArrayList<Route>routeArray=board20.getRoute();
		for(Route route:routeArray){
			System.out.println("---");
			for(Position pos:route.line) {
			System.out.println(pos);
			}
			
		}
	}
}
