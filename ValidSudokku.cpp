#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use 3 sets for every row, column and 3x3 box to track seen digits
As we go cell by cell we check if the digit is already seen in that row, column or box
if we find any repetition we return false there itself otherwise it's a valid sudoku
*/
class Solution{
public:
    bool validSudoku(vector<vector<int>>& board){
        unordered_set<char> row[9];
        unordered_set<char> col[9];
        unordered_set<char> grid[9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;

                char value = board[i][j];
                int gridIndex = (i/3)*3 + (j/3);

                if(row[i].count(value) || col[j].count(value) || grid[gridIndex].count(value))
                    return false;
                
                row[i].insert(value);
                col[j].insert(value);
                grid[gridIndex].insert(value);
            }
            return true;
        }
    }
};
