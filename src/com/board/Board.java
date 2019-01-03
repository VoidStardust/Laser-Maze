package com.board;

import java.util.ArrayList;
import java.util.Stack;

import com.chess.*;

public class Board {

	public Chess[][] board;
	private ArrayList<VisitInfo> visitInfos;
	private ArrayList<Route> routeArray;
	private ArrayList<Chess> unusedChess;
	private Stack<Position> positionStack;
	int level;
	int roundNum;
	Position start;
	Position checkPoint;

	public Board(int level, int roundNum) {
		board = new Chess[5][5];
		routeArray = new ArrayList<Route>();
		visitInfos = new ArrayList<VisitInfo>();
		positionStack = new Stack<Position>();
		unusedChess = new ArrayList<Chess>();
		initChess();
		this.level = level;
		start = new Position(-1, -1);
		checkPoint = new Position(-1, -1);
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

	void addChess(Chess chess, int x, int y) {
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
		System.out.println(x + "," + y);
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
		if(chess instanceof ChannelChess) {
			checkPoint = new Position(x, y);
			((ChannelChess) chess).setUsed();
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
		if(checkPoint.getX() != -1 && checkPoint.getY() != -1)
			res = res && ((ChannelChess) board[checkPoint.getX()][checkPoint.getY()]).used();
		return res;
	}


	public void withdraw() {
		if(!positionStack.isEmpty()) {
			Position pos = positionStack.pop();
			int x = pos.getX();
			int y = pos.getY();
			Chess chess = (Chess) board[x][y].clone();
			chess.resetMode();
			board[x][y] = new EmptyChess();
			unusedChess.add(chess);
		}

	}

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