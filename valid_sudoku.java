/**
 * Brute Force
 * Time O(1) as its 9*9 constant time
 * Space: O(1) no auxiliary space used
 */
class Solution {
    public boolean isValidSudoku(char[][] b) {
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                if(b[i][j] != '.'){
                    if(!helper(b,i,j)) return false;
                }
            }
        }
        return true;
    }
    private boolean helper(char[][] b,int r, int c){
        //row
        for(int i=0;i<9;i++){
            if(i == c) continue;
            if(b[r][i] == b[r][c]) return false;
        }

        for(int i=0;i<9;i++){
            if(i == r) continue;
            if(b[i][c] == b[r][c]) return false;
        }

        int br = r, bc = c;
        while(br%3 != 0)
            br--;
        while(bc%3 != 0)
            bc--;

        // System.out.println(r+" "+c+" "+br+" "+bc);
        for(int i=br; i<br+3; i++){
            for(int j=bc; j<bc+3;j++){
                if(i == r && j==c) continue;
                if(b[i][j] == b[r][c]) return false;
            }
        }
        return true;
    }
}

/**
 * Array of HashMaps
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}