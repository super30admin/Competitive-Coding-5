package validSudoku;

import java.util.HashSet;

class Approach1 {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet();

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                char currentVal = board[i][j];

                if(currentVal != '.') {

                    if(!seen.add(currentVal + " found in row " + i)) {
                        return false;
                    }

                    if(!seen.add(currentVal + " found in column " + j)) {
                        return false;
                    }

                    if(!seen.add(currentVal + " found in rowsub bix " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
