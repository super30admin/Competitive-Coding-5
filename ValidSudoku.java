// Time Complexity : O(n^2) where n=9
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {

    //HashSet approach to check duplicity of elements - unvalid sudoku
    //we need a hashset for every row, every column and every box

    public boolean isValidSudoku(char[][] board) {

        int n = 9;

        //arrays of hashets for all rows, columns and boxes
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        //create empty hashsets for all 9 rows, cols and boxes
        for(int i=0; i<n; i++)
        {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }

        //fill in the hashsets with values and keep checking for duplicates

        for(int r=0; r<n; r++)
        {
            for(int c=0; c<n; c++)
            {
                //current char
                char ch = board[r][c];

                //cell is empty
                if(ch == '.')
                    continue;

                //row checking

                //repetitiion found
                if(rows[r].contains(ch))
                    return false;

                //add to this row's hashset
                rows[r].add(ch);

                //column checking

                //repition found
                if(cols[c].contains(ch))
                    return false;

                //add to this column's hashset
                cols[c].add(ch);

                //box checking
                //each box can have an index 0-9, calculated by this formula
                int b = r/3 * 3 + c/3;
                //the cell located at (r, c) belongs to the box (r/3) * 3 + (c/3)
                // in each column, rows 0, 1, and 2 belong to the same box, as do rows 3, 4, and 5, and rows 6, 7, and 8
                //Every group of three belonging to the same box has the same outcome when we perform integer division by three. Therefore, we can use r/3 (/ signifies floor division) to ensure that the rows are grouped as expected and use c/3 to ensure that the columns are grouped correctly. Then, (r/3, c/3) can uniquely mark each box

                //repition found
                if(boxes[b].contains(ch))
                    return false;

                 //add to this box's hashset
                boxes[b].add(ch);
            }
        }

        //no false returned yet
        return true;
    }
}
