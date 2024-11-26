// Time Complexity : O(1) for Approach 1,O(N^2) for Approach 2
// Space Complexity : O(1) for Approach 1,O(N) for Approach 2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Approach 1
We utilize hashing to count the occurences of numbers in each row,column and block.
A valid sudoku should have count of 1 for all numbers in each row,column and block.
If we found aboe rule to be violated then sudoku is not valid 
and we return false;

Approach 2
We will iterate over each row,column and block to mark numbers as visited
For this,we will take boolean array of size 9 to check numbers
We iterate over each row,column and block to mark number visited
During this,we found any visited numbers,we return the false and exit the progra,
*/


public class ValidSudoku {
    public boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
          rows[i] = new HashMap<Integer, Integer>();
          columns[i] = new HashMap<Integer, Integer>();
          boxes[i] = new HashMap<Integer, Integer>();
        }
    
        // validate a board
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            char num = board[i][j];
            if (num != '.') {
              int n = (int)num;
              int box_index = (i / 3 ) * 3 + j / 3;
    
              // keep the current cell value
              rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
              columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
              boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
    
              // check if this value has been already seen before
              if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                return false;
            }
          }
        }
    
        return true;
      }

    public boolean isValidSudoku2(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        for(int i =0; i < 9; i ++){
            boolean [] visited = new boolean[9];
            for(int j =0; j < 9; j++){
                if(board[i][j] != '.'){
                    int ch = (int)(board[i][j] - '1');
                    if(visited[ch]) 
                        return false;
                    visited[ch] = true;
                }
                
            }
        }

        for(int j =0; j < 9; j++){
            boolean []visited = new boolean[9];
            for(int i=0; i < 9; i++){
                if(board[i][j] != '.'){
                    int ch = (int)(board[i][j] - '1');
                    if(visited[ch]) return false;
                    visited[ch] = true;
                }
            }
        }

        for(int block = 1; block < 9; block++){
            boolean visited[] = new boolean[9];
            int istart = block / 3 * 3;
            int iend = block / 3 * 3 + 3;
            for(int i = istart; i < iend; i++){
                int jstart = block % 3 * 3;
                int jend = block % 3 * 3 + 3;
                for(int j = jstart; j < jend; j++){
                    if(board[i][j] != '.'){
                        int ch = (int)(board[i][j] - '1');
                        if(visited[ch]) 
                            return false;
                        visited[ch] = true;
                    }
                }
            }
        }
        return true;
    }
}