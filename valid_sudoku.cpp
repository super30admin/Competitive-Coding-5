// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<string> seen;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                        
                    string r= "row"+to_string(i)+to_string(board[i][j]);
                    string c= "col"+to_string(j)+to_string(board[i][j]);
                    int b = (i/3) * 3 + (j/3);
                    string box= "box"+ to_string(b) + to_string(board[i][j]);
                    if(seen.find(r) != seen.end() ||seen.find(c) != seen.end() || seen.find(box) != seen.end()){
                        return false;
                    }else{
                        seen.insert(r);
                        seen.insert(c);
                        seen.insert(box);
                    }
                }
            }
        }
        return true;
        
    }
};