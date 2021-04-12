//tc : O(m * n)
//sc : O(1); bcz set will have 9 values max
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character> cube = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if(i!=0){
                row.clear();
                col.clear();
                cube.clear();
            }

            for (int j = 0; j < board[0].length; j++){

                char c = board[i][j];
                char d = board[j][i];

                if(d!='.'){
                    if(col.contains(d))
                        return false;

                    col.add(d);
                }
                if(c!='.'){
                    if(row.contains(c))
                        return false;

                    row.add(c);
                }
                int rowInd_cube = 3 * (i/3);
                int colInd_cube = 3 * (i%3);
                char x = board[rowInd_cube + j/3][colInd_cube + j%3];
                if (x!='.'){
                    if(cube.contains(x))
                        return false;
                    cube.add(x);
                }
            }

        }

        return true;
    }
}