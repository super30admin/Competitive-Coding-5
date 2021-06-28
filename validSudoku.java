// Time Complexity : O(N*M)
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Iterate the array and store the values in Hashtable.
2. If the numbers repeat then return false else return true
*/


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, String> row = new HashMap<Integer, String>(); 
        HashMap<Integer, String> col = new HashMap<Integer, String>(); 
        HashMap<Integer, String> box = new HashMap<Integer, String>(); 
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    if(row.containsKey(i)) {
                        if(row.get(i).indexOf(board[i][j]) != -1) return false;
                        else row.put(i, row.get(i)+board[i][j]);
                    } else {
                        row.put(i, Character.toString(board[i][j]));
                    } 
                    
                    if(col.containsKey(j)) {
                        if(col.get(j).indexOf(board[i][j]) != -1) return false;
                        else col.put(j, col.get(j)+board[i][j]);
                    } else {
                        col.put(j, Character.toString(board[i][j]));
                    }
                    
                    int boxNumber = (3*(i/3)) + j/3;
                    if(box.containsKey(boxNumber)) {
                        if(box.get(boxNumber).indexOf(board[i][j]) != -1) return false;
                        else box.put(boxNumber, box.get(boxNumber)+board[i][j]);
                    } else {
                        box.put(boxNumber, Character.toString(board[i][j]));
                    }
                }
            }
        }
        return true;
    }
}
