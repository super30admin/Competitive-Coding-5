// Time Complexity :9(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes but one test case doesnt pass
// Any problem you faced while coding this :yess. I am not able to find the issue with my code


// Your code here along with comments explaining your approach: backTracking

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }    

    public boolean solve(char[][] board){    
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1'; c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                        
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i<9;i++){
            if(board[row][i]==c || board[i][col]==c){
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;    
    }   
}