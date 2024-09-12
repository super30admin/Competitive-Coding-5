// Time Complexity : O(m * n) where m & n are lengths of board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (36): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m ; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                char temp;
                if (board[i][j] != '.') {
                    temp = board[i][j];
                    if (!set.contains(temp)) {
                        set.add(temp);
                    }
                    else return false;
                } 
            }
        } 
        
        for (int j = 0; j < n ; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                char temp;
                if (board[i][j] != '.') {
                    temp = board[i][j];
                    if (!set.contains(temp)) {
                        set.add(temp);
                    }
                    else return false;
                } 
            }
        } 
        
        for (int block = 0; block < 9; block++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = block / 3 * 3; i < block/3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    char temp;
                    if (board[i][j] != '.') {
                        temp = board[i][j];
                        if (!set.contains(temp)) {
                            set.add(temp);
                        }
                        else return false;
                    }
                }
            }
        }
        return true;
    }
}