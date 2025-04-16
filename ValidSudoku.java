// Time Complexity : O(n^2),
// Space Complexity : O(n), where n is 9
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach :
// Traverse each 3x3 subgrid, row, and column, using hashmaps to track digits seen.
// If any digit is repeated within a row, column, or subgrid, return false.
// Reset the hashmaps after checking each 3x3 subgrid to avoid interference.
// If no violations are found in any row, column, or subgrid, return true.
// Otherwise, return false when a repeated digit is detected.


import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) 
    {
        HashMap<Character, Integer> setc = new HashMap<>();
        setc.put('1',0);
        setc.put('2',0);
        setc.put('3',0);
        setc.put('4',0);
        setc.put('5',0);
        setc.put('6',0);
        setc.put('7',0);
        setc.put('8',0);
        setc.put('9',0);
        int count = 0;
        for (int row = 0; row < board.length - 2; row += 3) 
        {
            for (int col = 0; col < board[row].length - 2; col += 3) 
            {
                for (int i = row; i < row + 3; i++) 
                {
                    for (int j = col; j < col + 3; j++) 
                    {
                        if(board[i][j] != '.')
                        {
                            char rowss = board[i][j];
                            int countt = setc.get(rowss);
                            if(countt == 1)
                            {
                                return false;
                            }
                            else
                            {   
                                setc.put(rowss,1);
                            }
                        }
                    }
                }
                setc = new HashMap<>();
                setc.put('1',0);
                setc.put('2',0);
                setc.put('3',0);
                setc.put('4',0);
                setc.put('5',0);
                setc.put('6',0);
                setc.put('7',0);
                setc.put('8',0);
                setc.put('9',0);
            }
        }
        for(int i =0;i<9;i++)
        {
            HashMap<Character, Integer> rowc = new HashMap<>();
            rowc.put('1',0);
            rowc.put('2',0);
            rowc.put('3',0);
            rowc.put('4',0);
            rowc.put('5',0);
            rowc.put('6',0);
            rowc.put('7',0);
            rowc.put('8',0);
            rowc.put('9',0);
            HashMap<Character, Integer> colc = new HashMap<>();
            colc.put('1',0);
            colc.put('2',0);
            colc.put('3',0);
            colc.put('4',0);
            colc.put('5',0);
            colc.put('6',0);
            colc.put('7',0);
            colc.put('8',0);
            colc.put('9',0);
            for(int j =0;j<9;j++)
            {
                if(board[j][i] != '.')
                {
                    char col = board[j][i];
                    int countt = colc.get(col);
                    if(countt == 1)
                    {
                        return false;
                    }
                    else
                    {
                        colc.put(col,1);
                    }
                }
                if(board[i][j] != '.')
                {
                    char row = board[i][j];
                    int countt = rowc.get(row);
                    if(countt == 1)
                    {
                        return false;
                    }
                    else
                    {
                        rowc.put(row,1);
                    }
                }
            }
        }
        return true;
    }
}