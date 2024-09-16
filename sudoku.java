/* Time complexity: O(m*n)
Space complexity: O(1)
*/
class Solution {
    HashSet<Character> set; int count;
    public boolean isValidSudoku(char[][] board) {        
        if(board.length == 0 || board == null) return true;
        
        for(int i=0; i<9; i++){
            set = new HashSet<>(); count = 0;
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') count ++;                
                set.add(board[i][j]);                               
            }
        }        
        if(set.size() + count < 9) return false;
        
        for(int i=0; i<9; i++){
            set = new HashSet<>(); count = 0;
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') count ++;                
                set.add(board[i][j]);           
            }
        }        
        if(set.size() + count < 9) return false;
        
        
        int right = 3; int down = 3;
        while(true){
            while(right<=9 && down <= 9){
                set = new HashSet<>(); count = 0;
                for(int i=down-3; i<down; i++){                    
                    for(int j=right-3; j<right; j++){
                        if(board[i][j] == '.') count ++;                
                        set.add(board[i][j]); 
                    }
                    
                }
                if(set.size() + count < 9) return false;
                right += 3;                
            }
            down += 3;
            right = 3;
            if(down > 9){
                break;
            }
        }
        return true;        
        
    }
}

