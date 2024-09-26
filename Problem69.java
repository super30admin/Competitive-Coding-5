Executed in leetcode-Yes
time complexity - o(n2) - n is no of rows, for n=9, its constant
space complexity-const
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //validate all rows
        HashSet<Integer> vals =new HashSet<Integer>();
        
        for(int i=0;i<9;i++){
            vals =new HashSet<Integer>();
            for(int j=0;j<9;j++){
                if(vals.contains((int)board[i][j])) return false;
                if(board[i][j]!='.') vals.add((int)board[i][j]);   
             }
        }
        
        for(int i=0;i<9;i++){
            vals =new HashSet<Integer>();
            for(int j=0;j<9;j++){
                if(vals.contains((int)board[j][i])) return false;
                if(board[j][i]!='.') vals.add((int)board[j][i]);   
             }
        }
        
        int[] box = new int[] {0,3,6};
        for(int i:box){
            for(int j:box){
                vals =new HashSet<Integer>();
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                       if(vals.contains((int)board[k][l])) return false;
                       if(board[k][l]!='.') vals.add((int)board[k][l]);                
                    }
                }
            }
        }
        
        return true;
    }
        
}
