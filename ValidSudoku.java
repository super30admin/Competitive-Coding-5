//Time Complexity - O(N) - number of chars in the board .
//Space Complexity - O(3N) - O(N) - for the three sets , (worst case all integers and no dots in the board)


//In case , sudo is always going to be 9x9 - then O(1) constant for both time and space complexity


//Approach - One pass solution

class Solution {
  public boolean isValidSudoku(char[][] board) {


    Set<Character> rows = new HashSet<>();
    Set<Character> cols = new HashSet<>();
    Set<Character> squares = new HashSet<>();

    for(int i=0; i<board.length; i++){
      for(int j=0; j<board[0].length; j++){

        int r = (i/3)*3+(j/3);
        int c = (i%3)*3+(j%3);

        if(board[i][j] != '.' && rows.contains(board[i][j]) ||
            board[j][i] != '.' && cols.contains(board[j][i])||
            board[r][c] != '.' && squares.contains(board[r][c])){
          return false;
        }
        else{
          rows.add(board[i][j]);
          cols.add(board[j][i]);
          squares.add(board[r][c]);
        }

      }

      rows.clear();
      cols.clear();
      squares.clear();
    }
    return true;
  }
}


