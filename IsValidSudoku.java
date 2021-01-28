// Time Complexity : The time complexity is O(1)
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {

        if(board == null || board[0] == null){
            return true;
        }

        Set<String> set = new HashSet<>();

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(board[i][j] == '.'){
                    continue;
                }

                // Encode the cell with respect to row
                String row = "r" + i + board[i][j];

                // Encode the cell with respect to column
                String column = "c" + j + board[i][j];

                int a = i/3;
                int b = j/3;

                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(board[i][j]);
                sb.append(b);

                // Encode the cell with respect to 3*3 matrix
                String matrix = sb.toString();

                // If encodes maches
                if(set.contains(row) || set.contains(column) || set.contains(matrix)){
                    return false;
                }

                set.add(row);
                set.add(column);
                set.add(matrix);
            }
        }

        return true;

    }
}

