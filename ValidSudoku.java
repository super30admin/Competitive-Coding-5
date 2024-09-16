// Time Complexity : O(n*m) where n is the # of rows, m is the # of cols in the input matrix
// Space Complexity : O(n*m) Hashmap used for finding the redundant characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Using direct matrix traversal and hashing technique
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] cols = new HashMap[9];
        HashMap<Integer,Integer>[] boxes = new HashMap[9];
        
        for(int x=0;x<9;x++){
            rows[x] = new HashMap<Integer,Integer>();
            cols[x] = new HashMap<Integer,Integer>();
            boxes[x] = new HashMap<Integer,Integer>();
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    int n = (int)board[i][j];
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    int k = (i/3)*3+j/3;
                    boxes[k].put(n,boxes[k].getOrDefault(n,0)+1);
                    if(rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[k].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
