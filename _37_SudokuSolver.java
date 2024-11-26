// Time Complexity : o(9^9^9)
// Space Complexity :  o(n*n) where n is 3
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach :  for every cell try all possible values from to 1 to 9, if the value doesn't work backtrack
class Solution {

    Set<String> set ;

    public void solveSudoku(char[][] board) {

        set = new HashSet<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                String row = "r" + i + board[i][j];
                String column = "c" + j + board[i][j];
                String box = "b" + getBoxId(i,j) + board[i][j];

                if(board[i][j] == '.') continue;

                set.add(row);
                set.add(column);
                set.add(box);
            }
        }

        dfs(board, 0, 0);

        }

    public boolean dfs(char[][] board, int i, int j){

      if(j >= board[0].length) {
          i = i+1;
          j = 0;
      }

      if(i >= board.length) return true;

      if(board[i][j] == '.'){

          for( int k = 1; k <= 9; k++){

            String row = "r" + i + k;
            String column = "c" + j + k;
            String box = "b" + getBoxId(i,j) + k;

            if(set.contains(row) || set.contains(column) || set.contains(box)) continue;

            set.add(row);
            set.add(column);
            set.add(box);
            board[i][j] = (char)(k+'0');

            boolean result  = dfs(board, i, j+1);
            if(result) return true;

            board[i][j] = '.';
            set.remove(row);
            set.remove(column);
            set.remove(box);
          }
        }
        else{
            boolean result  = dfs(board, i, j+1);
            if(result) return true;
        }

        return false;
    }


    public int getBoxId(int i , int j){
        return 3*(i/3) + j/3;
    }

}
