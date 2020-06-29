// Time Complexity :O(1) //traversing through a 9*9 matrix is constant time 
// Space Complexity :O(1)  
// Did this code successfully run on Leetcode :yes
class Solution {
    public boolean isValidSudoku(char[][] board) {
      if(board==null || board.length==0) return true;
  
      for(int i=0;i<9;i++)
      {
         if(row(board,i)==false) return false;
      }
   
        
      for(int i=0;i<9;i++)
      {
         if(column(board,i)==false) return false;
      }
         
        
      for(int i=0;i<7;i+=3)
      {
          for(int j=0;j<7;j+=3)
          {
              if(box(board,i,j)==false)
                  return false;
          }
      }
        
    return true;
      
    }
    
    private boolean box(char[][] board,int i,int j)
    {
       HashSet<Character> set=new HashSet<>();
       for(int k=i;k<i+3;k++)
       {
           for(int l=j;l<j+3;l++)
           {
               
               if(board[k][l]=='.')
        			continue;
               
               if(set.contains(board[k][l]))
                   return false;
               
                set.add(board[k][l]);
               
           }
            
       } 
        return true;
    }
    
    private boolean row(char[][] board,int i)
    {
        HashSet<Character> set=new HashSet<>();
        for(int j=0;j<9;j++)
        {
            if(board[i][j]=='.')
        			continue;
            
            if(set.contains(board[i][j]))
                   return false;
  
            set.add(board[i][j]);

        }
        return true;
    }
    
    private boolean column(char[][] board,int i)
    {
        HashSet<Character> set=new HashSet<>();
        for(int j=0;j<9;j++)
        {
            if(board[j][i]=='.')
        			continue;
            
            if(set.contains(board[j][i]))
                   return false;
            
            set.add(board[j][i]);
     
        }
        return true;
    }
    
}