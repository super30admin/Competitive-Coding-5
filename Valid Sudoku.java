// Time Complexity :O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set= new HashSet<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
        {
            if(board[i][j]!='.')
            {
                if(!set.add(board[i][j]+"found in row"+i) || !set.add(board[i][j]+"found in col"+j) || !set.add(board[i][j]+" "+i/3 +" "+j/3))
                {
                    //  System.out.println(set.get(board[i][j]+" "+i));
                    //  System.out.println(set.get(board[i][j]+" "+i));
                    //  System.out.println(set.get(board[i][j]+" "+i));
                    return false;
                    
                }
                

            }
        }
        }
        return true;
    }
}