// https://leetcode.com/problems/valid-sudoku/
// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public:
        bool isValidSudoku(vector<vector<char>>& board) {
            int n = board.size();
            int m = board[0].size();
            int rows[9][9] = {0};
            int cols[9][9] = {0};
            int ans[9][9] = {0};
            
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board[i][j] != '.'){
                        int num = board[i][j] - '0' - 1;
                        int sum = i/3*3 + j/3;
                        if(rows[i][num] || cols[num][j] || ans[sum][num]) return false;
                        rows[i][num] = cols[num][j] = ans[sum][num] = 1;
                    }   
                }
            }
            return true;
        }
    };