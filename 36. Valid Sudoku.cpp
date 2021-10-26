/*
Time Complexity = O(1)
Space Complexity = O(1)
I have taken time complexity as O(1) since we are traversing only 81 times and space complexity is O(1) we are only storing 81 elements at a time.
I am confused please provide your input.
*/
class Solution {
public:

    bool check_3x3(vector<vector<char> > &board, int start_i, int start_j)
    {
        unordered_set<char>  hs; 
        for(int i=start_i; i<(start_i+3); i++) {
            for(int j=start_j; j<(start_j+3); j++) {
                if( board[i][j] == '.' )
                    continue;
                if( hs.count(board[i][j]) > 0 )
                    return false;
                hs.insert(board[i][j]);
            }
        }
        return true;
    }   

    bool isValidSudoku(vector<vector<char> > &board) {
        //check row
        unordered_set<char>  row_hs;   
        for(int i=0; i<9; i++) {         
            row_hs.clear();
            for(int j=0; j<9; j++) {
                if( board[i][j] == '.' )
                    continue;                           
                if( row_hs.count(board[i][j]) > 0)
                    return false;
                row_hs.insert(board[i][j]);
            }
        }
        //check col
        unordered_set<char>  col_hs;   
        for(int j=0; j<9; j++) {         
            col_hs.clear();
            for(int i=0; i<9; i++) {
                if( board[i][j] == '.' )
                    continue;
                if( col_hs.count(board[i][j]) > 0 )
                    return false;
                col_hs.insert(board[i][j]);
            }
        }       

        //check 3*3
        for(int i=0; i<=6; i+=3) {
            for(int j=0; j<=6; j+=3) {
                if( !check_3x3(board,i,j) )
                    return false;
            }
        }
        return true;
    }
};
