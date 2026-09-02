// constant time complexity since max iteration for 81 times is O(1)
// space complexity is constant O(1)

//using hashset for evry index of array for row ,col and box
//Valid Sudoku


class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
         HashSet<Character>[] col = new HashSet[9];
         HashSet<Character>[] box = new HashSet[9];
         int m = board.length;
         int n = board[0].length;

         for(int i = 0; i< 9 ; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();

         }

         for(int i = 0; i< m; i++){
            for (int j = 0; j< n ; j++){
                int boxIndex = (i/3) * 3 + (j/3);
                if(board[i][j] != '.'){
                    if(row[i].contains(board[i][j]) || col[j].contains(board[i][j]) ||  box[boxIndex].contains(board[i][j])){
                        return false;
                    }
                    else {
                        row[i].add(board[i][j]);
                        col[j].add(board[i][j]);
                        box[boxIndex].add(board[i][j]);
                    }
                }
                   
            }
         }
         return true;
        
    }
}
