class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length<1) return false;
        int m = board.length;
        
        //Various Columns across each row
        for(int i = 0;i<m; i++){
            Set<Integer> hs = new HashSet<>();
            for(int j = 0; j<m; j++){
                int val = board[i][j] - '0';
                if(Character.isDigit(board[i][j])){
                    if(!hs.contains(val)) hs.add(val);
                    else return false;
                }
            }
        }
        
        //Various ROWS across each COLUMN
        for(int j = 0;j<m; j++){
            Set<Integer> hs = new HashSet<>();
            for(int i = 0; i<m; i++){
                int val = board[i][j] - '0';
                if(Character.isDigit(board[i][j])){
                    if(!hs.contains(val)) hs.add(val);
                    else return false;
                }
            }
        }
        
        //For each Block across matrix - SPIRAL SEARCH
        int i =0;
        int j =0;
        while(i<3){
            while(j<3){
                Set<Integer> hs = new HashSet<>();
                
                int left = 3*j;
                int right = 3*j + 2;
                
                int top = 3*i;
                int bottom = 3*i + 2;
                
                int n = 0;

                while(n<9 && left<=right && bottom>=top){
                    for(int x = left; x<=right; x++){
                        int val = board[top][x] - '0';
                        if(Character.isDigit(board[top][x])){
                            if(!hs.contains(val)) hs.add(val);
                            else return false;
                        }
                        n++;
                }
                top++;
                
                if(top<=bottom){
                    for(int x = top; x<=bottom; x++){
                        int val = board[x][right] - '0';
                        if(Character.isDigit(board[x][right])){
                            if(!hs.contains(val)) hs.add(val);
                            else return false;
                        }
                        n++;
                    }
                    right--;
                }else continue;
                
                if(left<=right){
                    for(int x = right; x>=left; x--){
                        int val = board[bottom][x] - '0';
                        if(Character.isDigit(board[bottom][x])){
                            if(!hs.contains(val)) hs.add(val);
                            else return false;
                        }
                        n++;
                    }
                    bottom--;
                }
                
                if(bottom>=top){
                    for(int x = bottom; x>=top; x--){
                        int val = board[x][left]-'0';
                        if(val>=0 && val<=9){
                            if(!hs.contains(val)) hs.add(val);
                            else return false;
                        }
                        n++;
                    }
                    left++;
                }
                }
                j +=1;
            }
            j = 0;
            i++;
        }
        return true;
    }
}