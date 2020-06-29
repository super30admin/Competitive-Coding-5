// Time Complexity : O(mn) = O(81) = O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We use HashSet to add the value and it's row/col/row & col so that whenever we come across another same number in that 
// particular row/col/row & col, the HashSet returns false if we try to add it again. 

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] == '.') continue;
                if(!set.add("r"+i+board[i][j]) || !set.add("c"+j+board[i][j]) || !set.add("b"+i/3+j/3+board[i][j])) return false;
                
            }
        }
        return true;
    }
}