//Time Complexity: O(M * N) but here M and N are equal to 9 where M and N is length of row and column respectively
//Space Complexity: O(M * N) for hashset space

//Successfully runs on leetcode: 16 ms

//Approach: Here we are making use of a hashset that will uniquely store an element with its row, column and inner box
//and if the element is encountered again in the hashset, we will return false as that cannot be a valid sudoku.


class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length!=9 || board[0].length != 9) return false;
        Set<String> set = new HashSet<>();
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char val = board[row][col];
                if (val != '.') {
                    if (set.contains("r" + row + val) || 
                        set.contains("c" + col + val) ||
                        set.contains("b" + row/3 + col/3 + val))
                        return false;
                    else {
                        set.add("r" + row + val);
                        set.add("c" + col + val);
                        set.add("b" + row/3 + col/3 + val);
                    }   
                }
            }
        }
        
        return true;
    }
}