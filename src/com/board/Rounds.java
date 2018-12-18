import java.util.ArrayList;

public class Rounds {
	ArrayList<Board>rounds;
	ArrayList<Board>solutions;
	public void initSolutions(){
		Board board1=new Board(1);
		board1.addChess(new EmitChess(Mode.UP), 4, 4);
		board1.addChess(new ReceiveChess(Mode.LEFTUP), 2, 4);
		board1.addChess(new ReflectorChess(Mode.LEFT), 2, 2);
		board1.addChess(new BlockChess(), 2, 0);
		board1.addChess(new ReceiveChess(Mode.LEFTUP), 0, 2);
		board1.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 0);
		solutions.add(board1);
		
		Board board2=new Board(1);
		board2.addChess(new EmitChess(Mode.RIGHT), 4, 1);
		board2.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 4);
		board2.addChess(new ReceiveChess(Mode.LEFTUP), 0, 4);
		board2.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 0);
		board2.addChess(new ReceiveChess(Mode.LEFTUP), 4, 0);
		solutions.add(board2);
		
		Board board3=new Board(1);
		board3.addChess(new EmitChess(Mode.RIGHT), 4, 2);
		board3.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		board3.addChess(new BlockChess(), 4, 4);
		board3.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		board3.addChess(new ChannelChess(Mode.VERTICAL), 0, 2);
		board3.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 0);
		solutions.add(board3);
		
		Board board4=new Board(1);
		board4.addChess(new EmitChess(Mode.LEFT), 3, 4);
		board4.addChess(new ReceiveChess(Mode.LEFTDOWN), 0, 1);
		board4.addChess(new ChannelChess(Mode.VERTICAL), 3, 3);
		board4.addChess(new ReflectorChess(Mode.LEFT), 3, 1);
		solutions.add(board4);
		
		Board board6=new Board(2);
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
		
		Board board7=new Board(2);
		board7.addChess(new EmitChess(Mode.DOWN), 0, 2);
		board7.addChess(new ChannelChess(Mode.HORIZONTAL), 1, 2);
		board7.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 2);
		board7.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		board7.addChess(new ReceiveChess(Mode.RIGHTLEFT), 3, 1);
		board7.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 1);
		board7.addChess(new ReceiveChess(Mode.LEFTUP), 3, 3);
		solutions.add(board7);
		
		Board board11=new Board(3);
		board11.addChess(new EmitChess(Mode.LEFT), 2, 4);
		board11.addChess(new ReflectorChess(Mode.RIGHT), 2, 3);
		board11.addChess(new ChannelChess(Mode.HORIZONTAL), 3, 3);
		board11.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 4, 3);
		board11.addChess(new ReceiveChess(Mode.LEFTDOWN), 4, 1);
		board11.addChess(new ReceiveChess(Mode.RIGHTLEFT), 2, 1);
		board11.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 1);
		board11.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		solutions.add(board11);
		
		Board board12=new Board(3);
		board12.addChess(new EmitChess(Mode.LEFT), 3, 4);
		board12.addChess(new ReflectorChess(Mode.LEFT), 3, 3);
		board12.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 0);
		board12.addChess(new BlockChess(), 4, 0);
		board12.addChess(new ReceiveChess(Mode.LEFTUP), 4, 3);
		board12.addChess(new ReceiveChess(Mode.LEFTDOWN), 3, 0);
		board12.addChess(new ReceiveChess(Mode.RIGHTLEFT), 0, 0);
		board12.addChess(new ReceiveChess(Mode.LEFTUP), 0, 3);
		solutions.add(board12);
	}
	public void initRounds() {
		Board board1=new Board(1);//9
		board1.addChess(new EmitChess(), 4, 4);
		board1.addChess(new ReflectorChess(), 2, 2);
		board1.addChess(new BlockChess(), 2, 0);
		board1.addChess(new ReceiveChess(), 0, 0);
		rounds.add(board1);
		
		Board board2=new Board(1);//10
		board2.addChess(new EmitChess(), 4, 1);
		board2.addChess(new ReceiveChess(), 0, 4);
		board2.addChess(new ReceiveChess(), 4, 0);
		rounds.add(board2);
		
		Board board3=new Board(1);//8
		board3.addChess(new EmitChess(), 4, 2);
		board3.addChess(new BlockChess(), 4, 4);
		board3.addChess(new ChannelChess(Mode.VERTICAL), 0, 2);
		board3.addChess(new ReceiveChess(), 0, 0);
		rounds.add(board3);
		
		Board board4=new Board(1);//6
		board4.addChess(new ReceiveChess(), 0, 1);
		board4.addChess(new ChannelChess(Mode.VERTICAL), 3, 3);
		rounds.add(board4);
		
		Board board6=new Board(2);//28
		board6.addChess(new EmitChess(), 2, 4);
		board6.addChess(new ReflectorChess(Mode.RIGHT), 2, 2);
		board6.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 2, 1);
		board6.addChess(new BlockChess(), 1, 3);
		board6.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 3, 3);
		rounds.add(board6);
		
		Board board7=new Board(2);//18
		board7.addChess(new ChannelChess(), 1, 2);
		board7.addChess(new ReceiveChess(), 4, 2);
		board7.addChess(new ReceiveChess(), 4, 3);
		board7.addChess(new ReceiveChess(), 3, 1);
		board7.addChess(new ReceiveChess(), 4, 1);
		board7.addChess(new ReceiveChess(), 3, 3);
		rounds.add(board7);
		
		Board board11=new Board(3);//44
		board11.addChess(new ReflectorChess(), 2, 3);
		board11.addChess(new ChannelChess(), 3, 3);
		board11.addChess(new ReceiveChess(), 4, 1);
		board11.addChess(new ReceiveChess(Mode.RIGHTRIGHT), 0, 1);
		board11.addChess(new ReceiveChess(), 0, 3);
		rounds.add(board11);
		
		Board board12=new Board(3);//31
		board12.addChess(new EmitChess(), 3, 4);
		board12.addChess(new ChannelChess(Mode.HORIZONTAL), 2, 0);
		board12.addChess(new BlockChess(), 4, 0);
		board12.addChess(new ReceiveChess(), 4, 3);
		board12.addChess(new ReceiveChess(), 0, 0);
		board12.addChess(new ReceiveChess(), 0, 3);
		rounds.add(board12);
	}
	public Rounds() {
		initRounds();
		initSolutions();
	}
}
