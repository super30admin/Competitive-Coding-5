// Time Complexity : O(1) - as it is a fixed size matrix
// Space Complexity : O(1) - as it is a fixed size 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
    
        HashSet<String> hmap = new HashSet<>();
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                String s1 = "",s2 = "",s3 = "";
                s1 = board[i][j] + "r" + Integer.toString(i);
                s2 = board[i][j] + "c" + Integer.toString(j);
                s3 =  board[i][j] + Integer.toString(i/ 3) + Integer.toString(j/ 3);
                if(board[i][j] != '.' && (hmap.contains(s1) || hmap.contains(s2) || hmap.contains(s3))){
                    return false;
                }
                hmap.add(s1);
                hmap.add(s2);
                hmap.add(s3);
            }
        }
        return true;
    }
}
// Your code here along with comments explaining your approach