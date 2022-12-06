//Time complexity is O(M*N)
//Space complexity is 3*O(M*N)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n =9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] grids = new HashSet[n];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                Character val = board[i][j];
                
                if(board[i][j]!='.'){
                    if(rows[i]==null){
                        rows[i]=new HashSet<Character>();
                    }
                    if(rows[i].contains(val)){
                        return false;
                    }
                    else{
                        rows[i].add(val);
                    }
                    
                    
                    //Checking columns
                    if(cols[j]==null){
                        cols[j]=new HashSet<Character>();
                    }
                    if(cols[j].contains(val)){
                        return false;
                    }
                    else{
                        cols[j].add(val);
                    }
                    
                    //Checking grids
                    int gridnum = (i/3)*3+(j/3);
                    if(grids[gridnum]==null){
                        grids[gridnum]=new HashSet<Character>();
                    }
                    if(grids[gridnum].contains(val)){
                        return false;
                    }
                    else{
                        grids[gridnum].add(val);
                    }
                    
                }
            }
        }
        return true;
    }
}