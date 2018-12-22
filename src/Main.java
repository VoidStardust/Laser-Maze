import com.board.Board;
import com.board.GameFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
	}
}

class Frame extends JFrame {

	Frame() {
		setTitle("Simple Count Frame");
		setSize(400, 300);

		Container container = getContentPane();
	}
}

class Panel extends JPanel {

	//Board board();

	Panel() {

	}
}
