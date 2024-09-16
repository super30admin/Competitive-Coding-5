// TC: O(1);
// SC: O(1);



class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows = board.size();
        int cols = board[0].size();
        vector<vector<int>>map_rows(rows,vector<int>(cols,0));
        vector<vector<int>>map_cols(rows,vector<int>(cols,0));
        vector<vector<int>>map_box(rows,vector<int>(cols,0));
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'1';
                    int box_index = (i/3)*3 + j/3;
                    map_rows[i][num]++;
                    map_cols[j][num]++;
                    map_box[box_index][num]++;
                    if(map_rows[i][num] > 1 ||map_cols[j][num] > 1|| map_box[box_index][num]>1)return false;
                }
                
            }
        }
        return true;
        
        
        
    }
};