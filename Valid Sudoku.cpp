//Time Complexity- O(n^2)
//Space Complexity- O(n)

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        return checkRow(board) && checkCol(board) && checkMat3(board);
    }
    
    bool checkRow(vector<vector<char>> &board){
        
        for(int i=0;i<board.size();i++){
            unordered_set<char> st;
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='.'){
                    continue;
                }
                else if(st.find(board[i][j])!=st.end()){
                    return false;
                }
                st.insert(board[i][j]);
            }
        }
        return true;
    }
    
    bool checkCol(vector<vector<char>> &board){
        
        for(int i=0;i<board[0].size();i++){
            unordered_set<char> st;
            for(int j=0;j<board.size();j++){
                if(board[j][i]=='.'){
                    continue;
                }
                else if(st.find(board[j][i])!=st.end()){
                    return false;
                }
                st.insert(board[j][i]);
            }
        }
        return true;
    }
    
    bool checkMat3(vector<vector<char>> &board){
        
        int row=0;
        int col=0;
        for(int i=0;i<board.size();i++){
            unordered_set<char> st;
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(board[row+j][col+k]=='.'){
                    continue;
                    }
                    else if(st.find(board[row+j][col+k])!=st.end()){
                        return false;
                    }
                    st.insert(board[row+j][col+k]);
                }
            }
            row+=3;
            if(row>6){
                row=0;
                col+=3;
            }
        }
        return true;
    }
};