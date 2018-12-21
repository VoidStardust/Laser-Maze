package com.board;

import java.util.ArrayList;
import java.util.Stack;

import com.chess.*;

public class Board {
	public Chess board[][];
	private ArrayList <VisitInfo> visitInfos;
	private ArrayList <Route> routeArray;
	private Stack <Position> positionStack;
	int level;
	int roundNum;
	Position start;
	Position end;
	Position checkPoint;

	public Board(int level, int roundNum) {
		board = new Chess[5][5];
		routeArray = new ArrayList <Route>();
		visitInfos = new ArrayList <VisitInfo>();
		positionStack = new Stack <Position>();
		initChess();
		this.level = level;
		start = new Position(-1, -1);
		end = new Position(-1, -1);
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

	public void addChess(Chess chess, int x, int y) {
		if(!inArea(x, y))
			return;
		if(board[x][y] instanceof BlockChess)
			return;
		board[x][y] = chess;
		positionStack.push(new Position(x, y));
		if(chess instanceof EmitChess) {
			setBegin(x, y);
		}
	}

	public void deleteChess(int x, int y) {
		board[x][y] = new EmptyChess();
	}

	public void setBegin(int x, int y) {
		start = new Position(x, y);
	}

	public void setEnd(int x, int y) {
		end = new Position(x, y);
	}

	public ArrayList <Route> getRoute() {
		return routeArray;
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
		if(!inArea(x, y))
			return false;
		if(visited(new VisitInfo(new Position(x, y), dir)))
			return false;
		rt.line.add(new Position(x, y));
		visitInfos.add(new VisitInfo(new Position(x, y), dir));
		Chess chess = board[x][y];
		if(chess instanceof ReceiveChess) {
			chess.route(dir);
			if(((ReceiveChess) chess).isReceived()) {
				routeArray.add(rt);
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
					return false;
			}
			res = res && formRoute(tmpx, tmpy, tmpdir, newRt);
		}
		res = res && formRoute(x, y, dir, rt);
		if(checkPoint.getX() != -1 && checkPoint.getY() != -1)
			res = res && ((ChannelChess) board[checkPoint.getX()][checkPoint.getY()]).used();
		return res;
	}

	public boolean isCorrect() {
		boolean res;
		res = formRoute();
		/*if(!res) {
			while(!routeArray.isEmpty())
				routeArray.remove(routeArray.size()-1);
		}*/
		return res;
	}

	public void withdraw() {
		if(!positionStack.isEmpty()) {
			Position pos = positionStack.pop();
			int x = pos.getX();
			int y = pos.getY();
			board[x][y] = new EmptyChess();
		}
	}

	public void giveSolution() {
		Board solutionBoard = Rounds.getInstance().solutions.get(roundNum);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				this.board[i][j] = solutionBoard.board[i][j];
			}
		}
		//repaint
	}

	public void giveHint() {
		Board solutionBoard = Rounds.getInstance().solutions.get(roundNum);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(solutionBoard.board[i][j].equals(this.board[i][j])) {
					continue;
				} else {
					this.board[i][j] = solutionBoard.board[i][j];
					break;
					//repaint
				}
			}
		}
	}

	public int giveGrade() {
		return level * 100;
	}

	public static void main(String[] args) {
		Board board17 = new Board(4, 16);
		board17.addChess(new EmitChess(Mode.LEFT), 3, 3);
		board17.addChess(new DualReflectorChess(Mode.RIGHT), 3, 2);
		board17.addChess(new ReceiveChess(Mode.LEFTUP), 4, 2);
		board17.addChess(new ReflectorChess(Mode.LEFT), 3, 0);
		board17.addChess(new ReflectorChess(Mode.RIGHT), 1, 0);
		board17.addChess(new ReflectorChess(Mode.LEFT), 1, 2);
		System.out.println(board17.isCorrect());
		ArrayList <Route> routeArray = board17.getRoute();
		for(Route route : routeArray) {
			System.out.println("---");
			for(Position pos : route.line) {
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