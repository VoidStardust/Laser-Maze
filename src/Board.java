
public class Board {
	Chess board[][];
	int level;
	int start[];
	int end[];
	final int dir[][]= {{-1,0},{0,-1},{0,1},{1,0}};
	public Board(int level) {
		board=new Chess[5][5];
		this.level=level;
		start=new int[2];
		end=new int[2];
		start[0]=-1;
		start[1]=-1;
		end[0]=-1;
		end[1]=-1;
	}
	public void setStart(int x,int y) {
		start[0]=x;
		start[1]=y;
	}
	public void setEnd(int x,int y) {
		end[0]=x;
		end[1]=y;
	}
	public void addChess(Chess chess,int x,int y) {
		board[x][y]=chess;
	}
	public void deleteChess(int x,int y) {
		board[x][y]=null;
	}
	public void solve(int x,int y) {
		if(true)//待实现
			return;
		for(int i=0;i<4;i++) {
			int newx=x+dir[i][0];
			int newy=y+dir[i][1];
			/*if(board[newx][newy] instanceof block)
			 * return;
			 * else if(board[newx][newy] instanceof reflector)
			 * newx=newx+dir[i+1][0];
			 * else
			 * solve(newx,newy);
			 * 
			 * 
			 */
		}
	}
	public void giveHint() {
		
	}
	public int getGrade() {
		return level*100;
	}
}
