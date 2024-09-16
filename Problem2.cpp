// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows[9][9] = {0};
        int cols[9][9] = {0};
        int box[9][9] = {0};
        int k;
        int temp;
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[0].size(); j++){
                if(board[i][j] != '.'){
                    temp = board[i][j] - '1';
                    k = i/3 * 3 + j/3;
                    if(rows[i][temp] || cols[j][temp] || box[k][temp])
                        return false;
                    else {
                        rows[i][temp] = 1;
                        cols[j][temp] = 1;
                        box[k][temp] = 1;
                    }
                }
            }
        }
        return true;
    }
};