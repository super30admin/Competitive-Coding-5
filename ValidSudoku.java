public class ValidSudoku {



        public boolean isValidSudoku(char[][] board) {

            // null case
            if(board == null || board.length != 9 || board[0].length != 9) return true;

            //row and column check  = O(m*n) = O(9*9) = O(1)

            for(int s = 0; s < 9; s++) {

                boolean[] currRow = new boolean[9]; // O(9*9)
                boolean[] currCol = new boolean[9]; // O(9*9)

                for(int t = 0; t < 9; t++) {

                    char c = board[s][t];
                    char d = board[t][s];

                    if(c != '.') {

                        if(currRow[c - '1']) return false;

                        currRow[c - '1'] = true;
                    }

                    if(d != '.') {

                        if(currCol[d - '1']) return false;

                        currCol[d - '1'] = true;
                    }
                }
            }

            //sub-box = O(m*n) = O(9*3*3) = O(1)
            for(int b = 0; b < 9; b++) {

                boolean[] subBox = new boolean[9]; //O(9*9)

                int r = b/3*3;
                int c = b%3*3;

                for(int i = r; i < r+3; i++) {

                    for(int j = c; j < c+3; j++) {

                        char e = board[i][j];

                        if(e != '.') {

                            if(subBox[e - '1']) return false;

                            subBox[e - '1'] = true;
                        }
                    }
                }
            }
            return true;
        }


}

/*
Time Complexity = O(1) as in O(m*n) m = n = 9 is constant always
Space Complexity = O(1) as in O(m*n) m = n = 9 is constant always
*/