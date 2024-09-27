// Time Complexity : O(1)// since board size is fixed
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Check if all rows are valid, for each row create a bool array of 9 elements and if any number was pseen previously, return false
// 2. Check similarly for each column and for each box
// 3. For getting indices of each box: Range of row: [(box/3)*3, (box/3)*3+3) | Range of col: [(box%3)*3, (box%3)*3+3)

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // check if each row is valid
        cout<<"checking rows\n";
        for(int i=0;i<9;i++){
            cout<<"row: "<<i<<endl;
            vector<bool> check(9,false);
            for(int j=0;j<9;j++){
                cout<<check[board[i][j]]<<" ";
                if(board[i][j]!='.' && check[board[i][j]])
                    return false;
                if(board[i][j]!='.') 
                    check[board[i][j]] = true;
            }
        }
        cout<<"checking cols\n";
        // check if each col is valid
        for(int j=0;j<9;j++){
            vector<bool> check(9,false);
            for(int i=0;i<9;i++){
                if(board[i][j]!='.' && check[board[i][j]])
                    return false;
                if(board[i][j]!='.') 
                    check[board[i][j]] = true;
            }
        }
        cout<<"checking box\n";
        // check if each box is valid
        for(int box = 0; box<9; box++){
            vector<bool> check(9,false);
            for(int i=(box/3)*3; i<(box/3)*3+3; i++){
                for(int j=(box%3)*3; j<(box%3)*3+3; j++){
                    if(board[i][j]!='.' && check[board[i][j]])
                        return false;
                    if(board[i][j]!='.') 
                        check[board[i][j]] = true;
                }
            }    
        }
        
        return true;
    }
};