// Time Complexity : O(N^M) where N represents the no.of rows and M represents the no.of columns
// Space Complexity : O(N*M) where N represents the no.of rows and M represents the no.of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/valid-sudoku/
// Submission Link: https://leetcode.com/submissions/detail/543035490/

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<unordered_set<char> > rows(9);
        vector<unordered_set<char> > columns(9);
        vector<unordered_set<char> > boxes(9);
        
        int box_num;
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                
                if(rows[i].find(board[i][j]) != rows[i].end())
                    return false;
                rows[i].insert(board[i][j]);
                
                if(columns[j].find(board[i][j]) != columns[j].end())
                    return false;
                columns[j].insert(board[i][j]);
                
                box_num = (i/3)*3 + (j/3);
                if(boxes[box_num].find(board[i][j]) != boxes[box_num].end())
                    return false;
                boxes[box_num].insert(board[i][j]);
            }
        }
        
        return true;
    }
};