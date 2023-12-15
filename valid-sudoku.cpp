/*
Iterate through each row, column, and 3x3 subgrid of the Sudoku board, using sets to check for duplicates in each.
Use three nested loops to check for duplicates in rows, columns, and subgrids separately.
Return false if duplicates are found; otherwise, the board is a valid Sudoku configuration.

Time Complexity: O(1) because the size of the Sudoku board is fixed (9x9), leading to constant time complexity.
Space Complexity: O(1) as the space used (unordered sets) is also fixed and does not depend on the size of the input.*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i=0;i<9;i++){
                unordered_set<char> check_row;

            for(int j=0;j<9;j++){
                if (board[i][j] != '.' && check_row.find(board[i][j]) != check_row.end()){
                    return false;
                }
                check_row.insert(board[i][j]);
            }
        }
        
        for(int j=0;j<9;j++){
            unordered_set<char> check_col;
            for(int i=0;i<9;i++){
                if (board[i][j] != '.' && check_col.find(board[i][j]) != check_col.end()){
                    return false;
                }
                check_col.insert(board[i][j]);
            }
        }
         vector<unordered_set<char>> check_box(9);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int loc = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.' && check_box[loc].find(board[i][j]) != check_box[loc].end()){
                    return false;
                }
                check_box[loc].insert(board[i][j]);
            }
        }
           return true;
    }
};