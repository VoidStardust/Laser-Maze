package com.painter;

import com.board.Board;

import javax.swing.*;
import java.awt.*;

public class Painter {

	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}

	public static void DrawBoard(Graphics graphics, Board board) {
		graphics.setColor(Color.BLACK);
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				switch(board.board[i][j].getType())
				{
					case EmitChess:
					case BlockChess:
					case EmptyChess:
					case ChannelChess:
					case ReceiveChess:
					case ReflectorChess:
					case DualReflectorChess:
				}
			}
		}

	}

	public static void DrawChess(Graphics graphics, int x, int y)
	{

	}
}