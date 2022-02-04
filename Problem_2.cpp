/**
 * Time Complexity:
 * O(N^2) as we are iterating through the entir egrid which is of N*N size
 */

/**
 * Space Complexity:
 *  O(N)
 */

/**
 * Approach:
 * For a valid sudoku in every row and column a number should not be repeated again, and this is the condition
 * for 3*3 blocks too. The first intution is we have to iterate through the entire rows and check for the repetitions
 * there. Similarly we have to check for the columns and the subBoxes too. If there is a repetition we return false.
 * Otherwise we set the index in the array  which is the number in that cell -1 to true implying that the number is present
 * in the grid. Following this intution we write three passes, one for rows, one for column and one for the subBoxes.
 * 
 */

//The code ran perfectly on leetcode.

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.size() == 0 || board[0].size() == 0) return false;
        for(int i =0; i<9; i++){
            vector<bool> b(9);
            for(int j =0; j<9; j++){
                if(board[i][j] != '.'){
                    if(b[int(board[i][j] - '1')]) return false;
                    b[int(board[i][j] - '1')] = true;
                }
            }
        }
        
        for(int j =0; j<9; j++){
            vector<bool> b(9);
            for(int i =0; i<9; i++){
                if(board[i][j] != '.'){
                    if(b[int(board[i][j] - '1')]) return false;
                    b[int(board[i][j] - '1')] = true;
                }
            }
        }
        
        for(int k = 0; k<9 ; k++){
            vector<bool> boxArr(9);
            for(int i = k/3*3; i <k/3*3+3; i++){
                for(int j = k%3*3; j <k%3*3+3; j++){
                if(board[i][j] != '.'){
                    if(boxArr[int(board[i][j] - '1')]) return false;
                    boxArr[int(board[i][j] - '1')] = true;
                }
            }
            }
        }
        
        return true;
        
    }
};

