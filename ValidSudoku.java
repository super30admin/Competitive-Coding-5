// Time Complexity : O(n^2) n is the size of side of the square
// Space Complexity : O(n) for set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Traverse all the rows, columns and squares
// In each case put elements in HashSet
// If the element is already present in HashSet, it means we have duplicate 
// We will return false in such cases. At the end return true.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++){
            Set<Character> hsCol = new HashSet<>();
            Set<Character> hsRow = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(hsCol.contains(board[i][j]) || hsRow.contains(board[j][i]))
                    return false;
                if(board[i][j] != '.')
                    hsCol.add(board[i][j]);
                if(board[j][i] != '.')
                    hsRow.add(board[j][i]);
            }
        }
        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                Set<Character> hsSq = new HashSet<>();
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        //i+k, j+l
                        if(hsSq.contains(board[i+k][j+l]))
                            return false;
                        if(board[i+k][j+l] != '.')
                            hsSq.add(board[i+k][j+l]);
                    }
                }
            }
        }
        
        return true;
    }
}