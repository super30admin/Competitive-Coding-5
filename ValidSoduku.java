// Time Complexity : O(1) since there are only 91 elements
// Space Complexity : O(1) constant space of hashmap will be used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
import java.util.*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null) return true;
        int R = board.length;
        int C = board[0].length;
        HashMap<Integer,Integer> [] row = new HashMap[9];
        HashMap<Integer,Integer> [] column = new HashMap[9];
        HashMap<Integer,Integer> [] box = new HashMap[9];
        
        for(int i = 0 ; i <9; i ++)
        {
            row[i] = new HashMap<Integer,Integer>();
            column[i] = new HashMap<Integer,Integer>();
            box[i] = new HashMap<Integer, Integer>();
        }
        
        for(int i = 0 ; i < R;i++)
        {
            for(int j = 0; j <C;j++)
            {
                int n = board[i][j]-'0';
                if(n >=0)
                {
                     
                int boxIndex = (i/3)*3 + j/3;
                row[i].put(n,row[i].getOrDefault(n,0)+1);
                column[j].put(n,column[j].getOrDefault(n,0)+1);
                box[boxIndex].put(n,box[boxIndex].getOrDefault(n,0)+1);
                
                if(row[i].get(n)>1 || column[j].get(n)>1 || box[boxIndex].get(n)>1)
                    
                {
                    return false;
                }
                
                }
              
            }
        }
        return true;
        
    }
}