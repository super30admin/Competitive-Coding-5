// Time Complexity : O(1)  as n=9
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// check three parts as commented in the code.

class Solution
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        if (board.empty() || board.size() == 0)
            return false;

        unordered_set<int> set;
        // check each row same column elements
        for (int i = 0; i < board[0].size(); i++)
        {
            set.clear();
            for (int j = 0; j < board.size(); j++)
            {
                if (board[j][i] == '.')
                    continue;
                if (set.find(board[j][i] - '0') != set.end())
                {
                    return false;
                }
                else
                {
                    set.insert(board[j][i] - '0');
                }
            }
        }

        // check each column , same row elements
        for (int i = 0; i < board.size(); i++)
        {
            set.clear();
            for (int j = 0; j < board[0].size(); j++)
            {
                if (board[i][j] == '.')
                    continue;
                if (set.find(board[i][j] - '0') != set.end())
                {
                    return false;
                }
                else
                {
                    set.insert(board[i][j] - '0');
                }
            }
        }

        // check each 3*3 box
        for (int block = 0; block < 9; block++)
        {
            set.clear();
            for (int i = (block / 3 * 3); i < (block / 3 * 3) + 3; i++)
            {
                for (int j = (block % 3 * 3); j < (block % 3 * 3) + 3; j++)
                {
                    if (board[i][j] == '.')
                        continue;
                    if (set.find(board[i][j] - '0') != set.end())
                    {
                        return false;
                    }
                    else
                    {
                        set.insert(board[i][j] - '0');
                    }
                }
            }
        }

        return true;
    }
};