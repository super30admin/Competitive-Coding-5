/*
Intuition: Check 3 things 
1) Rows have unique elements 
2) columns have unique elements 
3) block has unique elements 
/////////////////////////
Time Complexity: O(1)  ( A sudoku's dimensions are always constant)
Space Complexity: O(1) ( A sudoku's dimensions are always constant)
*/
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        for ( int i =0 ; i < 9; i ++){
            set <int> rows;
            for( int j = 0; j < 9; j ++){
                
                if ( board[i][j]!='.'){
                    
                    if ( rows.find((board[i][j] - '0')) != rows.end()){
                        return false;
                    }
                    rows.insert(board[i][j] - '0');
                }
            }
        }
        
        
        for ( int j =0 ; j < 9; j ++){
            set <int> cols;
            for( int i = 0; i < 9; i ++){
                
                if ( board[i][j]!='.'){
                    
                    if ( cols.find((board[i][j] - '0')) != cols.end()){
                        return false;
                    }
                    cols.insert(board[i][j] - '0');
                }
            }
        }
        for ( int block = 0 ; block < 9; block++){
            set <int> blocks;
            for ( int i = block/3*3  ; i < block/3*3 +3; i ++){
                
                for( int j = block%3*3 ; j < block%3*3 + 3; j ++){
                    if ( board[i][j]!='.'){

                        if ( blocks.find((board[i][j] - '0')) != blocks.end()){
                            return false;
                        }
                        blocks.insert(board[i][j] - '0');
                    }
                }
            }
        }
        return true;
    }
};