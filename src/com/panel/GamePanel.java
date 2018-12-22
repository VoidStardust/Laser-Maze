package com.panel;

import com.board.Board;
import com.board.Rounds;
import com.chess.Chess;

import javax.swing.*;

public class GamePanel extends JPanel {
	private Board board;
	private Chess selectedChess;

	GamePanel() {
		setSize(500, 500);
	}

	public void setBoard(int n) {
		board = Rounds.getInstance().rounds.get(n);
	}

	public Board getBoard() {
		return board;
	}

	public void setSelectedChess(Chess selectedChess) {
		this.selectedChess = selectedChess;
	}
}
