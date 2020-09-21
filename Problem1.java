//Time :(m*n)
//Space :O(1)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
//- first check row and use boolean array of row size to check if we have seen that number in sudoku or not
//then column use boolean array of row size to check if we have seen that number in sudoku or not
// then block  use boolean array of row size to check if we have seen that number in sudoku or not

public class Problem1 {
	
	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        
	        if(board==null || board.length!=9 || board[0].length!=9)
	            return false;
	        
	        
	        for(int i=0;i<9;i++){
	            boolean[] b = new boolean[9];
	            for(int j=0;j<9;j++){
	                if(board[i][j]!='.'){
	                if(b[(int)board[i][j]-'1']) return false;
	                b[(int)board[i][j]-'1']=true;
	                }
	            }
	        }
	        
	         
	        for(int j=0;j<9;j++){
	            boolean[] b = new boolean[9];
	            
	            for(int i=0;i<9;i++){
	                 if(board[i][j]!='.'){
	                if(b[(int)board[i][j]-'1']) return false;
	                b[(int)board[i][j]-'1']=true;
	            }
	            }
	        }
	        
	        for(int block=0;block<9;block++){
	              boolean[] b = new boolean[9];
	         for(int i=block/3*3;i<block/3*3+3;i++){
	          
	            for(int j=block%3*3;j<block%3*3+3;j++){
	                if(board[i][j]!='.'){
	                if(b[(int)board[i][j]-'1']) return false;
	                b[(int)board[i][j]-'1']=true;
	                }
	            }
	        }
	        
	        }
	        
	         return true;
	        } 
	       
	    }


}
