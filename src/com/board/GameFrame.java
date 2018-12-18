import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private Board board;
	int grade;
	public GameFrame() {
		grade=0;
	}
	public void gainGrade() {
		grade+=board.getGrade();
	}
	public void minusGrade() {
		grade-=10;//每点击一次提示-10分
	}
	void drawLine() {
		
	}
}
