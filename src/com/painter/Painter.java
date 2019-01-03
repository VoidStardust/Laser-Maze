package com.painter;

import com.board.Board;
import com.board.Position;
import com.board.Rounds;
import com.board.Route;
import com.chess.Chess;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Painter {

	public static final int width = 100;
	public static final int height = 100;
	private static final int[] X = {0, width, width * 2, width * 3, width * 4};
	private static final int[] Y = {0, height, height * 2, height * 3, height * 4};

	public static void DrawBoard(Graphics graphics, int n, ImageObserver imageObserver) {
		Board board = Rounds.getRound(n);
		DrawBoard(graphics, board, imageObserver);
	}

	public static void DrawBoard(Graphics graphics, Board board, ImageObserver imageObserver) {
		for(int j = 0; j < 5; j++) {
			for(int i = 0; i < 5; i++) {
				board.board[j][i].DrawChess(graphics, X[i], Y[j], imageObserver);
			}
		}
	}

	private static void DrawRoute(Graphics graphics, Route route) {
//		Graphics2D g = (Graphics2D) graphics;
		ArrayList<Position> line = route.line;
//		g.setColor(Color.red);
//		BasicStroke bs1 = new BasicStroke(5);
//		g.setStroke(bs1);
		for(int i = 0; i + 1 < line.size(); i++) {
			Position p1 = line.get(i);
			Position p2 = line.get(i + 1);
			DrawArrow(graphics, X[p1.getY()] + width / 2, Y[p1.getX()] + height / 2,
					X[p2.getY()] + width / 2, Y[p2.getX()] + height / 2);
		}
	}

	public static void DrawRoutes(Graphics graphics, Board board) {
		ArrayList<Route> routes = board.getRoute();
		for(Route route : routes) {
			DrawRoute(graphics, route);
		}
	}

	public static void DrawUnused(Graphics graphics, int select, ArrayList<Chess> unusedChess,
	                              ImageObserver imageObserver) {
//		int pos = 0;
//		for(Chess chess : unusedChess) {
//			chess.DrawChess(graphics, 550, pos, imageObserver);
//			pos += height;
//		}
		for(int i = 0; i < unusedChess.size(); i++) {
			unusedChess.get(i).DrawChess(graphics, 550, i * 100, imageObserver);
		}
		if(select >= 0 && select < unusedChess.size()) {
			DrawHighlight(graphics, 550, select * 100);
		}
	}

	public static void DrawCross(Graphics graphics, int x, int y) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.red);
		BasicStroke bs1 = new BasicStroke(5);
		g.setStroke(bs1);
		g.drawLine(x * width, y * height, (x + 1) * width, (y + 1) * height);
		g.drawLine((x + 1) * width, y * height, x * width, (y + 1) * height);
	}

	public static void DrawExclamation(Graphics graphics, int x, int y) {
		Graphics2D g = (Graphics2D) graphics;
		g.setFont(new Font("Consolas", Font.BOLD, 100));
		g.setColor(Color.red);
		g.drawString("!", x * width + 24, (y + 1) * height - 16);
	}

	public static void DrawQuestion(Graphics graphics, int x, int y) {
		Graphics2D g = (Graphics2D) graphics;
		g.setFont(new Font("Consolas", Font.BOLD, 100));
		g.setColor(Color.red);
		g.drawString("?", x * width + 24, (y + 1) * height - 16);
	}

	public static void DrawDividing(Graphics graphics, int x, int y, int length) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.gray);
		BasicStroke bs1 = new BasicStroke(5);
		g.setStroke(bs1);
		g.drawLine(x, y, x, y + length);
	}

	private static void DrawArrow(Graphics graphics, int x1, int y1, int x2, int y2) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.red);
		BasicStroke bs1 = new BasicStroke(4);
		g.setStroke(bs1);

		double H = 6;
		double L = 3;
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		double rad = Math.atan(L / H);
		double len = Math.sqrt(L * L + H * H);
		double[] arrXY_1 = rotateVec(x2 - x1, y2 - y1, rad, len);
		double[] arrXY_2 = rotateVec(x2 - x1, y2 - y1, -rad, len);
		double x_3 = x2 - arrXY_1[0];
		double y_3 = y2 - arrXY_1[1];
		double x_4 = x2 - arrXY_2[0];
		double y_4 = y2 - arrXY_2[1];

		Double X3 = x_3;
		x3 = X3.intValue();
		Double Y3 = y_3;
		y3 = Y3.intValue();
		Double X4 = x_4;
		x4 = X4.intValue();
		Double Y4 = y_4;
		y4 = Y4.intValue();

		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
		g.drawLine(x2, y2, x4, y4);
	}

	private static double[] rotateVec(int px, int py, double ang, double newLen) {
		double[] mathStr = new double[2];
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		double d = Math.sqrt(vx * vx + vy * vy);
		vx = vx / d * newLen;
		vy = vy / d * newLen;
		mathStr[0] = vx;
		mathStr[1] = vy;
		return mathStr;
	}

	public static void DrawHighlight(Graphics graphics, int x, int y) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.red);
		BasicStroke bs1 = new BasicStroke(5);
		g.setStroke(bs1);
		g.drawRoundRect(x, y, width, height, 21, 21);
	}
}