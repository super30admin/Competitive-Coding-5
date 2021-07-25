// Time Complexity : o(n2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if(board==null|| board.length==0)
            return true;
        
        int m=board.length;
        int n=board[0].length;
        
        // for row
        for(int i=0;i<m;i++)
        {
            HashSet<Character> c=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(board[j][i]!='.')
                {
                    if(!c.contains(board[j][i]))
                        c.add(board[j][i]);
                    else
                        return false;
                }
            }
        }
        
        // for column
        for(int i=0;i<m;i++)
        {
            HashSet<Character> c=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!c.contains(board[i][j]))
                        c.add(board[i][j]);
                    else
                        return false;
                }
            }
        }
        
        // for 3*3 
         
         for(int i = 0; i < 9; i= i + 3) {
            for(int j = 0; j < 9; j = j + 3) {
                HashSet<Character> c = new HashSet<>();
                for(int x = i; x < i + 3; x++) {
                    for(int y = j; y < j + 3; y++) {
	  //mat is the name of the sudoku matrix
                char currchar = board[x][y];
	    //when current cell in sudoku is not "." empty
                if(currchar != '.') {
            //check if hashset already contains currchar, return false if it
	 //is already intialized in set
	     if (c.contains(currchar))
                    return false;
                    //else add it to set
                    c.add(currchar);
                    }
                }
            }
        }
    }
        return true;
    }
}
