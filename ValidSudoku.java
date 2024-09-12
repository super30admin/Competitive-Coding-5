//Time complexity: O(81)
//Space complexity: O(27).
//executed on leetcode.

class Solution {
    int a=0, b=0;
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            if(i==3 || i==6)
            {
                b=0;
                a=i;
            }
            HashSet<Integer> setH = new HashSet<Integer>();
            HashSet<Integer> setV = new HashSet<Integer>();
            HashSet<Integer> setB = new HashSet<Integer>();
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')    //Three hashsets, one for vertical check, one for horizontal check and other for box check.
                {
                    if(!setH.add(board[i][j]-'0')) //Vertical and horizontal checks are direct.
                        return false;
                }
                if(board[j][i]!='.')        //Box checks are done based on 3 multiple indexes. For every 3 vertical iterations incrementing one horizontal index. 
                {
                    if(!setV.add(board[j][i]-'0')) //Once horizontal indices are completed, setting horizontal index to 0 and incrementing vertical index by 3.
                        return false;
                }
                if(board[a][b]!='.')
                {
                    if(!setB.add(board[a][b]-'0'))
                        return false;
                }
                if(i<3)
                {                   
                    a++;
                    if(a==3)
                    {
                        a=0;
                        b++;
                    }
                }
                else if(i<6)
                {
                    a++;
                    if(a==6)
                    {
                        a=3;
                        b++;
                    }
                }
                else
                {
                    a++;
                    if(a==9)
                    {
                        a=6;
                        b++;
                    }
                }
            }
        }
        
        return true;
    }
}