
//Que : Valid Sudoku ( https://leetcode.com/problems/valid-sudoku/)
//TC- O(1) as constant array of 9*9 is used (ignore constants in complexity calc) 
//SC- O(1) as constant array of 9 is used (ignore constants in complexity calc)
//Idea-checked if all rows are valid, then all cols and lastly all 3*3 boxes valid or not


class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        //check for all row, col and 3*3 box to be valid
        
        //check row 
        for(int i=0; i< 9 ; i++)
        {
            int check[9] ={0};
            
            for(int j=0; j< 9 ; j++)
            {
                if(board[i][j] != '.')
                {
                    if( check[int(board[i][j] - '1')] == 1){
            
                        return false;
                    }
                    check[int(board[i][j] - '1')] = 1;
                }
            }
        }
        
        
        //check col 
        for(int j=0; j< 9 ; j++)
        {
            int check[9] ={0};
            
            for(int i=0; i< 9 ; i++)
            {
                if(board[i][j] != '.')
                {
                    if( check[int(board[i][j] - '1')] == 1){
                      
                        return false;
                    }
                    check[int(board[i][j] - '1')] = 1;
                }
            }
        }
        
        //check 3X3 box 
        
                    
                    
        for(int block=0; block< 9 ; block++)
        {
             int check[9] ={0};
             for(int i= block/3*3 ; i < block/3*3 + 3 ; i++)
             {
                 for(int j= block%3*3 ; j < block%3*3 + 3 ; j++)
                 {
                      if(board[i][j] != '.')
                        {
                            if( check[int(board[i][j] - '1')] == 1){
                              
                                return false;
                            }
                        check[int(board[i][j] - '1')] = 1;
                        }
                }
             }
           
            
            
        }
       
        
        return true;
    }
};