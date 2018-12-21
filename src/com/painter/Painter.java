package com.painter;

import com.board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Painter {

	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}

	public static void DrawBoard(Graphics graphics, Board board, ImageObserver imageObserver) {
//		graphics.setColor(Color.BLACK);
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				board.board[i][j].DrawChess(graphics, i, j, imageObserver);
			}
		}
	}
}