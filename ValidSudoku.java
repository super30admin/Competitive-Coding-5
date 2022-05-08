// Time Complexity :O(N^2)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        if(board == null || board.length == 0){
            return false;
        }


        Set<Integer> set = new HashSet<>();



        for(int i = 0; i < board.length; i++){
            // Checking for rows
            for(int j = 0; j < board[i].length; j++){
                Character c = board[i][j];

                if(c != '.' ){
                    int num = c.getNumericValue(c);
                    if(set.contains(num)){
                        return false;
                    }else{
                        set.add(num);
                    }
                }
            }
            // System.out.println(set);
            set = new HashSet<>();


            //Checking for columns
            for(int k = 0; k < board.length; k++){
                Character c = board[k][i];

                if(c != '.' ){
                    int num = c.getNumericValue(c);
                    if(set.contains(num)){
                        return false;
                    }else{
                        set.add(num);
                    }
                }
            }
            // System.out.println(set);
            set = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++){ // loop for 9 grids

            // System.out.println("----------------------");


            for(int j = 0; j < board.length; j++){
                int row = ((i / 3) * 3) + j / 3;
                int col = ((i % 3) * 3)+ j % 3;

                Character c = board[row][col];
                // System.out.println(c);

                if(c != '.' ){
                    int num = c.getNumericValue(c);
                    if(set.contains(num)){
                        return false;
                    }else{
                        set.add(num);
                    }
                }
            }
            // System.out.println(set);
            set = new HashSet<>();
            // System.out.println("----------------------");

        }


        return true;
    }
}
