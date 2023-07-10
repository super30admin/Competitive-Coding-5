//Time Complexity: Constant Time
//Space Complexity: Constant
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(repeatInRow(board, i, j) || repeatInCol(board, i , j) || repeatSubCell(board, i, j)) {
                        return false; 
                    }
                }
                // Check if board[i][j] repeats in the row 

                // Check if board[i][j] repeats in the column 

                // Check if board[i][j] repeats in the sub-cell
            }
        }

        return true;        
    }


    bool repeatInRow(vector<vector<char>>& board, int row, int col) {
        int number = board[row][col];

        for(int j = 0; j < 9; j++) {
            if(j != col) {
                if(board[row][j] == number) {
                    cout << "return true for: " << row << " : " << j << endl; 
                    return true; 
                } 
            }
        }
        
        return false;     
    }


    bool repeatInCol(vector<vector<char>>& board, int row, int col) {
        int number = board[row][col];

        for(int i = 0; i < 9; i++) {
            if(i != row) {
                if(board[i][col] == number) {
                    cout << "return true for: " << i << " : " << col << endl; 
                    return true; 
                }
            }
        }

        return false;     
    }


    bool repeatSubCell(vector<vector<char>>& board, int row, int col) {
        int number = board[row][col];
        int startRow, startCol; 

        if(row >= 0 && row <= 2) {
            startRow = 0; 
        } else if(row >= 3 && row <= 5) {
            startRow = 3; 
        } else {
            startRow = 6;
        }

        if(col >= 0 && col <= 2) {
            startCol = 0; 
        } else if(col >= 3 && col <= 5) {
            startCol = 3; 
        } else {
            startCol = 6;
        }

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(i != row && j != col) {
                    if(board[i][j] == number) {
                        cout << "return true for: " << i << " : " << j << endl; 
                        return true; 
                    }
                }
            }
        }

        return false; 
             
    }
};