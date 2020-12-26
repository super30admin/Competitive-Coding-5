//Time - O(1) since we know there are only 81 cells
//Space - O(1)
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_map<char,int> mp;
        
        
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                mp.clear();
              for(int k=0;k<3;k++){
                  for(int l=0;l<3;l++){
                      if(isdigit(board[i+k][j+l]) && mp.find(board[i+k][j+l]) == mp.end())
                          mp[board[i+k][j+l]] = 1;
                      else if(isdigit(board[i+k][j+l]))
                          return false; 
                  }
              }  
            }
        }
        
        for(int i=0;i<9;i++){
            mp.clear();
            for(int j=0;j<9;j++){
                      if(isdigit(board[i][j]) && mp.find(board[i][j]) == mp.end())
                          mp[board[i][j]] = 1;
                      else if(isdigit(board[i][j]))
                          return false; 
            }
        }
        
        for(int i=0;i<9;i++){
            mp.clear();
            for(int j=0;j<9;j++){
                      if(isdigit(board[j][i]) && mp.find(board[j][i]) == mp.end())
                          mp[board[j][i]] = 1;
                      else if(isdigit(board[j][i]))
                          return false; 
            }
        }
        
        
       return true; 
        
        
    }
};