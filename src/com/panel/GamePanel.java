package com.panel;

import com.board.Board;

import com.board.Position;
import com.board.Rounds;

import com.chess.Chess;
import com.chess.ChessType;
import com.chess.EmptyChess;
import com.painter.Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener {

	private Board board;
	private Chess selectedChess = new EmptyChess();
	private boolean mode = false; //0 common mode, >0 diy mode
	private static int selected = -1;

	public GamePanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public GamePanel(boolean mode) {
		this.mode = mode;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public void setRound(int n) {
		board = Rounds.getRound(n);
		board.update();
		repaint();
	}

	public void setSolution(int n) {
		board = Rounds.getSolution(n);
		board.update();
		repaint();
	}

	public void setBoard(Board board) {
		this.board = (Board) board;
		this.board.update();
		repaint();
	}

	public Board getBoard() {
		return board;
	}

	public void setSelectedChess(Chess selectedChess) {
		this.selectedChess = selectedChess;
	}

	public void withdraw() {
		board.withdraw();
		board.update();
		repaint();
	}

	public void giveHint(int n) {
		Graphics g = getGraphics();
		Board solutionBoard = Rounds.getSolution(n);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(board.board[i][j].equals(solutionBoard.board[i][j])) {
					continue;
				} else if(board.board[i][j].equalsIgnoreMode(solutionBoard.board[i][j])) {
					Painter.DrawQuestion(g, j, i);
				} else {
					if(board.board[i][j] instanceof EmptyChess) {
						Painter.DrawExclamation(g, j, i);
					} else {
						Painter.DrawCross(g, j, i);
					}
				}
			}
		}
	}

	public boolean isCorrect(int n) {
		Board solutionBoard = Rounds.getSolution(n + 1);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(!board.board[i][j].equals(solutionBoard.board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		Painter.DrawBoard(g, board, this);
		Painter.DrawRoutes(g, board);
		Painter.DrawUnused(g, selected, board.getUnusedChess(), this);
		Painter.DrawDividing(g, 525, 50, 400);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int ret = inArea(x, y);

		if(ret == 0) {
			x /= Painter.width;
			y /= Painter.height;

			if(selectedChess.getType() != ChessType.EmptyChess && board.board[y][x].getType() == ChessType.EmptyChess) {
				board.addChess(y, x, selectedChess);
				if(!mode) {
					board.getUnusedChess().remove(selected);
					selectedChess = new EmptyChess();
					selected = -1;
				}
			} else {
				board.board[y][x].rotate();
			}
		} else if(ret == 1) {
			y /= Painter.height;
			if(y < board.getUnusedChess().size()) {
				selected = y;
				selectedChess = (Chess) board.getUnusedChess().get(selected).clone();
			}
		}

		board.update();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		//System.out.println(x + " " + y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		repaint();
	}

	private static int inArea(int x, int y) {
		if(x >= 0 && y >= 0 && x <= 500 && y <= 500) {
			return 0;
		} else if(x >= 500 && y >= 0 && y <= 500) {
			return 1;
		}
		return 2;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

//		int ret = inArea(x, y);
//
//		if(ret == 1) {
//			if(y / Painter.height != select) {
//				repaint();
//				select = y / Painter.height;
//				Painter.DrawHighlight(getGraphics(), 550, select * Painter.height);
//			}
//		} else {
//			repaint();
//		}
	}
}
