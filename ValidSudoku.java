import java.util.HashSet;

/*
Time Complexity: O(N*N) -> N is the number of rows and cols
Space Complexity: O(N*N)-> N is the size of HashSet
Run on leetcode: yes

Approach:
1. As I know to have a valid sudoku, every row, col and every 3*3 box should have unique values
2. To preserve unique-ness I am taking Array of Hashset in order to add only unique characters
3. Once the data structure is made I am gonna iterate over the given sudoku board and whenever I am gonna encounter a
numeric character I am gonna first convert that in to Integer and then I will look for that character in the HashSet, if
that exists in the rows or cols or in the 3*3 box by the boxIndex and if that exists then we return false else it is a valid
sudoku
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        HashSet<Integer>[]rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for(int i = 0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char num = board[i][j];
                if(num!='.'){
                    int n = (int) num;
                    int boxIndex = (i/3)*3+j/3;

                    if((!rows[i].add(n) ) || (!cols[j].add(n)) || (!boxes[boxIndex].add(n))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Valid Sudoku: "+ isValidSudoku(board));
    }
}
