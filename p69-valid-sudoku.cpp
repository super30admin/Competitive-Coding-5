// using map
// Time complexity is O(1) (since size of sudoku is always 9*9)
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        map<vector<int>, int> mp;
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                if(board[i][j] != '.') {
                    mp[{i,j}] = board[i][j];
                }
            }
        }
        for(auto itr = mp.begin(); itr != mp.end(); itr++) {
            int i = itr->first[0];
            int j = itr->first[1];
            int cellVal = itr->second;
            
            // checking if there is a duplicate of current cell value in the same row
            for(int k = 0; k < board[0].size(); k++) {
                if(j != k && cellVal == board[i][k])
                    return false;
                }
            // checking if there is a duplicate of current cell value in the same column
            for(int m = 0; m < board.size(); m++) {
                if(m != i && cellVal == board[m][j]) {
                    return false;
                }
            }
            // checking if there is a duplicate of current cell value in the same sub matrix
            for(int n = i - (i%3); n < i - (i%3) + 3; n++) {
                for(int p = j - j%3; p < j - j%3 + 3; p++) {
                    if((n != i && p != j) && cellVal == board[n][p])
                        return false;
                }
            }
        }
        
        return true;
    }
};


// Time complexity is O(1) (since size of sudoku is always 9*9)
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                if(board[i][j] != '.') {
                    int currCell = board[i][j];
                    // checking if there is a duplicate of current cell value in the same row
                    for(int k = 0; k < board[0].size(); k++) {
                        if(j != k && currCell == board[i][k])
                            return false;
                    }
                    // checking if there is a duplicate of current cell value in the same column
                    for(int m = 0; m < board.size(); m++) {
                        if(m != i && currCell == board[m][j]) {
                            return false;
                        }
                    }
                    // checking if there is a duplicate of current cell value in the same sub matrix
                    for(int n = i - (i%3); n < i - (i%3) + 3; n++) {
                        for(int p = j - j%3; p < j - j%3 + 3; p++) {
                            if((n != i && p != j) && currCell == board[n][p])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};
