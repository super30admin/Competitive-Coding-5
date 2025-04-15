class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] subMatrix = new HashSet[9];

        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            subMatrix[i] = new HashSet<Character>();
        }
    
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m ;i++) {
            for(int j=0; j<n; j++) {

                char curr = board[i][j];
                int k = (i/3)*3 + j/3;
                
                if(curr == '.') {
                    continue;
                }
                if(rows[i].contains(curr)){
                    return false;
                }
                rows[i].add(curr);

                if(cols[j].contains(curr)) {
                    return false;
                }
                cols[j].add(curr);
                
                if(subMatrix[k].contains(curr)) {
                    return false;
                }
                subMatrix[k].add(curr);
            }
        }
        return true;
    }
}
