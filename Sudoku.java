// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Keep sets to track if element has been seen or not
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,ArrayList<Character>> rows = new HashMap<>();
        HashMap<Integer,ArrayList<Character>> cols = new HashMap<>();
        HashMap<Integer,ArrayList<Character>> grid = new HashMap<>();

        for(int i=0;i<9;i++){
            rows.put(i,new ArrayList<>());
            cols.put(i,new ArrayList<>());
            grid.put(i,new ArrayList<>());
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if (board[i][j] == '.') {
                    continue;
                }

                if(rows.get(i).contains(board[i][j]))
                    return false;
                rows.get(i).add(board[i][j]);

                if(cols.get(j).contains(board[i][j]))
                    return false;
                cols.get(j).add(board[i][j]);

                int pos=(i/3)*3+(j/3);

                if(grid.get(pos).contains(board[i][j]))
                    return false;
                grid.get(pos).add(board[i][j]);

            }
        }

        return true;
    }
}