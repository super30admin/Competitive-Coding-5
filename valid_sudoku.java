//Time Complexity: O(n ^ 2) = O(81) = constant O(1)
//Space Complexity: O(n ^ 2) = O(81) = constant O(1)
//Approach
//We use Hashing technique to search if the element is already existing in that particular row or column or the box set
//The search of O(1) makes it optimal appproach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i =0; i<9;i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> boxSet = new HashSet<>();
            for(int j=0;j<9;j++) {
                
                if(board[i][j] != '.' && rowSet.contains(board[i][j])) return false;
                rowSet.add(board[i][j]);

                if(board[j][i] != '.' && colSet.contains(board[j][i])) return false;
                colSet.add(board[j][i]);

                int r = 3 * (i / 3) + j / 3;
                int c = 3 * (i % 3) + j % 3;
                if(board[r][c] != '.' && boxSet.contains(board[r][c])) return false;
                boxSet.add(board[r][c]);
            }
        }

        return true;
    }
}
