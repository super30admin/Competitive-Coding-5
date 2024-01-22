// Time Complexity : O(M*N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using a bool array and storing if the element was previously present or not.

// 36. Valid Sudoku

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // row
        for(int i=0;i<9;i++){
            vector<bool> b(9);
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    if(b[(int)(board[i][j] - '1')]) return false;
                    b[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        // column
        for(int j=0;j<9;j++){
            vector<bool> b(9);
            for(int i=0;i<9;i++){
                if(board[i][j] != '.'){
                    if(b[(int)(board[i][j] - '1')]) return false;
                    b[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        // block
        for(int block=0;block<9;block++){
            vector<bool> b(9);
            for(int i=block/3*3;i<block/3*3+3;i++){
                for(int j=block%3*3;j<block%3*3+3;j++){
                    if(board[i][j] != '.'){
                        if(b[(int)(board[i][j] - '1')]) return false;
                            b[(int)(board[i][j] - '1')] = true;
                        }
                    }
                }
            }
            return true;
    }
};