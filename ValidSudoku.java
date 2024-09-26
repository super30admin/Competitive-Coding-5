import java.util.HashSet;

/*
https://leetcode.com/problems/valid-sudoku/

Time Complexity :   O (N^2) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (36. Valid Sudoku)
Any problem you faced while coding this :       No

 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet seen = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    // check for row or column duplicate
                    if(!seen.add("row"+i+board[i][j]) || !seen.add("col"+j+board[i][j])){
                        return false;
                    }
                    // check for box duplicate
                    int boxIndex = (i/3)*3+(j/3);
                    if(!seen.add("box"+boxIndex+board[i][j])){
                        return false;
                    }
                } 
            }
        }
        return true;
    }
}