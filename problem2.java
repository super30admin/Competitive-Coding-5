// Problem2- https://leetcode.com/problems/valid-sudoku/

// Time Complexity : O(1) //As m & n are fixed
// Space Complexity : O(1) //As m & n are fixed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem2 {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char number = board[i][j];
                
                if(number != '.'){
                    String str1 = number + " in row " + i;
                    String str2 = number + " in column " + j;
                    String str3 = number + " in block " + i/3 + "-" + j/3;
                    
                    if(set.contains(str1) || set.contains(str2) || set.contains(str3)){
                        return false;
                    }else{
                        set.add(str1);
                        set.add(str2);
                        set.add(str3);
                    }
                    
                }
            }
        }
        
        return true;
        
    }
}
