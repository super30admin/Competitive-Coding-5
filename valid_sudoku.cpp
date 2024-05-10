//Time O(n^2)
//Space O(n^2)
//Leetcode: yes
// Issue seen: none

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int m = board.size();
        int n = board[0].size();

        vector<vector<bool>> row(m, (vector<bool> (n, 0)));
        vector<vector<bool>> col(m, (vector<bool> (n, 0)));
        vector<vector<bool>> box(m, (vector<bool> (n, 0)));

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '.') 
                   continue;
                int value = board[i][j] - '0' - 1;
                int box_id = (i/3)*3 + j/3;
                
                if(row[i][value] || col[j][value] || box[box_id][value]){
                    return false;
                }
                row[i][value] = true;
                col[j][value] = true;
                box[box_id][value] = true;
             } 
        }
        return true;
    }
};
