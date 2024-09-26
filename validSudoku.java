//Time Complexity:O(1) since in one iteration, all 81 cells can be covered.
//Space Complexity:O(1)
//In this problem, I'll be having 3 hash sets to hold the elements in the rows, columns and in the 3x3 cube. I'll then iterate over the rows and columns and calculate the row index and column index for the 3x3 cube, such that in one single iteration. I would be able to iterate through the whole row/col. I'll then check if the current element is not equal to 0 and if I can add it to my hashset. If I can not, that means I have encountered a duplicate and hence, I'll return false.
//This code was executed successfully and got accepted in leetcode. 

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col= new HashSet<>();
            Set<Character> cube=new HashSet<>();
            for(int j=0;j<9;j++){
                int rowIndex= 3*(i/3)+j/3;
                int colIndex=3*(i%3)+j%3;
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!col.add(board[j][i])){
                    return false;
                }
                if(board[rowIndex][colIndex]!='.'&&!cube.add(board[rowIndex][colIndex])){
                    return false;
                }
            }
        }
        return true;
    }
}