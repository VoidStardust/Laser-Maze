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

	public GamePanel() {
		this.addMouseListener(this);
	}

	public void setBoard(int n) {
		board = Rounds.getInstance().rounds.get(n);
		board.update();
		board.formRoute();
	}

	public void setBoard(Board board) {
		this.board = board;
		this.board.update();
		this.board.formRoute();
	}

	public Board getBoard() {
		return board;
	}

	public void setSelectedChess(Chess selectedChess) {
		this.selectedChess = selectedChess;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Painter.DrawBoard(g, board, this);
		Painter.DrawRoutes(g, board);
		Painter.DrawUnused(g, board.getUnusedChess(), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int ret = inArea(x, y);

		System.out.println(ret);

		if(ret == 0) {
			x /= 100;
			y /= 100;

			if(selectedChess.getType() != ChessType.EmptyChess && board.board[y][x].getType() == ChessType.EmptyChess) {
				board.addChess(selectedChess, y, x);
				selectedChess = new EmptyChess();
			} else {
				board.board[y][x].rotate();
			}
		}
		else if(ret == 1) {
			y /= 100;
			System.out.println(y);
			selectedChess = board.getUnusedChess().get(y);
		}

		board.update();
		board.formRoute();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

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
		}
		else if(x >= 500) {
			return 1;
		}
		return 2;
	}
}
