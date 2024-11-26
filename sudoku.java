// Time Complexity : O(MxN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++){			// travere through every column with respect to row 
            HashMap<Character, Integer> map = new HashMap<>();		// record if the element is present or not
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){					// if we encounter the '.', move forward
                    continue;
                }
                if(map.containsKey(board[i][j])){		// if it's already present in the row, return false. violates the sudoku rules
                    return false;
                }else{
                    map.put(board[i][j], 1);		// if we encounter a digit, record the corresponding value
                }
            }
        }
        
        for(int i = 0; i < board[0].length; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == '.'){		// if we encounter the '.', move forward
                    continue;
                }
                if(map.containsKey(board[j][i])){		// if it's already present in the row, return false. violates the sudoku rules
                    return false;
                }else{
                    map.put(board[j][i], 1);		// if we encounter a digit, record the corresponding value
                }
            }
        }
        
        for(int i=0; i<9; i+=3){			// condition to move through 3x3 matrix
            for(int j=0; j<9; j+=3){
                HashMap<Character, Integer> map = new HashMap<>();
                for(int k=i; k<i+3; k++){		// condition to traverse inside the 3x3 matrix
                    for(int l=j; l<j+3; l++){
                        if(board[k][l] == '.')		// if we encounter the '.', move forward
                            continue;
                        if(map.containsKey(board[k][l])){		// if it's already present in the row, return false. violates the sudoku rules
                            return false;
                        }else{
                            map.put(board[k][l], 1);		// if we encounter a digit, record the corresponding value
                        }
                    }
                }
            }
        }
        
        return true;		// return true if we traverse completely.
    }
}