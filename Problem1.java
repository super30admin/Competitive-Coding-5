





// Time - O(M*N)
// Space - O(M*N)


class Solution {
    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        HashSet seen = new HashSet();

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++)  {

                char c = board[i][j];

                if(c != '.') {

                    // if its there in hashset return false
                    if( !seen.add( c + " in row " + i) || !seen.add( c + " in column " + j) || !seen.add( c + " in block " + i/3 + j/3))
                        return false;


                }


            }

        }

        return true;

    }
}