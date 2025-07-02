// TC : O(n^2) ~ O(9) as n will always be 3 ~ O(1)
// SC : O(3(n^2)) ~ O(1)  

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;        
        //row && col
        for(int i = 0; i < n; i++){
            HashSet<Character> rSet = new HashSet<>();
            HashSet<Character> cSet = new HashSet<>();
            for(int j = 0; j < n; j++){
                char val = board[i][j];
                if(val != '.'){                    
                    if(!rSet.contains(val)){
                        rSet.add(val);
                    } else {
                        return false;
                    }
                }
                val = board[j][i];
                if(val != '.'){                    
                    if(!cSet.contains(val)){
                        cSet.add(val);
                    } else {
                        return false;
                    }                    
                }
            }
        }
                
        //sub-boxes
        for(int i = 0; i < n; i += 3){            
            for(int j = 0; j < n; j += 3){
                HashSet<Character> s = new HashSet<>();
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++){
                        char val = board[k][l];
                        if(val != '.'){
                            
                            if(!s.contains(val)){
                                s.add(val);
                            } else {
                                return false;
                            }                                        
                        }
                    }
                }                
            }
        }
        return true;
    }
}