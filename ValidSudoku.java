// Approach 1:
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Check if each row, column and block does not have duplicate digits
// Use a hashmap to check for duplication

class Solution {
    private boolean check3(char[][] board, int sr, int sc){
        HashSet<Character> set = new HashSet<>();
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                System.out.println("i"+i+"j:"+j);
                if(Character.isDigit(board[i][j]))
                    {
                        if(set.contains(board[i][j]))
                            return false;
                    set.add(board[i][j]);}
            }
        }
        return true;
    }
       private boolean checkRow(char[][] board, int sr){
        HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(Character.isDigit(board[sr][j]))
                    {if(set.contains(board[sr][j]))
                        return false;
                    set.add(board[sr][j]);}
            }
            return true;
        }
    private boolean checkCol(char[][] board,int sc){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
                if(Character.isDigit(board[i][sc]))
                    {if(set.contains(board[i][sc]))
                        return false;
                    set.add(board[i][sc]);}
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i=i+3)
            for(int j=0;j<9;j=j+3){
                System.out.println("i"+i+"j:"+j);
                if(check3(board,i,j)==false)
                    return false;
            }
        for(int i=0;i<9;i++){
            if(checkCol(board,i)==false)
                return false;
            if(checkRow(board,i)==false)
                return false;
        }
        return true;
    }
}

// Approach 2
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can initialize 3 hashsets for every row, column and grid
// In this approach we will just go over every element once(compared to thrice in Approach1), and add entries to the 3 hashsets
// We traverse the matrix and return false if duplicates are found in any of the three hashsets

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grid = new HashSet[9];
        for(int i=0;i<9;i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            grid[i] = new HashSet<Character>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                if(rows[i].contains(board[i][j]))
                    return false;
                rows[i].add(board[i][j]);
                if(cols[j].contains(board[i][j]))
                    return false;
                cols[j].add(board[i][j]);
                int gridIdx = (i/3)*3 + (j/3);
                if(grid[gridIdx].contains(board[i][j]))
                    return false;
                grid[gridIdx].add(board[i][j]);
            }
        }
        return true;
    }
}
