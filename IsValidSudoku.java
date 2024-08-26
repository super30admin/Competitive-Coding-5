// Problem 36. Valid Sudoku
// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxs = new HashSet[N];
        for(int r=0; r < N; r++){
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxs[r] = new HashSet<>();
        }
        for(int r=0; r < N; r++){
            for(int c=0; c < N; c++){
                char v = board[r][c];
                if(v == '.'){
                    continue;
                }
                if(rows[r].contains(v)){
                    return false;
                }
                rows[r].add(v);
                if(cols[c].contains(v)){
                    return false;
                }
                cols[c].add(v);
                int boxIndex = (r/3)*3 + c/3;
                if(boxs[boxIndex].contains(v)){
                    return false;
                }
                boxs[boxIndex].add(v);
            }
        }
        return true;
    }
}
