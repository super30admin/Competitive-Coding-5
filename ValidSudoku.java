class ValidokudSu {
    public boolean isValidSudoku(char[][] board) {

        //Row Check
        for(int i=0; i<board.length; i++){
            HashSet<Character> rowSet = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != '.'){
                    if(!rowSet.contains(board[i][j])){
                        rowSet.add(board[i][j]);
                    }
                    else
                        return false;
                }
            }
        }

        //Column Check
        for(int i=0; i<board.length; i++){
            HashSet<Character> colSet = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(board[j][i] != '.'){
                    if(!colSet.contains(board[j][i])){
                        colSet.add(board[j][i]);
                    }
                    else
                        return false;
                }
            }
        }

        //3*3 Matrix Duplicate
        int[][] boundary = new int[][]{{0,0}, {0,3}, {0,6}, {3,0}, {6,0}, {3,3}, {6,6}, {6,3}, {3,6}};

        for(int k=0; k<boundary.length; k++){
            int m = boundary[k][0];
            int n = boundary[k][1];
            HashSet<Character> boundarySet = new HashSet<>();
            for(int i=m; i<m+3; i++){
                for(int j=n; j<n+3; j++){
                    if(board[i][j] != '.'){
                        if(!boundarySet.contains(board[i][j])){
                            boundarySet.add(board[i][j]);
                        }
                        else
                            return false;
                    }
                } 
            }
        }
        return true;
    }
}