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

public class GamePanel extends JPanel implements MouseListener {

	private Board board;
	private Chess selectedChess = new EmptyChess();

	public GamePanel() {
		board = new Board(0, 1);
		this.addMouseListener(this);
	}

	public void setBoard(int n) {
		board = Rounds.getInstance().rounds.get(n);
		board.formRoute();
	}

	public void setBoard(Board board) {
		this.board = board;
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int y = e.getX() / 100;
		int x = e.getY() / 100;

		if(selectedChess.getType() != ChessType.EmptyChess) {
			board.addChess(selectedChess, x, y);
			board.formRoute();
		}

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
}
