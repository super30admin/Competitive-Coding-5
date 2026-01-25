class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<string> us;

        for (int i=0;i<board.size();i++) {
            for (int j=0;j<board[0].size();j++) {
                string row = 'r'+to_string(i)+board[i][j];
                string col = 'c'+to_string(j)+board[i][j];
                string box = 'b'+to_string(i/3)+to_string(j/3)+board[i][j];

                if (board[i][j]!='.' && ( us.contains(row) || us.contains(col) || us.contains(box) )) {
                    return false;
                }

                us.insert(row);
                us.insert(col);
                us.insert(box);
            }
        }
        return true;
    }
};
