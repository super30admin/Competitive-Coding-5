class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(board == null || m != 9 || n != 9){
            return false;
        }

        //row 
        for(int i = 0; i < m; i++){
            HashSet<Character> rowSet = new HashSet<>();
            for(int j = 0; j < n; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(!rowSet.contains(c)){
                        rowSet.add(c);
                    }
                    else{
                        return false;
                    }
                    

                }

            }

        }

        //column
        for(int j = 0; j < n; j++){
            HashSet<Character> colSet = new HashSet<>();
            for(int i = 0; i < m; i++){
                char c = board[i][j];
                if(c != '.'){
                    if(!colSet.contains(c)){
                        colSet.add(c);
                    }
                    else{
                        return false;
                    }
                    

                }

            }

        }

        //block
        for(int block = 0; block < 9; block++){
            HashSet<Character> blockSet = new HashSet<>();
            for(int i = block/3 * 3; i < block/3 * 3 + 3; i++){
                for(int j = block % 3 * 3; j < block % 3 * 3 + 3; j++){
                    char c = board[i][j];
                    if(c != '.'){
                        if(!blockSet.contains(c)){
                            blockSet.add(c);
                        }
                        else{
                            return false;
                        }
                    }


                }
            }
        }




        return true;
    }
}
