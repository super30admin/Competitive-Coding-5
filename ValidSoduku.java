
class Solution {
    
      
    public boolean isValidSudoku(char[][] board) {
        if(board == null ) return true;
          
        //rows
        for(int i = 0 ;i < board.length ;i++){
           if(row(i,board) == false ) return false;
        }
        
        //column
        for(int j = 0 ;j < board[0].length ;j++){
          if(column(j,board) == false ) return false; 
        }
        
        //block
        for(int blocki = 0 ; blocki < 7 ;blocki+=3){
            for(int blockj = 0 ; blockj < 7 ;blockj+=3){
                if(block(blocki,blockj,board) == false) return false;              
            }
        }
        
        return true;
        
    }
      

private boolean row(int i,char board[][] ){
    HashSet<Character> rowSet = new HashSet<>();
      for(int j = 0 ;j< board[0].length;j++){
                if(board[i][j] =='.')continue;
                    
                if(rowSet.contains(board[i][j])) return false;
                 
          rowSet.add(board[i][j]);
        }
       return true;
}

private boolean column(int j,char board[][]){
    HashSet<Character> colSet = new HashSet<>();
     for(int i = 0 ;i< board[0].length;i++){
                if(board[i][j] =='.') continue;
                if(colSet.contains(board[i][j])) return false;
                    colSet.add(board[i][j]);
        }
        return true;
}
        
 private boolean block(int i,int j,char board[][]){
     HashSet<Character> blockSet = new HashSet<>();
     for(int m = i ; m <i+3 ;m++){
       for(int n = j ;n <j+3 ;n++){ 
           if(board[m][n] == '.') continue;
           if(blockSet.contains(board[m][n])) return false;
              blockSet.add(board[m][n]);
        }       
     }
     return true;
 }

}
    
            
            
/*
Time Complexity : Worst case traverse through all the elements O(mXn) here mXn is 9*9 ie 81 hence O(1)
Space complexity : O(1)  as n here is all the elements in the soduku ie 9*9  ie 81 in worst case
*/





/*Technique
	HashSet<String> set = new HashSet();
		System.out.println(set.add("SWA"));  --> returns true
		System.out.println(set.add("PNA"));  --> returns true
        System.out.println(set.add("SWA"));   ---> returns false
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) return false;
        
		//Strings of rows,columns ,blocks
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0 ;i < board.length ;i++){
            
            for(int j = 0 ;j <board[0].length;j++){
            
                char currentVal = board[i][j];
                if( currentVal!= '.'){
                   if( !set.add(currentVal+" found in row "+ i)||
                    !set.add(currentVal+" found in col "+ j )||
                    !set.add(currentVal+" found in block "+ i/3 +"-"+j/3 ))
                       return false;
                }
            }
        }   
        
        return true;       
    }
}

/*
Time Complexity : Worst case traverse through all the elements O(mXn) here mXn is 9*9 ie 81 hence O(1)
Space complexity : O(1)  as n here is all the elements in the soduku ie 9*9  ie 81 in worst case
*/