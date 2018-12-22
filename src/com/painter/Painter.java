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

	public static final int width = 100;
	public static final int height = 100;
	private static final int[] X = {0, width, width * 2, width * 3, width * 4};
	private static final int[] Y = {0, height, height * 2, height * 3, height * 4};

	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}

	public static void DrawBoard(Graphics graphics, int n, ImageObserver imageObserver) {
		Board board = Rounds.getInstance().rounds.get(n);
		DrawBoard(graphics, board, imageObserver);
	}

	public static void DrawBoard(Graphics graphics, Board board, ImageObserver imageObserver) {
		for(int j = 0; j < 5; j++)
		{
			for(int i = 0; i < 5; i++)
			{
				board.board[j][i].DrawChess(graphics, X[i], Y[j], imageObserver);
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
			g.drawLine(X[p1.getY()] + width / 2, Y[p1.getX()] + height / 2,
					X[p2.getY()] + width / 2, Y[p2.getX()] + height / 2);
		}
	}

	public static void DrawRoutes(Graphics graphics, Board board) {
		ArrayList<Route> routes = board.getRoute();
		for(Route route : routes) {
			DrawRoute(graphics, route);
		}
	}
}