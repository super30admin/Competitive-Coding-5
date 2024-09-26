// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Time Complexity : O(n*n)
// Space Complexity : O(l)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

import java.util.HashSet;

public class validSudoku{

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> sSet= new HashSet<>();
        
        if(board==null || board.length==0 || board[0].length==0)
            return false;

        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]!='.'){

                    if(!sSet.add("row"+i+board[i][j]) || !sSet.add("col"+j+board[i][j]))
                        return false;

                    if(!sSet.add("box"+(i/3)*3+j/3+board[i][j]))
                        return false;
                }
            }
        }
            return true;
        
    
            
    }

}