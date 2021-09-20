// Time Complexity : O(1), Fixed number of rows and columns(9,9)
// Space Complexity : O(9) = O(1), Only a HashSet of fixed length 9 is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
//Using a HashSet approach
//Checking all rows
        SetCharacter nums = new HashSet();
        for(int i=0;i9;i++){
            for(int j = 0;j9;j++){
                if(board[i][j]=='.')continue;
                else if(!nums.contains(board[i][j]))nums.add(board[i][j]);
                else if(nums.contains(board[i][j]))return false;
            }
            nums = new HashSet();
        }
        nums = new HashSet();
//Checking all columns
        for(int i=0;i9;i++){
            for(int j = 0;j9;j++){
                if(board[j][i]=='.')continue;
                else if(!nums.contains(board[j][i]))nums.add(board[j][i]);
                else if(nums.contains(board[j][i]))return false;
            }
            nums = new HashSet();
        } 
//Checking square by square
        for(int square=0;square9;square++){
            nums = new HashSet();
            for(int i= square33;isquare33+3;i++){
                for(int j= square%33;jsquare%33+3;j++){
                    if(board[i][j]=='.')continue;
                    else if(!nums.contains(board[i][j]))nums.add(board[i][j]);
                    else if(nums.contains(board[i][j]))return false;
                }
            }
        }
        
        
        return true;
    }
}