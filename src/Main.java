import com.board.Rounds;
import com.chess.BlockChess;
import com.chess.Chess;
import com.chess.DualReflectorChess;
import com.chess.ReceiveChess;
import com.panel.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		Frame gf = new Frame();
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gf.setVisible(true);
	}
}

class Frame extends JFrame {

	Frame() {
		setTitle("Laser Maze");
		setSize(517, 540);
		setResizable(false);

		Container container = getContentPane();
		GamePanel gamePanel = new GamePanel();
		gamePanel.setBoard(Rounds.getInstance().rounds.get(15));
		Chess chess = new DualReflectorChess();
		chess.rotate();
		gamePanel.setSelectedChess(chess);
		container.add(gamePanel);
	}
}
