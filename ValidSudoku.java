
// TC- O(9*9) SC-O()- it will be the size elements stored in hashset that will be less than 81

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
       HashSet<String> seen = new HashSet();
       for(int i = 0; i<9; i++){
           for(int j = 0; j<9; j++){
               char current_val = board[i][j];
               if(current_val != '.'){
                //The idea is to use the seen.add() method to add strings that describe these checks. If the number has already been added
                // (i.e., it exists in the row, column, or sub-box), add() returns false, which means the Sudoku is invalid.
                //If any of the seen.add() calls returns false, 
                //it means the value is duplicated in its row, column, or sub-box, so the method immediately returns false.
               if(!seen.add(current_val + "found in row" + i) 
               || !seen.add(current_val + "found in column" + j) 
               || !seen.add(current_val + "found in sub box" + i/3 + "-" + j/3)){
                   return false;
               }
                   } 
           }
       }
        return true;
    }
}