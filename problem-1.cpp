// t-c: n*n
// s-c: n*n
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<string> iset;
        string s;
        string r = "r", c = "c", b = "b";
        for(int i = 0 ; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    s = board[i][j] + r + to_string(i);
                    if(iset.find(s) != iset.end())
                        return false;
                    else
                        iset.insert(s);

                    s = board[i][j] + c + to_string(j);
                    if(iset.find(s) != iset.end())
                        return false;
                    else
                        iset.insert(s);
                    
                    s = board[i][j] + b + to_string(i/3) + to_string(j/3);

                    if(iset.find(s) != iset.end())
                        return false;
                    else
                        iset.insert(s);
                    
                }
            }
        }
        return true;
    }
};
