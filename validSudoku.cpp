class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<string> us;
        
        for (int i=0;i<board.size();i++) {
            
            for (int j=0;j<board[0].size();j++) {
            string rowv='r'+to_string(i)+board[i][j];
            rowv.push_back();
            string colv='c'+to_string(j)+board[i][j];
            string b='b'+to_string(i/3) +to_string(j/3)+board[i][j];
                if ( board[i][j]!='.' && (us.find(rowv)!=us.end() || us.find(colv)!=us.end() || us.find(b)!=us.end()) ) {
                    
                    return false;
                }
                us.insert(rowv);
                us.insert(colv);
                us.insert(b);
            }
        }
        return true;
    }
};