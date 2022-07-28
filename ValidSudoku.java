//TC:O(m*n)
//SC:O(m+n)
//Pramp
//We are using hashset because it does not contains any duplicate keys and elements in pair.consider the board for i elements as row and j elements as col and check wheather the board is empty then if contains then return false else add both row and col values to board.Check whether box contains duplicate elements in it  and it contains duplicate elements then return false else add the element to board and return true at the end of the result.
class Solution {
    public boolean isValidSudoku(char[][] board) {
    HashSet<String> h1 = new HashSet<String>();
        
        for(int i=0; i < 9; i++){
            for(int j=0; j< 9; j++){
                if(board[i][j] != '.'){
                    
                //Check whether HashSet contains duplicate elements in row and column 
                if(h1.contains("row" + i + board[i][j]) || h1.contains("col" + j + board[i][j]) ){
                    return false;
                }
                h1.add("row" + i + board[i][j]);
                h1.add("col" + j + board[i][j]);
                
                
                //Check whether Box contains duplicate elements in it
                if(h1.contains("box"+ (i/3)*3 + j/3 + board[i][j])){
                    return false;
                }
                h1.add("box"+ (i/3)*3 + j/3 + board[i][j]);
                }
            }
        }
        return true;
    }
}
   