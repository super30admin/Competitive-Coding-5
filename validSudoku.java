// Time Complexity : O(1)
// Space Complexity : O(1) //running only 9 (constant) times 
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length !=9)
        return false;

        HashSet<Character> set = new HashSet<> ();

        //row
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(set.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else
                    set.add(board[i][j]);
            }
        }

        //column
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(set.contains(board[j][i]) && board[j][i] != '.')
                    return false;
                else
                    set.add(board[j][i]);
            }
        }

        //block
        for(int block = 0; block < 9; block++){
        set.clear();
        for(int i = block/3*3; i < block/3*3 + 3; i++){
            for(int j = block%3*3; j < block%3*3 + 3; j++){
                if(set.contains(board[j][i]) && board[j][i] != '.')
                    return false;
                else
                    set.add(board[j][i]);
            }
        }
    }
        return true;
    }
}