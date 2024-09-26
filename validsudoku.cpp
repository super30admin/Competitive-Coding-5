//Time complexity : O(m * n)
//Space complexity : O(1)

//Approach:
            //Check each and every row and column first
            //If any of these are invalid, then return false
            //Check 9 squares, if anyone is invalid then return false
            //In the end return true

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.size() == 0)
            return true;
        
        //Check all the rows
        for(int i = 0 ; i < board.size(); i++)
        {
            bool checkArray[9] = {false};
            int j = 0;
            
            while(j < board[0].size())
            {
                if(isdigit(board[i][j]))
                {
                    int num = board[i][j] - '0';
                    if(checkArray[num - 1] == true)
                    {
                        return false;
                    }
                    checkArray[num - 1] = true;
                }
                j++;
            }
        }
        
        for(int i = 0 ; i < board.size(); i++)
        {
            bool checkArray[9] = {false};
            int j = 0;
            
            while(j < board[0].size())
            {
                if(isdigit(board[j][i]))
                {
                    int num = board[j][i] - '0';
                    if(checkArray[num - 1] == true)
                    {
                        return false;
                    }
                    checkArray[num - 1] = true;
                }
                j++;
            }
        }
        
        //check for 3*3 matrices
        vector<vector<int>> dirs = {{0 , 1}, {0 , -1}, {1 , 0}, {-1 , 0}, {1 , 1}, {-1 , 1}, {1, -1}, {-1 , -1}};
        vector<vector<int>> centerCells = {{1 , 1}, {1 , 4}, {1 , 7}, {4, 1}, {4, 4}, {4, 7}, {7 , 1}, {7 , 4}, {7 , 7}};
        
        for(auto center : centerCells)
        {
            bool checkArray[9] = {false};
            int r = center[0];
            int c = center[1];
            if(isdigit(board[r][c]))
            {
                int num = board[r][c] - '0';
                if(checkArray[num - 1] == true)
                {
                    return false;
                }
                checkArray[num - 1] = true;
            }
            
            for(auto dir : dirs)
            {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(isdigit(board[nr][nc]))
                {
                    int num = board[nr][nc] - '0';
                    if(checkArray[num - 1] == true)
                    {
                        return false;
                    }
                    checkArray[num - 1] = true;
                } 
            }
        }
        
        return true;
    }
};