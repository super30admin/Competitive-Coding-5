// Time Complexity : O(n^2) for every row and column; n=9;
// Space Complexity : O(n) space for hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class ValidSudoku {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(board[i][j]) && board[i][j]!='.'){
                    //System.out.println(board[i][j]);
                    return false;
                }
                else{
                    set.add(board[i][j]);
                }
            }
        }
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(board[j][i]) && board[j][i]!='.'){
                    //System.out.println(board[j][i]);
                    return false;
                }
                else{
                    set.add(board[j][i]);
                }
            }
        }

        for(int i=1;i<=7;i+=3){
            for(int j=1;j<=7;j+=3){
                HashSet<Character> set = new HashSet<>();
                set.add(board[i][j]);
                for(int[] dir:dirs){
                    int r = i+dir[0];
                    int c = j+dir[1];
                    if(set.contains(board[r][c]) && board[r][c]!='.'){
                        //System.out.println(board[r][c]);
                        return false;
                    }
                    else{
                        set.add(board[r][c]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidSudoku vs = new ValidSudoku();
        char[][] sudoku = new char[][]{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(vs.isValidSudoku(sudoku));
    }
}