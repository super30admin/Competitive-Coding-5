// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char num = board[i][j];
                if(num!='.'){
                    if(!set.add(num+"row"+i) || 
                       !set.add(num+"col"+j) ||
                      !set.add(num+"box"+i/3+"-"+j/3)){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}