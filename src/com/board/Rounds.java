package com.board;

import com.chess.*;

import java.util.ArrayList;

public class Rounds {
	public ArrayList<Board> rounds = new ArrayList<>();
	public ArrayList<Board> solutions = new ArrayList<>();

	public Rounds() {
		initRounds();
		initSolutions();
	}

	private static final Rounds missons = new Rounds();

	public static Rounds getInstance() {
		return missons;
	}

	public void initSolutions() {
		Board board1 = new Board(1, 0);
		board1.addChess(new EmitChess(Mode.UP), 4, 4);
		board1.addChess(new ReceiveChess(Mode.LEFTUP), 2, 4);
		board1.addChess(new ReflectorChess(Mode.LEFT), 2, 2);
		board1.addChess(new BlockChess(), 2, 0);
		board1.addChess(new ReceiveChess(Mode.LEFTUP), 0, 2);
		board1.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 0);
		solutions.add(board1);

		Board board2 = new Board(1, 1);
		board2.addChess(new EmitChess(Mode.RIGHT), 4, 1);
		board2.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 4);
		board2.addChess(new ReceiveChess(Mode.LEFTUP), 0, 4);
		board2.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 0);
		board2.addChess(new ReceiveChess(Mode.LEFTUP), 4, 0);
		solutions.add(board2);

		Board board3 = new Board(1, 2);
		board3.addChess(new EmitChess(Mode.RIGHT), 4, 2);
		board3.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		board3.addChess(new BlockChess(), 4, 4);
		board3.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		board3.addChess(new ChannelChess(Mode.VERTICAL), 0, 2);
		board3.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 0);
		solutions.add(board3);

		Board board4 = new Board(1, 3);
		board4.addChess(new EmitChess(Mode.LEFT), 3, 4);
		board4.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 1);
		board4.addChess(new ChannelChess(Mode.VERTICAL), 3, 3);
		board4.addChess(new ReflectorChess(Mode.LEFT), 3, 1);
		solutions.add(board4);

		Board board5 = new Board(1, 4);
		board5.addChess(new EmitChess(Mode.RIGHT), 4, 0);
		board5.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 0);
		board5.addChess(new DualReflectorChess(Mode.LEFT), 2, 3);
		board5.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 3);
		board5.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		solutions.add(board5);

		Board board6 = new Board(2, 5);
		board6.addChess(new EmitChess(Mode.LEFT), 2, 4);
		board6.addChess(new ReflectorChess(Mode.RIGHT), 2, 2);
		board6.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 1);
		board6.addChess(new ChannelChess(Mode.HORIZONTAL), 1, 2);
		board6.addChess(new BlockChess(), 1, 3);
		board6.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		board6.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 2);
		board6.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 2);
		board6.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 3);
		solutions.add(board6);

		Board board7 = new Board(2, 6);
		board7.addChess(new EmitChess(Mode.DOWN), 0, 2);
		board7.addChess(new ChannelChess(Mode.HORIZONTAL), 1, 2);
		board7.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 2);
		board7.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		board7.addChess(new ReceiveChess(Mode.RIGHTLEFT), 3, 1);
		board7.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 1);
		board7.addChess(new ReceiveChess(Mode.LEFTUP), 3, 3);
		solutions.add(board7);

		Board board8 = new Board(2, 7);
		board8.addChess(new EmitChess(Mode.RIGHT), 0, 0);
		board8.addChess(new DualReflectorChess(Mode.LEFT), 0, 3);
		board8.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 4);
		board8.addChess(new ReceiveChess(Mode.RIGHTLEFT), 1, 4);
		board8.addChess(new ReflectorChess(Mode.LEFT), 1, 3);
		solutions.add(board8);

		Board board9 = new Board(2, 8);
		board9.addChess(new EmitChess(Mode.DOWN), 3, 1);
		board9.addChess(new DualReflectorChess(Mode.LEFT), 2, 2);
		board9.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 3);
		board9.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 0);
		board9.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 0);
		board9.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 1);
		board9.addChess(new ReceiveChess(Mode.LEFTUP), 4, 2);
		solutions.add(board9);

		Board board10 = new Board(2, 9);
		board10.addChess(new EmitChess(Mode.RIGHT), 1, 1);
		board10.addChess(new DualReflectorChess(Mode.RIGHT), 1, 3);
		board10.addChess(new ReceiveChess(Mode.LEFTUP), 1, 4);
		board10.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 3);
		board10.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 3);
		board10.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 4);
		solutions.add(board10);

		Board board11 = new Board(3, 10);
		board11.addChess(new EmitChess(Mode.LEFT), 2, 4);
		board11.addChess(new ReflectorChess(Mode.RIGHT), 2, 3);
		board11.addChess(new ChannelChess(Mode.HORIZONTAL), 3, 3);
		board11.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		board11.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 1);
		board11.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 1);
		board11.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 1);
		board11.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		solutions.add(board11);

		Board board12 = new Board(3, 11);
		board12.addChess(new EmitChess(Mode.LEFT), 3, 4);
		board12.addChess(new ReflectorChess(Mode.LEFT), 3, 3);
		board12.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 0);
		board12.addChess(new BlockChess(), 4, 0);
		board12.addChess(new ReceiveChess(Mode.LEFTUP), 4, 3);
		board12.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 0);
		board12.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 0);
		board12.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		solutions.add(board12);

		Board board13 = new Board(3, 12);
		board13.addChess(new EmitChess(Mode.LEFT), 2, 4);
		board13.addChess(new DualReflectorChess(Mode.LEFT), 2, 3);
		board13.addChess(new DualReflectorChess(Mode.RIGHT), 2, 2);
		board13.addChess(new ReceiveChess(Mode.LEFTUP), 1, 3);
		board13.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 1, 2);
		board13.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 1);
		board13.addChess(new ChannelChess(Mode.HORIZONTAL), 3, 2);
		board13.addChess(new BlockChess(), 3, 3);
		board13.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 2);
		board13.addChess(new ReceiveChess(Mode.RIGHTLEFT), 4, 3);
		solutions.add(board13);

		Board board14 = new Board(3, 13);
		board14.addChess(new EmitChess(Mode.UP), 4, 1);
		board14.addChess(new BlockChess(), 3, 1);
		board14.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 0);
		board14.addChess(new DualReflectorChess(Mode.RIGHT), 3, 2);
		board14.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 2);
		board14.addChess(new ReceiveChess(Mode.RIGHTLEFT), 4, 4);
		board14.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 1);
		board14.addChess(new ReflectorChess(Mode.RIGHT), 0, 1);
		board14.addChess(new DualReflectorChess(Mode.LEFT), 0, 2);
		board14.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 4);
		solutions.add(board14);

		Board board15 = new Board(3, 14);
		board15.addChess(new EmitChess(Mode.RIGHT), 1, 1);
		board15.addChess(new DualReflectorChess(Mode.LEFT), 1, 2);
		board15.addChess(new DualReflectorChess(Mode.RIGHT), 2, 2);
		board15.addChess(new ReflectorChess(Mode.RIGHT), 1, 3);
		board15.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 3);
		board15.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 1);
		board15.addChess(new ReceiveChess(Mode.LEFTUP), 3, 1);
		board15.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 1);
		board15.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 2);
		solutions.add(board15);

		Board board16 = new Board(4, 15);
		board16.addChess(new EmitChess(Mode.RIGHT), 0, 0);
		board16.addChess(new DualReflectorChess(Mode.LEFT), 0, 1);
		board16.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 3);
		board16.addChess(new ReceiveChess(Mode.LEFTDOWN), 1, 0);
		board16.addChess(new DualReflectorChess(Mode.RIGHT), 2, 0);
		board16.addChess(new BlockChess(), 2, 1);
		board16.addChess(new ChannelChess(Mode.VERTICAL), 2, 2);
		board16.addChess(new ReceiveChess(Mode.LEFTUP), 2, 4);
		board16.addChess(new ReceiveChess(Mode.LEFTUP), 3, 4);
		board16.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 0);
		board16.addChess(new ReflectorChess(Mode.RIGHT), 4, 1);
		solutions.add(board16);

		Board board17 = new Board(4, 16);
		board17.addChess(new EmitChess(Mode.UP), 3, 1);
		board17.addChess(new ChannelChess(Mode.HORIZONTAL), 3, 3);
		board17.addChess(new DualReflectorChess(Mode.LEFT), 0, 2);
		board17.addChess(new DualReflectorChess(Mode.RIGHT), 1, 3);
		board17.addChess(new BlockChess(), 1, 2);
		board17.addChess(new ReflectorChess(Mode.RIGHT), 2, 2);
		board17.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 1);
		board17.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		board17.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 1, 0);
		board17.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 0);
		board17.addChess(new ReceiveChess(Mode.LEFTUP), 4, 3);
		solutions.add(board17);

		Board board18 = new Board(4, 17);
		board18.addChess(new EmitChess(Mode.LEFT), 3, 2);
		board18.addChess(new DualReflectorChess(Mode.LEFT), 3, 1);
		board18.addChess(new ChannelChess(Mode.VERTICAL), 1, 2);
		board18.addChess(new ReflectorChess(Mode.RIGHT), 4, 4);
		board18.addChess(new ReceiveChess(Mode.RIGHTLEFT), 1, 1);
		board18.addChess(new ReceiveChess(Mode.LEFTUP), 1, 4);
		board18.addChess(new ReceiveChess(Mode.LEFTDOWN), 2, 0);
		board18.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 0);
		board18.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 0);
		solutions.add(board18);

		Board board19 = new Board(4, 18);
		board19.addChess(new EmitChess(Mode.UP), 4, 0);
		board19.addChess(new DualReflectorChess(Mode.RIGHT), 3, 0);
		board19.addChess(new DualReflectorChess(Mode.RIGHT), 3, 3);
		board19.addChess(new ReceiveChess(Mode.RIGHTLEFT), 3, 4);
		board19.addChess(new ReflectorChess(Mode.LEFT), 2, 3);
		board19.addChess(new BlockChess(), 0, 0);
		board19.addChess(new ChannelChess(Mode.HORIZONTAL), 1, 1);
		board19.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 0);
		board19.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 1);
		board19.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 1);
		board19.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 2);
		solutions.add(board19);

		Board board20 = new Board(4, 19);
		board20.addChess(new EmitChess(Mode.LEFT), 2, 4);
		board20.addChess(new DualReflectorChess(Mode.RIGHT), 1, 1);
		board20.addChess(new DualReflectorChess(Mode.RIGHT), 3, 2);
		board20.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 1);
		board20.addChess(new ReceiveChess(Mode.RIGHTLEFT), 1, 4);
		board20.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 2);
		board20.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 1);
		board20.addChess(new ReceiveChess(Mode.LEFTUP), 4, 2);
		solutions.add(board20);
	}

	public void initRounds() {
		Board board1 = new Board(1, 0);//9
		board1.addChess(new EmitChess(), 4, 4);
		board1.addChess(new ReflectorChess(), 2, 2);
		board1.addChess(new BlockChess(), 2, 0);
		board1.addChess(new ReceiveChess(), 0, 0);
		board1.addUnusedChess(new ReceiveChess());
		board1.addUnusedChess(new ReceiveChess());
		rounds.add(board1);

		Board board2 = new Board(1, 1);//10
		board2.addChess(new EmitChess(), 4, 1);
		board2.addChess(new ReceiveChess(), 0, 4);
		board2.addChess(new ReceiveChess(), 4, 0);
		board2.addUnusedChess(new ReceiveChess());
		board2.addUnusedChess(new ReceiveChess());
		rounds.add(board2);

		Board board3 = new Board(1, 2);//8
		board3.addChess(new EmitChess(), 4, 2);
		board3.addChess(new BlockChess(), 4, 4);
		board3.addChess(new ChannelChess(Mode.VERTICAL), 0, 2);
		board3.addChess(new ReceiveChess(), 0, 0);
		board3.addUnusedChess(new ReceiveChess());
		board3.addUnusedChess(new ReceiveChess());
		rounds.add(board3);

		Board board4 = new Board(1, 3);//6
		board4.addChess(new ReceiveChess(), 0, 1);
		board4.addChess(new ChannelChess(Mode.VERTICAL), 3, 3);
		board4.addUnusedChess(new EmitChess());
		board4.addUnusedChess(new ReflectorChess());
		rounds.add(board4);

		Board board5 = new Board(1, 4);//11
		board5.addChess(new EmitChess(), 4, 0);
		board5.addChess(new ReceiveChess(), 0, 3);
		board5.addChess(new ReceiveChess(), 2, 0);
		board5.addChess(new ReceiveChess(), 4, 3);
		board5.addUnusedChess(new DualReflectorChess());
		rounds.add(board5);

		Board board6 = new Board(2, 5);//28
		board6.addChess(new EmitChess(), 2, 4);
		board6.addChess(new ReflectorChess(Mode.RIGHT), 2, 2);
		board6.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 1);
		board6.addChess(new BlockChess(), 1, 3);
		board6.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 3);
		board6.addUnusedChess(new ReceiveChess());
		board6.addUnusedChess(new ReceiveChess());
		board6.addUnusedChess(new ReceiveChess());
		board6.addUnusedChess(new ChannelChess());
		rounds.add(board6);

		Board board7 = new Board(2, 6);//18
		board7.addChess(new ChannelChess(), 1, 2);
		board7.addChess(new ReceiveChess(), 4, 2);
		board7.addChess(new ReceiveChess(), 4, 3);
		board7.addChess(new ReceiveChess(), 3, 1);
		board7.addChess(new ReceiveChess(), 4, 1);
		board7.addChess(new ReceiveChess(), 3, 3);
		board7.addUnusedChess(new EmitChess());
		rounds.add(board7);

		Board board8 = new Board(2, 7);//17
		board8.addChess(new EmitChess(), 0, 0);
		board8.addChess(new ReceiveChess(), 0, 4);
		board8.addChess(new ReflectorChess(), 1, 3);
		board8.addUnusedChess(new ReceiveChess());
		board8.addUnusedChess(new DualReflectorChess());
		rounds.add(board8);

		Board board9 = new Board(2, 8);//16
		board9.addChess(new EmitChess(Mode.DOWN), 3, 1);
		board9.addChess(new ReceiveChess(), 2, 3);
		board9.addChess(new ReceiveChess(Mode.LEFTUP), 4, 2);
		board9.addUnusedChess(new ReceiveChess());
		board9.addUnusedChess(new ReceiveChess());
		board9.addUnusedChess(new ReceiveChess());
		board9.addUnusedChess(new DualReflectorChess());
		rounds.add(board9);

		Board board10 = new Board(2, 9);//19
		board10.addChess(new EmitChess(), 1, 1);
		board10.addChess(new ReceiveChess(), 0, 3);
		board10.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 3);
		board10.addUnusedChess(new ReceiveChess());
		board10.addUnusedChess(new ReceiveChess());
		board10.addUnusedChess(new DualReflectorChess());
		rounds.add(board10);

		Board board11 = new Board(3, 10);//44
		board11.addChess(new ReflectorChess(), 2, 3);
		board11.addChess(new ChannelChess(), 3, 3);
		board11.addChess(new ReceiveChess(), 4, 1);
		board11.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 1);
		board11.addChess(new ReceiveChess(), 0, 3);
		board11.addUnusedChess(new ReceiveChess());
		board11.addUnusedChess(new ReceiveChess());
		board11.addUnusedChess(new EmitChess());
		rounds.add(board11);

		Board board12 = new Board(3, 11);//31
		board12.addChess(new EmitChess(), 3, 4);
		board12.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 0);
		board12.addChess(new BlockChess(), 4, 0);
		board12.addChess(new ReceiveChess(), 4, 3);
		board12.addChess(new ReceiveChess(), 0, 0);
		board12.addChess(new ReceiveChess(), 0, 3);
		board12.addUnusedChess(new ReceiveChess());
		board12.addUnusedChess(new ReflectorChess());
		rounds.add(board12);

		Board board13 = new Board(3, 12);//45 must be receiver
		board13.addChess(new ReceiveChess(), 1, 3);
		board13.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 1, 2);
		board13.addChess(new ReceiveChess(), 2, 1);
		board13.addChess(new BlockChess(), 3, 3);
		board13.addChess(new ReceiveChess(), 4, 2);
		board13.addChess(new ReceiveChess(), 4, 3);
		board13.addUnusedChess(new EmitChess());
		board13.addUnusedChess(new DualReflectorChess());
		board13.addUnusedChess(new DualReflectorChess());
		board13.addUnusedChess(new ChannelChess());
		rounds.add(board13);

		Board board14 = new Board(3, 13);//42
		board14.addChess(new BlockChess(), 3, 1);
		board14.addChess(new ReceiveChess(), 3, 0);
		board14.addChess(new DualReflectorChess(), 3, 2);
		board14.addChess(new ReceiveChess(), 4, 2);
		board14.addChess(new ReceiveChess(), 4, 4);
		board14.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 1);
		board14.addChess(new ReceiveChess(), 0, 4);
		board14.addUnusedChess(new EmitChess());
		board14.addUnusedChess(new ReflectorChess());
		board14.addUnusedChess(new DualReflectorChess());
		rounds.add(board14);

		Board board15 = new Board(3, 14);//43
		board15.addChess(new EmitChess(Mode.RIGHT), 1, 1);
		board15.addChess(new ReflectorChess(Mode.RIGHT), 1, 3);
		board15.addChess(new ReceiveChess(Mode.LEFTUP), 3, 1);
		board15.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 1);
		board15.addUnusedChess(new ReceiveChess());
		board15.addUnusedChess(new ReceiveChess());
		board15.addUnusedChess(new ReceiveChess());
		board15.addUnusedChess(new DualReflectorChess());
		board15.addUnusedChess(new DualReflectorChess());
		rounds.add(board15);

		Board board16 = new Board(4, 15);//60
		board16.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 3);
		board16.addChess(new ReceiveChess(Mode.LEFTDOWN), 1, 0);
		board16.addChess(new BlockChess(), 2, 1);
		board16.addChess(new ChannelChess(), 2, 2);
		board16.addChess(new ReceiveChess(Mode.LEFTUP), 3, 4);
		board16.addChess(new ReflectorChess(), 4, 1);
		board16.addUnusedChess(new ReceiveChess());
		board16.addUnusedChess(new ReceiveChess());
		board16.addUnusedChess(new DualReflectorChess());
		board16.addUnusedChess(new DualReflectorChess());
		board16.addUnusedChess(new EmitChess());
		rounds.add(board16);

		Board board17 = new Board(4, 16);//59
		board17.addChess(new EmitChess(Mode.UP), 3, 1);
		board17.addChess(new ChannelChess(), 3, 3);
		board17.addChess(new DualReflectorChess(), 1, 3);
		board17.addChess(new BlockChess(), 1, 2);
		board17.addChess(new ReflectorChess(), 2, 2);
		board17.addChess(new ReceiveChess(), 1, 0);
		board17.addChess(new ReceiveChess(), 2, 0);
		board17.addUnusedChess(new ReceiveChess());
		board17.addUnusedChess(new ReceiveChess());
		board17.addUnusedChess(new ReceiveChess());
		board17.addUnusedChess(new DualReflectorChess());
		rounds.add(board17);

		Board board18 = new Board(4, 17);//58
		board18.addChess(new EmitChess(), 3, 2);
		board18.addChess(new ChannelChess(), 1, 2);
		board18.addChess(new ReflectorChess(Mode.RIGHT), 4, 4);
		board18.addChess(new ReceiveChess(Mode.LEFTDOWN), 2, 0);
		board18.addChess(new ReceiveChess(), 3, 0);
		board18.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 0);
		board18.addUnusedChess(new ReceiveChess());
		board18.addUnusedChess(new ReceiveChess());
		board18.addUnusedChess(new DualReflectorChess());
		rounds.add(board18);

		Board board19 = new Board(4, 18);//57
		board19.addChess(new EmitChess(), 4, 0);
		board19.addChess(new ReceiveChess(), 3, 4);
		board19.addChess(new ReflectorChess(), 2, 3);
		board19.addChess(new BlockChess(), 0, 0);
		board19.addChess(new ChannelChess(), 1, 1);
		board19.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 1);
		board19.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 2);
		board19.addUnusedChess(new ReceiveChess());
		board19.addUnusedChess(new ReceiveChess());
		board19.addUnusedChess(new DualReflectorChess());
		board19.addUnusedChess(new DualReflectorChess());
		rounds.add(board19);

		Board board20 = new Board(4, 19);//49
		board20.addChess(new EmitChess(Mode.LEFT), 2, 4);
		board20.addChess(new DualReflectorChess(), 1, 1);
		board20.addChess(new DualReflectorChess(), 3, 2);
		board20.addChess(new ReceiveChess(), 1, 4);
		board20.addUnusedChess(new ReceiveChess());
		board20.addUnusedChess(new ReceiveChess());
		board20.addUnusedChess(new ReceiveChess());
		board20.addUnusedChess(new ReceiveChess());
		rounds.add(board20);
	}
}
