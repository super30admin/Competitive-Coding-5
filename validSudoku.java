//time complexity: O(m*n) where m is the number of rows and n is the number of columns
//space complexity : O(3*n) where n is the total number of digits present in the sudoku
//executed on leetcode: yes
//approach: we traverse through every element in sudoku, as soon as we hit a digit, we add entry into the hash set about the digit found and its rwo, column and box.
// when we enounter a duplicate, its entry corrsponding to row, column or box will be present in the hash set and set.add() will return false.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[0].length;++j)
            {   char current = board[i][j];
             if(current!='.')
             {
                 boolean row_check = seen.add(current+"found at row="+i);
                 boolean col_check = seen.add(current+"found at col="+j);
                 boolean box_check = seen.add(current+"found at box"+i/3+"-"+j/3);
                 if(!row_check||!col_check||!box_check) return false;
             }
            }
            
        }
        return true;
    }
}