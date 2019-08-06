package competitveCoding5;

// TC: O(m*n) where m and n are number of rows and columns respectively.
// SC: O(m*n) where m and n are number of rows and columns respectively in hashset.

import java.util.HashSet;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {

        // int[] dr = new int[]{0, 3, 6};
        // int[] dc = new int[]{0, 3, 6};
              return  validRow (board) && validColumn(board) && validBox(board);
           }     
        
	public static boolean validRow(char[][] board) {
            HashSet<Character> hs;
            for(int i= 0; i < board.length; i++) {
                hs = new HashSet<>();
            for(int j = 0; j < board[0].length; j++) {
            if(board[i][j] == '.') continue;
                
                if(hs.contains(board[i][j])) return false;
                hs.add(board[i][j]);
                
            }
                
            }
            return true;
        }
        
	public static boolean validColumn(char[][] board) {
            HashSet<Character> hs;
            for(int j = 0; j < board[0].length; j++) {
                hs = new HashSet<>();
            for(int i= 0; i < board.length; i++) {
            if(board[i][j] == '.') continue;
                
                if(hs.contains(board[i][j])) return false;
                hs.add(board[i][j]);
                
            }
                
            }
            return true;
        }
    
	public static boolean validBox(char[][] board) {
        HashSet<Character> hs;
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                hs = new HashSet();
                    for (int i = x; i < x + 3; i++) {
                        for (int j = y; j < y + 3; j++) {
        if(!hs.add(board[i][j]) && board[i][j] != '.') return false;
                                                        }
                                                    }
                                            }
                                        }
            return true;
        }  
    
    public static void main(String[] args) {
    	char[][] board = {  {'.','.','.','.','5','.','.','1','.'},
    						{'.','4','.','3','.','.','.','.','.'},
    						{'.','.','.','.','.','3','.','.','1'},
    						{'8','.','.','.','.','.','.','2','.'},
    						{'.','.','2','.','7','.','.','.','.'},
    						{'.','1','5','.','.','.','.','.','.'},
    						{'.','.','.','.','.','2','.','.','.'},
    						{'.','2','.','9','.','.','.','.','.'},
    						{'.','.','4','.','.','.','.','.','.'}  };
    			
    			System.out.println(isValidSudoku(board));
    }
}
