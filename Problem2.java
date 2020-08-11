// Time Complexity : O(3*9*9) = O(3*81) = O(1)
//      Iterating matrix 3 times. Sudoku is 9x9
// Space Complexity : O(3*9) = O(1)
//      For row, col, block
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : how to iterate block in two loops


// Your code here along with comments explaining your approach
class Problem2 {

    /** find sudoku is valid */
    public boolean isValidSudoku(char[][] board) {
        
        // edge case
        if(board ==  null || board.length !=9 || board[0].length != 9)
            return false;
        
        // for rows
        for(int i=0; i< 9; i++){

            // digits should be from 1-9 we map it as 0-8
            boolean[] digits = new boolean[9];

            for(int j=0; j< 9; j++){
                char c = board[i][j];
                if(c!= '.'){
                    // index as in the digit
                    int index = Character.getNumericValue(c)-1;
                    if(!digits[index])
                        digits[index] = true;
                    else
                        return false;
                }
            }
        }
        // for cols
        for(int j=0; j< 9; j++){
            
            // digits should be from 1-9 we map it as 0-8
            boolean[] digits = new boolean[9];

            for(int i=0; i< 9; i++){
                char c = board[i][j];
                if(c!= '.'){
                     // index as in the digit
                    int index = Character.getNumericValue(c)-1;
                    if(!digits[index])
                        digits[index] = true;
                    else
                        return false;
                }
            }
        }
        // for block 
        for(int block=0; block<9; block++){
            
            boolean[] digits = new boolean[9];
            // rows of the block
            int i=block/3*3;
            
            // in range of 3
            while (i< block/3*3 + 3){

                // cols of the block
                int j=block%3*3;
                
                // in range of 3
                while(j< block%3*3 +3){
                    char c = board[i][j];
                    if(c!= '.'){
                        int index = Character.getNumericValue(c)-1;
                        if(!digits[index])
                            digits[index] = true;
                        else
                            return false;
                    }
                    j++;
                }
                i++;
            }
        }
        
        // if everthing is valid
        return true;  
    }
}