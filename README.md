# Competitive Conding-5


## Problem 1 Largest value in a tree row - https://leetcode.com/problems/find-largest-value-in-each-tree-row/

You need to find the largest value in each row of a binary tree.

Example:
Input: 





          111



         / \



        3   21



       / \   \  



      5   311   91 



Output: [111, 21, 311]

## Problem 2 Valid sudoku - https://leetcode.com/problems/valid-sudoku/

Welcome to Big N Problem of the Day.

This problem was asked at Pramp

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

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

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

## Problem 3 Pacific Atlantic Water Flow - https://leetcode.com/problems/pacific-atlantic-water-flow/

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).