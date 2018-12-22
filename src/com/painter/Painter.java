package com.painter;

import com.board.Board;
import com.board.Rounds;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Painter {

	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}

	public static void DrawBoard(Graphics graphics, int n, ImageObserver imageObserver) {
//		graphics.setColor(Color.BLACK);
		Board board = Rounds.getInstance().rounds.get(n);
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				board.board[i][j].DrawChess(graphics, i * 100, j * 100, imageObserver);
			}
		}
	}

	public static void DrawRoute(Graphics graphics, Board board) {
		//
	}
}