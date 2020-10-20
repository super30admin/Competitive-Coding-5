//time complexity:O(n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using bfs
//any issues faced? yes, but understood it

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.size()==0)
            return false;
        for(int i=0; i<9; i++)
        {
            vector<bool>b(9);
            for(int j=0; j<9; j++)
            {
                if(board[i][j]!='.')
                {
                    if(b[(int)(board[i][j]-'1')])
                    return false;
                    b[(int)(board[i][j]-'1')]=true;
                }
            }
        }
        for(int j=0; j<9; j++)
        {
            vector<bool>b(9);
            for(int i=0; i<9; i++)
            {
                if(board[i][j]!='.')
                {
                    if(b[(int)(board[i][j]-'1')])
                    return false;
                    b[(int)(board[i][j]-'1')]=true;
                }
            }
        }
        for(int block=0; block<9; block++)
        {
            vector<bool>b(9);
            for(int i=block/3*3; i<block/3*3+3; i++)
            {
                for(int j=block%3*3; j<block%3*3+3; j++)
                {
                    if(board[i][j]!='.')
                    {
                        if(b[(int)(board[i][j]-'1')])
                            return true;
                        b[(int)(board[i][j]-'1')]=true;
                    }
                }
            }
        }
        return true;
    }
};