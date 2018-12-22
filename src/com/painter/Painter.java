package com.painter;

import com.board.Board;
import com.board.Position;
import com.board.Rounds;
import com.board.Route;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Painter {

	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}

	public static void DrawBoard(Graphics graphics, int n, ImageObserver imageObserver) {
		Board board = Rounds.getInstance().rounds.get(n);
		DrawBoard(graphics, board, imageObserver);
	}

	public static void DrawBoard(Graphics graphics, Board board, ImageObserver imageObserver) {
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				board.board[j][i].DrawChess(graphics, i * 100, j * 100, imageObserver);
			}
		}
	}

	private static void DrawRoute(Graphics graphics, Route route) {
		Graphics2D g = (Graphics2D) graphics;
		ArrayList<Position> line = route.line;
		g.setColor(Color.red);
		BasicStroke bs1 = new BasicStroke(5);
		g.setStroke(bs1);
		for(int i = 0; i + 1 < line.size(); i++) {
			Position p1 = line.get(i);
			Position p2 = line.get(i + 1);
			g.drawLine(p1.getY() * 100 + 50, p1.getX() * 100 + 50,
					p2.getY() * 100 + 50, p2.getX() * 100 + 50);
		}
	}

	public static void DrawRoutes(Graphics graphics, Board board) {
		ArrayList<Route> routes = board.getRoute();
		for(Route route : routes) {
			DrawRoute(graphics, route);
		}
	}
}