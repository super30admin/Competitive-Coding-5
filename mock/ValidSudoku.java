
import java.util.HashSet;

class Solution {
    HashSet<Character> set;
    public boolean isValidSudoku(char[][] board) {
        set = new HashSet<>();
        //validate rows
        for(int i=0;i<9;i++) {
        	set = new HashSet<>();
           for(int j=0;j<9;j++){
        	   System.out.println(i+" "+j+" "+board[i][j]);
        	   if(board[i][j]=='.') continue;
               if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
           }
        }
        set = new HashSet<>();
        //validate columns
        for(int i=0;i<9;i++) {
        	set = new HashSet<>();
           for(int j=0;j<9;j++){
        	   System.out.println(i+" "+j+" "+board[i][j]);
        	   if(board[j][i]=='.') continue;
               if(set.contains(board[j][i]))
                    return false;
                set.add(board[j][i]);
           }
        }
        //validate grid
        for(int i=0;i<3;i++){               //0                       1                       2
           for(int j=0;j<3;j++){            //0 1        2    3     0       1       2       
        	   boolean flag = validateGrid(board,i*3,j*3);    //0,0  0, 3   0,6         3,0     3,3     3,6
        	   if(flag==false) return false;
           }
        }
        return true;
    }
    public boolean validateGrid(char[][] board, int start, int end){
        set = new HashSet<>();
        for(int i=start;i<start+3;i++) {
           for(int j=end;j<end+3;j++){
        	   if(board[i][j]=='.') continue;
               if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
           }
        }
        return true;
    }
}
public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = 
			{{'5','3','.','.','7','.','.','.','.'}
			,{'6','.','.','1','9','5','.','.','.'}
			,{'.','9','8','.','.','.','.','6','.'}
			,{'8','.','.','.','6','.','.','.','3'}
			,{'4','.','.','8','.','3','.','.','1'}
			,{'7','.','.','.','2','.','.','.','6'}
			,{'.','6','.','.','.','.','2','8','.'}
			,{'.','.','.','4','1','9','.','.','5'}
			,{'.','.','.','.','8','.','.','7','9'}};
		Solution s = new Solution();
		System.out.println(s.isValidSudoku(board));
	}

}
