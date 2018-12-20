import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private Board board;
	int grade;
	public GameFrame() {
		grade=0;
		board=Rounds.getInstance().rounds.get(0);
	}
	private void gainGrade() {
		grade+=board.giveGrade();
	}
	public void changeRound(int roundNum) {
		board=Rounds.getInstance().rounds.get(roundNum);
	}
	public void giveHint() {
		minusGrade();
		board.giveHint();
	}
	public void giveSolution() {
		board.giveSolution();
	}
	public void check() {
		if(board.isCorrect()) {
			gainGrade();
			//对话框弹出
		}
		else {
			//implement by lsc
			//对话框弹出
		}
	}
	public void withdraw() {
		board.withdraw();
	}
	private void minusGrade() {
		grade-=10;//每点击一次提示-10分
	}
}
