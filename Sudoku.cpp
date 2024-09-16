// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Completely relied on classroom solution. And lots of logical errors

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.empty()||board.size()!=9||board[0].size()!=9){
            return false;
        }
        //row
        for(int i=0;i<9;i++){
            vector<bool> b(9);
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int v = board[i][j]-'1';
                    cout<<v<<"in row";
                    if(b[v]==true){
                        return false;
                    }
                    else{
                        b[v]=true;
                    }
                }
            }
        }
        
        //column
        for(int j=0;j<9;j++){
            cout<<"inside column";
            vector<bool> b(9);
            for(int i=0;i<9;i++){
                if(board[i][j]!='.'){
                    int v = board[i][j]-'1';
                    cout<<v<<"in column";
                    if(b[v]==true){
                        return false;
                    }
                    else{
                        b[v]=true;
                    }
                }
            }
        }
        //block
        for(int block=0;block<9;block++){
            vector<bool> b(9);
            for(int i=block/3*3;i<block/3*3+3;i++){
                for(int j=block%3*3;j<block%3*3+3;j++){
                    if(board[i][j]!='.'){
                        int v = board[i][j]-'1';
                        //cout<<v<<" ";
                        if(b[v]==true){
                            return false;
                        }
                        b[v]=true;
                    }
                }
            }
        }
        return true;
    }
};
