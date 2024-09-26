//https://leetcode.com/problems/valid-sudoku/
//Time complexity : O(1)    
//Space complexity : O(1)

//if the matrix size was not constant then
//Time complexity : O(M*N)    
//Space complexity : O(M+N)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> r = new ArrayList<>();
        List<Set<Integer>> c = new ArrayList<>();
        List<Set<Integer>> b = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            r.add(new HashSet<Integer>());
            c.add(new HashSet<Integer>());
            b.add(new HashSet<Integer>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    if (r.get(i).add(val) == false || c.get(j).add(val) == false
                            || b.get(getIndex(i, j)).add(val) == false) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int getIndex(int i, int j) {
        int row = 0;
        int col = 0;
        if (i <= 2) {
            row = 0;
        } else if (i <= 5) {
            row = 1;
        } else {
            row = 2;
        }

        if (j <= 2) {
            col = 0;
        } else if (j <= 5) {
            col = 1;
        } else {
            col = 2;
        }

        return (row * 3) + col;

    }
}
