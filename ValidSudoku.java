// Time Complexity : O(mn)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None

public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {

            for(int i = 0; i < 9; i++){
                Set<Character> set = new HashSet<>();
                for(int j = 0; j < 9; j++){
                    if(board[i][j] != '.'){
                        if(set.contains(board[i][j])){
                            return false;
                        }
                        else{
                            set.add(board[i][j]);
                        }
                    }
                }
            }

            for(int i = 0; i < 9; i++){
                Set<Character> set = new HashSet<>();
                for(int j = 0; j < 9; j++){
                    if(board[j][i] != '.'){
                        if(set.contains(board[j][i])){
                            return false;
                        }
                        else{
                            set.add(board[j][i]);
                        }
                    }
                }
            }

            for(int block = 0; block < 9; block++){
                Set<Character> set = new HashSet<>();
                for(int k = block/3*3; k < block / 3*3+3; k++){
                    for(int l = block%3*3; l < block%3*3+3; l++){
                        if(board[k][l] != '.'){
                            if(set.contains(board[k][l])){
                                return false;
                            }
                            else{
                                set.add(board[k][l]);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
