//time complexity: O(n)
//space complexity: O(n)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> setBlock;
        HashSet<Character> setRow;
        HashSet<Character> setCol;
        //iter through row
        for(int i=0;i<9;i++){
            setRow = new HashSet<>();
            for(int j=0;j<9;j++){
                if((board[i][j]!='.')){
                    if(setRow.contains(board[i][j] ) ){
                        return false;
                    }
                    else setRow.add(board[i][j]);
                }
            }
        }
        //iter through col
        for(int i=0;i<9;i++){
            setCol = new HashSet<>(9);
            for(int j=0;j<9;j++){
                if((board[j][i]!='.')){
                if(setCol.contains(board[j][i])) return false;
                else setCol.add(board[j][i]);
                }
            }
        }
        //iter through block
        for(int k=0;k<9;k++){
            setBlock = new HashSet<>();
            for(int i=k/3*3;i<k/3*3+3;i++){
                for(int j=k%3*3;j<k%3*3+3;j++){
                    //int index = (i/3) *3 + (j/3);
                    if((board[i][j]!='.')){
                        if(setBlock.contains(board[i][j])) return false;
                        else setBlock.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}