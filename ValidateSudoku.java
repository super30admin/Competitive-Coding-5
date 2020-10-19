// Time Complexity : O(n^2), to validate all items in rows, columns, 3x3 squares 
// Space Complexity : O(n), for the hashset space we need each time
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// this would be a bruteforce approach where I check if all rows are valid, all columns are valid, all 3x3 squares are valid
// rows/columns/3x3 squares are valid if unique element set size() is equal to all non '.' elements  

class Solution {
    private boolean isRowValid(int r, char[][] board){
        HashSet<Character> set = new HashSet<Character>();
        
        int nonZeroItemCount = 0;
        for(int i=0; i<board[0].length; i++){
            if(board[r][i]!='.'){
                nonZeroItemCount++;
                set.add(board[r][i]);
            }
        }
        
        return set.size()==nonZeroItemCount;
    }
    
    private boolean isColumnValid(int c, char[][] board){
        HashSet<Character> set = new HashSet<Character>();
        
        int nonZeroItemCount = 0;
        for(int i=0; i<board.length; i++){
            if(board[i][c]!='.'){
                nonZeroItemCount++;
                set.add(board[i][c]);
            }
        }
        
        return set.size()==nonZeroItemCount;
    }
    
    private boolean isSubBoxValid(int n, char[][] board){
        HashSet<Character> set = new HashSet<Character>();
        
        int nonZeroItemCount = 0;
        int r_idx = (n-1)/3;
        int c_idx = (n-1)%3;
        
        for(int i=3*r_idx; i<3*r_idx + 3; i++){
            for(int j=3*c_idx; j<3*c_idx + 3; j++){
                if(board[i][j]!='.'){
                    nonZeroItemCount++;
                    set.add(board[i][j]);                        
                }
            }
        }
        
        return set.size()==nonZeroItemCount;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<board.length; i++){
            if(!isRowValid(i, board)) return false;
        }
        
        for(int i=0; i<board[0].length; i++){
            if(!isColumnValid(i, board)) return false;
        }
        
        for(int i=1; i<=9; i++){
            if(!isSubBoxValid(i, board)) return false;
        }
        
        return true;
    }
}