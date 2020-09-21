// Time Complexity : O(1) as we will only traverse throught constant 9 iterations
// Space Complexity : O(1) creating hashmap but it  is of constant size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int h = board.size();
        int w = board[0].size();
        
        //Checking for duplicates in rows (If duplicates are found we return false)
        for(int i = 0; i < h; i++){
            unordered_map<char,int> m;
            for(int j = 0; j < w; j++){
                if(board[i][j] != '.'){
                    int k = ++m[board[i][j]];
                    if(k > 1)return false;
                }
            }
        }
        
        //Checking for duplicates in columns (If duplicates are found we return false)
        for(int i = 0; i < h; i++){
            unordered_map<char,int> m;
            for(int j = 0; j < w; j++){
                if(board[j][i] != '.'){
                    int k = ++m[board[j][i]];
                    if(k > 1)return false;
                }
            }
        }
        
        vector<int> box{{0,3,6}};//Range for our 3 X 3 Boxes in 9 X 9 matrix
    
        //We check for duplicates in the 3 X 3 matrices in order     
        for(auto a: box){
            for(auto b: box){
                //This section is to check for duplicates in a 3 X 3 block
                unordered_map<char,int> m;
                for(int i = a; i <= a+2; i++){
                    for(int j = b; j <= b+2; j++){
                        if(board[i][j] != '.'){
                            int k = ++m[board[i][j]];
                            if(k > 1)return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
};
