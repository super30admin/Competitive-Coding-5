/*
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None or len(board) != 9 or len(board[0]) != 9:
            return False
        
        
        
        #row
        for i in range(9):
            b = [False]*9
            for j in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j]) - 1]:
                        return False
                    
                    b[int(board[i][j]) - 1] = True
        
        #column
        for j in range(9):
            b = [False]*9
            for i in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j]) - 1]:
                        return False
                    
                    b[int(board[i][j]) - 1] = True
        
        #board
        for k in range(9):
            b = [False]*9
            for i in range((k//3)*3, (k//3)*3 + 3):
                for j in range((k%3)*3, (k%3)*3 + 3):
                    if board[i][j] != '.':
                        if b[int(board[i][j]) - 1]:
                            return False
                    
                        b[int(board[i][j]) - 1] = True
        return True
*/

// Time Complexity : O(9) it means its constant
// Space Complexity : O(9) for boolean and its constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: i checked for every row and then column and then for individual boxes
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9)
            return false;
        
        for (int i=0; i<9; i++){
            boolean[] b = new boolean[9];
            for (int j=0; j<9; j++){
                if (board[i][j] != '.'){
                    
                    if (b[(int)board[i][j] - '1'])
                        return false;
                    b[(int)board[i][j] - '1'] = true;
                }
            }
        }
        
        for (int j=0; j<9; j++){
            boolean[] b = new boolean[9];
            for (int i=0; i<9; i++){
                if (board[i][j] != '.'){
                    if (b[(int)board[i][j] - '1'])
                        return false;
                    b[(int)board[i][j] - '1'] = true;
                }
            }
        }
        
        for (int k=0; k<9; k++){
            boolean[] b = new boolean[9];
            for (int i=(k/3)*3; i<(k/3)*3+3; i++){
                for (int j=(k%3)*3; j<(k%3)*3+3; j++){
                    if (board[i][j] != '.'){
                        if (b[(int)board[i][j] - '1'])
                            return false;
                        b[(int)board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}