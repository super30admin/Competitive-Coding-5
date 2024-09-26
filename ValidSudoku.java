public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9) return false;

        // rows:
        for(int row=0;row<9;row++){
            boolean[] arr = new boolean[9];
            for(int col=0;col<9;col++){
                if(board[row][col]=='.')continue;
                int value = board[row][col]-'1';
                if(arr[value]){
                    return false;
                }
                arr[value] = true;


            }
        }

        //cols:
        for(int col=0;col<9;col++){
            boolean[] arr = new boolean[9];
            for(int row=0;row<9;row++){
                if(board[row][col]=='.')continue;
                int value = board[row][col]-'1';
                if(arr[value]){
                    return false;
                }
                arr[value]=true;

            }
        }

        //3*3 box
        for(int block=0;block<9;block++){
            boolean[] arr = new boolean[9];

            for(int row=(block/3)*3;row<(block/3)*3 + 3;row++){
                for(int col=(block%3)*3;col<(block%3)*3 + 3;col++){
                    if(board[row][col]!='.'){
                        int value = board[row][col]-'1';
                        if(arr[value]==false){
                            arr[value]=true;
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
