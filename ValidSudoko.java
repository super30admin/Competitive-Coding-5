/*
time complexity: O(mn) -> O(1), here m and n are fixed size of 9, therefore constant time
space complexity : O(mn) -> O(1), again constant as 9 x 9 matrix 
*/
class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0 || board == null)return false;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i =0 ;i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){         
                //create unique string for each cell to check if the vlaue repeats in that 
                //row / column/ 3 x 3 cell too
                // i,value,j
                //i , value
                //value, j          
               //for 3x3 cell:
                if(board[i][j] != '.'){
                    int nr = i/3;//box id's
                    int nc = j/3;//box id's
                    String valueStr = "[" + board[i][j] + "]";
                    
                    String boxStr = nr+" "+ valueStr +" "+nc;
                    
                    String rowStr = valueStr + i;

                    String colStr = j + valueStr ;

                    //if set already contains any of the strings, then its not unique
                    if(set.contains(boxStr) || set.contains(rowStr) || set.contains(colStr)){
                        return false;
                    }else{
                        set.add(boxStr);
                        set.add(rowStr);
                        set.add(colStr);
                    }   
                }
                       
        }
    }
        
        return true;
        
    }
}