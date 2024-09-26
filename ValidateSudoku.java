

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col= new HashSet<>();
            Set<Character> grid=new HashSet<>();
            for(int j=0;j<9;j++){
                int rowIndex= 3*(i/3)+j/3;
                int colIndex=3*(i%3)+j%3;
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!col.add(board[j][i])){
                    return false;
                }
                if(board[rowIndex][colIndex]!='.'&&!grid.add(board[rowIndex][colIndex])){
                    return false;
                }
            }
        }
        return true;
    }
}

//Time Complexity:O(m*n) 
//Space Complexity:O(1)
//Here use of hashset for row, column, and grid to be used
