// Time Complexity :O(m * n) where m*n in the number elements in the matrix
// Space Complexity : O(m * n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows[9][9] ={0};
        int cols[9][9] = {0};
        int subBox[9][9] = {0};
        int k; int nums;
        for(int i=0;i< board.size();i++){
            for(int j=0;j< board[0].size();j++){
                if(board[i][j] != '.'){
                    nums = board[i][j] - '1';
                    k = i/3*3+j/3;
                    if(rows[i][nums] || cols[j][nums] || subBox[k][nums]) return false;
                    else {
                        rows[i][nums] = 1;
                        cols[j][nums] = 1;
                        subBox[k][nums] = 1;
                    }
                }
            }
        }
        return true;
    }
};