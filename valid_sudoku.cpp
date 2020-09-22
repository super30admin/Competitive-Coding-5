// Time Complexity : O(mn)
// Space Complexity : O(3mn)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. Create 3 vectors for row, col, box and fill each.
//2. Get the correct box index.
//3. if there is a repeat return false, else return truw 

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        //edge
        // if(board.size()<9){
        //     return false;
        // }
        
        //logic
        vector<unordered_set<int>> row_map(9);
        vector<unordered_set<int>> col_map(9);
        vector<unordered_set<int>> box_map(9);
        int rows = board.size();
        int cols = board[0].size();
        
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                
                if(board[r][c] == '.'){
                    continue;
                }
                
                int num = board[r][c] -'0';
                //check in the row hashset
                if(row_map[r].find(num) != row_map[r].end()){
                    return false;
                }else{
                    row_map[r].insert(num);
                }
                //check in the col hashset
                if(col_map[c].find(num) != col_map[c].end()){
                    return false;
                }else{
                    col_map[c].insert(num);
                }
                //check in the box hashset
                int box_row = (r/3) * 3;
                int box_col = (c/3);
                int box_num = box_row + box_col;
                
                if(box_map[box_num].find(num) != box_map[box_num].end()){
                    return false;
                }else{
                    box_map[box_num].insert(num);
                }
            }
        }
       return true; 
    }
};
