package com.board;

import java.util.ArrayList;
import java.util.Stack;

import com.chess.*;


public class Board {

	public Chess[][] board;
	private ArrayList<VisitInfo> visitInfos;
	private ArrayList<Route> routeArray;
	public ArrayList<Chess> unusedChess;
	public Stack<Position> positionStack;
	int level;
	int roundNum;
	Position start;

	public Board(int level, int roundNum) {
		board = new Chess[5][5];
		routeArray = new ArrayList<Route>();
		visitInfos = new ArrayList<VisitInfo>();
		positionStack = new Stack<Position>();
		unusedChess = new ArrayList<Chess>();
		initChess();
		this.level = level;
		start = new Position(-1, -1);
	}

	private boolean visited(VisitInfo info) {
		for(VisitInfo vif : visitInfos) {
			if(vif.equals(info))
				return true;
		}
		return false;
	}

	private void initChess() {
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				addChess(new EmptyChess(), i, j);
	}

	public void addChess(Chess chess, int x, int y) {
		if(!inArea(x, y))
			return;
		if(board[x][y] instanceof BlockChess)
			return;
		board[x][y] = chess;
		if(chess instanceof EmitChess) {
			setBegin(x, y);
		}
	}

	public void addChess(int x, int y, Chess chess) {
		addChess(chess, x, y);
		if(!(chess instanceof EmptyChess))
			positionStack.push(new Position(x, y));
	}


	public void setBegin(int x, int y) {
		start = new Position(x, y);
	}

	public ArrayList<Route> getRoute() {
		return routeArray;
	}

	public void addUnusedChess(Chess chess) {
		unusedChess.add(chess);
	}

	public ArrayList<Chess> getUnusedChess() {
		return unusedChess;
	}

	public boolean formRoute() {
		int x = start.getX();
		int y = start.getY();
		if(x != -1 && y != -1) {
			Route rt = new Route();
			rt.line.add(new Position(x, y));
			Mode mode = board[x][y].mode;
			Direction dir = Direction.NULL;
			switch(mode) {
				case UP:
					x = x - 1;
					dir = Direction.DOWN;
					break;
				case DOWN:
					x = x + 1;
					dir = Direction.UP;
					break;
				case LEFT:
					y = y - 1;
					dir = Direction.RIGHT;
					break;
				case RIGHT:
					y = y + 1;
					dir = Direction.LEFT;
					break;
				default:
					return false;
			}
			return formRoute(x, y, dir, rt);
		}
		return false;
	}

	private boolean inArea(int x, int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5;
	}

	private boolean formRoute(int x, int y, Direction dir, Route rt) {
		if(!inArea(x, y)) {
			routeArray.add(rt);
			return false;
		}
		if(visited(new VisitInfo(new Position(x, y), dir))) {
			routeArray.add(rt);
			return false;
		}
		rt.line.add(new Position(x, y));
		visitInfos.add(new VisitInfo(new Position(x, y), dir));
		Chess chess = board[x][y];
		if(chess instanceof ReceiveChess) {
			chess.route(dir);
			if(((ReceiveChess) chess).isReceived()) {
				routeArray.add(rt);
				((ReceiveChess) chess).reset();
				return true;
			}
		}
		boolean res = true;
		int tmpx = x;
		int tmpy = y;
		Direction tmpdir = dir;
		Direction newDir = chess.route(dir);
		switch(newDir) {
			case UP:
				x = x - 1;
				dir = Direction.DOWN;
				break;
			case DOWN:
				x = x + 1;
				dir = Direction.UP;
				break;
			case LEFT:
				y = y - 1;
				dir = Direction.RIGHT;
				break;
			case RIGHT:
				y = y + 1;
				dir = Direction.LEFT;
				break;
			default:
				routeArray.add(rt);
				return false;
		}
		if(chess instanceof DualReflectorChess) {
			Route newRt = new Route(rt);
			Direction forkDir = ((DualReflectorChess) chess).fork(tmpdir);
			switch(forkDir) {
				case UP:
					tmpx = tmpx - 1;
					tmpdir = Direction.DOWN;
					break;
				case DOWN:
					tmpx = tmpx + 1;
					tmpdir = Direction.UP;
					break;
				case LEFT:
					tmpy = tmpy - 1;
					tmpdir = Direction.RIGHT;
					break;
				case RIGHT:
					tmpy = tmpy + 1;
					tmpdir = Direction.LEFT;
					break;
				default:
					routeArray.add(rt);
					return false;
			}
			res = formRoute(tmpx, tmpy, tmpdir, newRt) && res;
		}
		res = formRoute(x, y, dir, rt) && res;
		return res;
	}


	/*public void withdraw() {
		if(!positionStack.isEmpty()) {
			Position pos = positionStack.pop();
			int x = pos.getX();
			int y = pos.getY();
			Chess chess = (Chess) board[x][y].clone();
			chess.resetMode();
			board[x][y] = new EmptyChess();
			unusedChess.add(chess);
		}

	}*/

	public int giveGrade() {
		return level * 100;
	}

	public void update() {
		routeArray.clear();
		visitInfos.clear();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j] instanceof ReceiveChess) {
					ReceiveChess receiveChess = (ReceiveChess) board[i][j];
					receiveChess.reset();
				}
			}
		}
		formRoute();
	}
	public void autoSolve(){
		int x=start.getX();
		int y=start.getY();
		if(x !=-1 && y != -1){
			Route rt=new Route();
			autoSolve(x,y,Direction.UP,rt);
			autoSolve(x,y,Direction.DOWN,rt);
			autoSolve(x,y,Direction.LEFT,rt);
			autoSolve(x,y,Direction.RIGHT,rt);
		}
	}
	private void autoSolve(int x,int y,Direction dir,Route rt){
		switch (dir){
			case UP:
				x--;
				System.out.println("up");
				break;
			case DOWN:
				x++;
				System.out.println("down");
				break;
			case LEFT:
				y--;
				System.out.println("left");
				break;
			case RIGHT:
				y++;
				System.out.println("right");
				break;
			default:
				routeArray.add(rt);
				System.out.println("end");
				break;
		}
		if(!inArea(x,y)){
			routeArray.add(rt);
			System.out.println("out of area");
			return;
		}
		if(visited(new VisitInfo(new Position(x, y), dir))) {
			routeArray.add(rt);
			System.out.println("visited");
			return ;
		}
		rt.line.add(new Position(x, y));
		visitInfos.add(new VisitInfo(new Position(x, y), dir));
		Direction []dirArray={Direction.UP,Direction.LEFT,Direction.DOWN,Direction.RIGHT};
		int j;
		for ( j = 0; j < 4; j++) {
			if(dirArray[j].equals(dir))
				break;
		}
		Chess chess=board[x][y];
		ChessType type=chess.getType();
		switch (type){
			case EmptyChess:
				autoSolve(x,y,dir,rt);
				break;
			case ReflectorChess:
				autoSolve(x,y,dirArray[(j+1)%4],rt);
				autoSolve(x,y,dirArray[(j+3)%4],rt);
				break;
			case ChannelChess:
				autoSolve(x,y,dir,rt);
				break;
			case ReceiveChess:
				autoSolve(x,y,dirArray[(j+1)%4],rt);
				autoSolve(x,y,dirArray[(j+3)%4],rt);
				autoSolve(x,y,Direction.NULL,rt);
				break;
			case DualReflectorChess:
				autoSolve(x,y,dirArray[(j+1)%4],rt);
				autoSolve(x,y,dirArray[(j+3)%4],rt);
				Route forkRt=new Route(rt);
				autoSolve(x,y,dir,forkRt);
				break;
		}
	}

	public static void main(String[] args) {
		Board board=new Board(0,0);
		board.addChess(new EmitChess(),4,1);
		board.addChess(new ReceiveChess(),4,4);
		board.addChess(new ReceiveChess(),0,0);
		board.addChess(new ReceiveChess(),0,4);
		board.addChess(new ReceiveChess(),4,0);
		board.autoSolve();
		for(Route rt: board.routeArray){
			System.out.println("---");
			for(Position pos:rt.line){
				System.out.println(pos);
			}
		}
	}
}

class VisitInfo {
	public Position pos;
	public Direction dir;


	public VisitInfo(Position pos, Direction dir) {
		this.pos = pos;
		this.dir = dir;
	}

	public boolean equals(VisitInfo info) {
		return info.pos.equals(this.pos) && info.dir.equals(this.dir);
	}
}