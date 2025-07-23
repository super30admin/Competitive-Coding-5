// Time Complexity : O(1) (n is 9 here so constant for this type of matrix)
// Space Complexity : O(1) (n is 9 here so constant for this type of matrix)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I make 3 checks for duplicates using a hashset - first the rows, then column and then the boxes. Rows and columns are straightforward, for boxes I move the index by 3 to get the top left point of the box and then iterate as the size of any box is 3x3.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for rows
        for(int i = 0; i<9; i++){
            HashSet<Character> setRows = new HashSet<>();
            for(int j = 0; j<9; j++){
                if(board[i][j] =='.') continue;
                if(setRows.contains(board[i][j])) return false;
                setRows.add(board[i][j]);
            }
        }

        // check for columns
        for(int j = 0; j<9; j++){
            HashSet<Character> setCols = new HashSet<>();
            for(int i = 0; i<9; i++){
                if(board[i][j] =='.') continue;
                if(setCols.contains(board[i][j])) return false;
                setCols.add(board[i][j]);
            }
        }

        // check for the boxes
        for(int i = 0; i<9; i+=3){
            for(int j = 0; j<9; j+=3){
                HashSet<Character> setBoxes = new HashSet<>();
                for(int i1 = i; i1<i+3; i1++){
                    for(int j1 = j; j1<j+3; j1++){
                        if(board[i1][j1] =='.') continue;
                        if(setBoxes.contains(board[i1][j1])) return false;
                        setBoxes.add(board[i1][j1]);
                    }
                }
            }
        }
        return true;
    }
}