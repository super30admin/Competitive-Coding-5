// Time Complexity : O(n^2*n) n=9 iterating through each cell 81 cells for rows, col, 3*3 grid and through the set or boolean array for each search
// Space Complexity : O(n^2) n=9 considered as constant?
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : --


// Your code here along with comments explaining your approach
//Brute force
class Solution {
    public boolean isValidSudoku(char[][] board) {
       int row = board.length;
        int col = board[0].length;
        for(int i=0;i< row;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<col;j++){
                char ch = board[i][j];
                if(ch=='.')
                    continue;
                if(set.contains(ch))
                    return false;
                else
                    set.add(ch);
            }
        }
        for(int i=0;i< row;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<col;j++){
                char ch = board[j][i];
                if(ch=='.')
                    continue;
                if(set.contains(ch))
                    return false;
                else
                    set.add(ch);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                HashSet<Character> set = new HashSet<>();
                for(int l=0;l<3;l++){
                for(int m=0;m<3;m++){
                char ch = board[3*i+l][3*j+m];
                if(ch=='.')
                    continue;
                if(set.contains(ch))
                    return false;
                else
                    set.add(ch);
            }
        }
            }
        }
        // for(int grid = 0; grid < 9; grid ++){ //loop all the 9 grids 
        //     boolean[] b = new boolean[9];
        //     for(int i = grid/3*3; i< grid/3*3+3; i++){
        //         for(int j=grid%3*3; j< grid%3*3+3; j++){
        //             if(board[i][j]!='.'){
        //             if(b[(int)(board[i][j]-'1')]) return false;
        //             b[(int)(board[i][j]-'1')] = true;
        //          }
        //       }
        //     }
        // }
        return true;
}
}
