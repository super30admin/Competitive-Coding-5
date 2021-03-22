class ValidSudoku {
    
    // Time Complexity: O(1)
    // Space Complexity: O(n)   (where n -> no. of elements present in the given sodoku problem)
    
    public boolean isValidSudoku(char[][] board) {
        // Edge Case Checking
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        
        Set<String> set = new HashSet<>();
        // Traversing through the array and adding all the element strings - by row, column and box. If duplicate found then false else true 
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(!set.add(c + "row" + i) || !set.add(c + "col" + j) || !set.add(c + "box" + (i/3) + (j/3)) )
                        return false;
                }
            }
        }
        return true;
    }
}