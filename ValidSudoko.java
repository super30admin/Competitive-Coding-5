/*
Thought Process: 
Loop through to find valid row sudoko, then find valid col sudoko and finally valid 3*3 box sudoko.

TC -> O(1) 3 pass solution, but since board is constant 9*9. The TC will not be O(N)
SC -> O(1) 
*/


class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        
        // Mistake commited: Was very difficult to understand this boxSet concept and implement it
        Set<Integer> [] boxSet = new HashSet[9];
        
        // Looping through to find valid row sudoko
        for(int i=0; i<9; i++){
            Set<Integer> rSet = new HashSet<>();
            for(int j=0; j<9; j++){
                char num = board[i][j];
                if(num!= '.'){
                    int n = (int)num;
                    if(rSet.contains(n)) return false;
                    else rSet.add(n);
                }
            }
            //Initializing 9 boxSets
            boxSet[i]  = new HashSet<Integer>();
        }
        
        // Looping through to find valid col sudoko
        for(int j=0; j<9; j++){
            Set<Integer> cSet = new HashSet<>();
            for(int i=0; i<9; i++){
                char num = board[i][j];
                if(num!= '.'){
                    int n = (int)num;
                    if(cSet.contains(n)) return false;
                    else cSet.add(n);
                }
            }
        }
        
        //Looping through to find vaild 3*3 valid box sudoko
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char num = board[i][j];
                if(num!= '.'){
                    int n = (int)num;
                    int boxIndex = ((i/3)*3) + (j/3);
                    if(boxSet[boxIndex].contains(n)) return false;
                    else boxSet[boxIndex].add(n);
                }
            }
        }
        return true;
    }
}