// Time Complexity : O(3N^2) == O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Brute force approach to check all the rows, cols and blocks of 3X3 for breach.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValid(board);
    }
    
    private boolean isValid(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        Set<Character> hashSet = new HashSet<>();
        
        // Validate all the rows
        for (int i=0;i<m;i++) {
            
            for (int j=0;j<n;j++) {
                char ch = board[i][j];
                
                if (ch != '.') {
                    if (hashSet.contains(ch)) {
                        return false;
                    } else {
                        hashSet.add(ch);
                    }
                }
            }
            
            hashSet.clear();
        }
        
        // Validate all the cols
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                char ch = board[j][i];
                
                if (ch != '.') {
                    if (hashSet.contains(ch)) {
                        return false;
                    } else {
                        hashSet.add(ch);
                    }
                }
            }
            
            hashSet.clear();
        }
        
        // Validate all the 3X3 blocks
        
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (!isValidBlocks(board, i*3, j*3, i*3 + 3, j*3 + 3)) return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidBlocks(char[][] board, int i, int j, int x_bound, int y_bound) {
        
        Set<Character> hashSet = new HashSet<>();
        
        for (int a=i;a<x_bound;a++) {
            for (int b=j;b<y_bound;b++) {
                
                char ch = board[a][b];
                
                if (ch != '.') {
                    if (hashSet.contains(ch)) {
                        return false;
                    } else {
                        hashSet.add(ch);
                    }
                }
            }
        }
        
        return true;
    }
}