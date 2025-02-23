// https://leetcode.com/problems/valid-sudoku/

// Time Complexity : O(m x n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, validation is done row wise, col wise and sub matrix of size 3x3 wise. While iterating create a boolean array to keep
 * track of elements and if an element is already visited return false else continue.
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i< board.length; i++){
            boolean []row = new boolean[9];
            boolean []col = new boolean[9];
            for(int j = 0; j< board[0].length;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    if(row[num]){
                        return false;
                    }
                    row[num] = true;
                }

                if(board[j][i]!='.'){
                    int num = board[j][i] - '1';
                    if(col[num]){
                        return false;
                    }
                    col[num] = true;
                }
            }
        }
        for(int i = 0; i < 3;i++){
            for(int j = 0; j<3;j++){
                boolean[] box = new boolean[9];
                for(int k = 0; k<3;k++){
                    for(int l = 0; l<3;l++){
                        int cr = i * 3 + k;
                        int cc = j * 3 + l;
                        if(board[cr][cc]!='.'){
                            int num = board[cr][cc] - '1';
                            if(box[num]){
                                return false;
                            }
                            box[num] = true;
                        }
                        
                    }
                }
            }
        }
    
        return true;
    }
}