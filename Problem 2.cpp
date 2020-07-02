//Time Complexity : O(m*n)
// Space Complexity :O(1) where n=9 for int arr and it is always 9
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.size()==0) return false;
        //check for rpw repetition
        for(int i=0; i<9; i++){
            int arr[9];//0 if the num is not present and 1 if the number is present
            for(int k=0; k<9; k++){
                arr[k]=0;
            }
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    int idx = int(board[i][j]-'1');
                    if(arr[idx])  return false;
                    //arr[(int)(board[i][j]-1)] = true;
                    arr[idx]=1;
                }
                
            }
        }
        
        //check for column repetition
        for(int j=0; j<9; j++){
            int arr[9];
            for(int k=0; k<9; k++){
                arr[k]=false;
            }
            for(int i=0; i<9; i++){
                if(board[i][j]!='.'){
                    int idx = int(board[i][j]-'1');
                    if(arr[idx])  return false;
                    arr[idx] = true;
                }
                
            }
        }

        //check for block repetition
        for(int b = 0; b<9; b++){
        int arr[9];
        for(int k=0; k<9; k++){
                arr[k]=0;
        }
        for(int i=b/3*3; i<b/3*3+3; i++){
            for(int j=b%3*3; j<b%3*3+3; j++){
                if(board[i][j]!='.'){
                    int idx = int(board[i][j]-'1');
                    if(arr[idx])  return false;
                    arr[idx] = 1;
                }
            }
        }
            
        }
        
        
        
        return true;
        
    }
};