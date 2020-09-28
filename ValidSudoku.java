/*
 * #36. Valid Sudoku
 * 
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

refer leetcode for image 
A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    
Note:

1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
2. Only the filled cells need to be validated according to the mentioned rules.
3. The given board contain only digits 1-9 and the character '.'.
4. The given board size is always 9x9.

 */


/*
 * Time Complexity: O (9x9) -> 9 rows and 9 columns, constant time complexity
 * 
 * Space Complexity: O (N) -> If the sudoku is valid, we will end up storing entry for 'N' elements (found at ith row or jth column or xth grid number) in a HashSet
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding5;

import java.util.HashSet;

public class ValidSudoku {
public boolean isValidSudoku(char[][] board) {
        
        // #1. Base condition
        if(board == null || board.length == 0 || board[0].length == 0){
            return true;
        }
        
        // #2. Since, repetition is not allowed either in a row, colum or 3x3 grid, we are dealing with unique values
        // So, we can use HashSet, where lookup time is constant
        // Here, we are using HashSet to hold strig values and store the row, column index and grid number where we found an element. If we had used HashSet of type Integer, then we had to store the element values we found at a row, column or a particular grid. In that case, we had to use 3 HashSets
        HashSet<String> set = new HashSet<String>();
        
        // #3. Traverse through the board and check for given conditions
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                // Take the element in a char variable
                char element = board[i][j];
                // Check if the element is not '.', means an empty cell
                // If not, check for the three conditions
                // If yes, then go to another column in a row
                if(element != '.'){
                    // If an element at a particular row, column or grid number is already present in HashSet, we don't need to add it, meaning repetition is found, return false
                    if(!set.add(element + "found at row" + i) || !set.add(element + "found at column" + j) 
                       || !set.add(element + "found at grid number" + i/3 + "-" + j/3))
                    {
                        return false; 
                    }
                        
                }
            }
        }
        // After traversing the whole board, if given conditions are satisfied, return true
        return true;
            
        }

}
