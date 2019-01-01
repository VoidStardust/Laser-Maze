package com.panel;

import com.board.Board;

import com.board.Rounds;

import com.chess.Chess;
import com.chess.ChessType;
import com.chess.EmptyChess;
import com.painter.Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GamePanel extends JPanel implements MouseListener {

	private Board board = new Board(0, 0);
	private Chess selectedChess = new EmptyChess();
	private static int selected;

	public GamePanel() {
		this.addMouseListener(this);
	}

	public void setRound(int n) {
		board =Rounds.getRound(n);
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Painter.DrawBoard(g, board, this);
		Painter.DrawRoutes(g, board);
		Painter.DrawUnused(g, 550, board.getUnusedChess(), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int ret = inArea(x, y);

		//System.out.println(ret);

		if(ret == 0) {
			x /= 100;
			y /= 100;

			if(selectedChess.getType() != ChessType.EmptyChess && board.board[y][x].getType() == ChessType.EmptyChess) {
				board.addChess(y,x,selectedChess);
				board.getUnusedChess().remove(selected);
				selectedChess = new EmptyChess();
			} else {
				board.board[y][x].rotate();
			}
		} else if(ret == 1) {
			selected = y / 100;
			selectedChess = (Chess) board.getUnusedChess().get(selected).clone();
		}

		board.update();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		//System.out.println(x + " " + y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		//System.out.println(x + " " + y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	private static int inArea(int x, int y) {
		if(x >= 0 && y >= 0 && x <= 500 && y <= 500) {
			return 0;
		} else if(x >= 500 && y >= 0 && y <= 500) {
			return 1;
		}
		return 2;
	}
}
