// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Use sets to figure out if any element has been repeated in a row, col or 3x3 box
// Use a hashmap to store sets for rows and cols & a vector to store sets for the boxes
// Return false in the loop itself if we find a duplicate, return true outside the loop

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_map<int, set<int>> rowMap;
        unordered_map<int, set<int>> colMap;
        vector<set<int>> boxMap(9);

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(rowMap[i].find(board[i][j]) != rowMap[i].end()) {
                    return false;
                }
                if(colMap[j].find(board[i][j]) != colMap[j].end()) {
                    return false;
                }
                int r, c;
                r = i/3 * 3;
                c = j/3;
                int idx = r + c;
                if(boxMap[idx].find(board[i][j]) != boxMap[idx].end()) {
                    return false;
                }
                rowMap[i].insert(board[i][j]);
                colMap[j].insert(board[i][j]);
                boxMap[idx].insert(board[i][j]);
            }
        }
        return true;
    }
};