//Time Complexity - O(n*n)
//Space Complexity - O(n*n)
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int row[9][9] ={0};
        int col[9][9]={0}; 
        int block[3][3][9]={0};

        for(int irow = 0 ; irow < 9 ; irow++)
        {
            for(int icol = 0; icol < 9 ; icol++ )
            {
                if(board[irow][icol] != '.')
                {
                    int num = board[irow][icol] - '0' - 1;
                    if(row[irow][num]++)
                    {
                        return false;
                    }
                    if(col[icol][num]++)
                    {
                        return false;
                    }
                    if(block[irow / 3][icol / 3][num]++)
                    {
                        return false;
                    }
                }    
            }
        }
        return true;
    }
};