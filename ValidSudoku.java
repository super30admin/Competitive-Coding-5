//Problem 70: Valid Sudoku
// If Matrix Size is considered constant
// Time Complexity : O(1)
// Space Complexity : O(1)

// If Matrix Size is not considered constant
// Time Complexity : O(M*N), M stands for rows, N stands for columns
// Space Complexity : O(3(M*N))=> O(M*N)


// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Use Set and store following in set. If Set add function returns false for any of the below condtions, just return false. It means it is not a valid sudoku.  
   1) Check whether number exists already in the row
   2) Check whether number exists already in the colum
   3) Check whether number exists already in the Block. Assign a block number for each block. As block size is 3X3, Thus divide rowIndex by 3 and colIndex By 3. Then all blocks will have unique identifier

   Eg: For Row - (O to 2) and Column (0 to 2) block number will be 0,0
       For Row - (O to 2) and Column (3 to 5) block number will be 0,1
       For Row - (O to 2) and Column (6 to 8) block number will be 0,2
       
       For Row - (3 to 5) and Column (0 to 2) block number will be 1,0
       For Row - (3 to 5) and Column (3 to 5) block number will be 1,1
       For Row - (3 to 5) and Column (6 to 8) block number will be 1,2

       For Row - (6 to 8) and Column (0 to 2) block number will be 2,0
       For Row - (6 to 8) and Column (3 to 5) block number will be 2,1
       For Row - (6 to 8) and Column (6 to 8) block number will be 2,2
 

*/


import java.util.*;
class Solution70 {
    
    public boolean isValidSudoku(char[][] board) {
        
        //1) If matrix size is constant : TC:O(1) || SC:O(1)
        //2) If matrix size is not constant : TC: O(M*N) | SC: O(3(M*N)), because storing row, column and block in set=> O(M*N)
        
        if(board==null || board.length==0) return false;
        
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j]!='.'){
                   if(!set.add(board[i][j]+" Found at Row "+i) 
                       || 
                      !set.add(board[i][j]+" Found at Col "+j) 
                       || 
                      !set.add(board[i][j]+" Found at Block row "+i/3+ " col "+j/3)
                     )
                      {
                     return false;  
                    } 
                }
                
            }
        }
        
        return true;
    }
}