// Time Complexity : O(9^3)
// Space Complexity : O(9*9*3) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //if board is empty or row or column length is != 9 return false
        if(board == null || board.length != 9 || board[0].length!= 9) return false;
        
        //check if repeat in row
        for(int i = 0; i < 9; i++) {
            //for each row create a new boolean check array
            //we make values position (index in check array) true for the values in the sudoku
            boolean [] check = new boolean [9];
            //iterate through the column one by one for each row
            for(int j = 0; j < 9; j++) {
                //if board has a value and is not "."
                if(board[i][j] != '.') {
                    //check if for that value (index position in boolean array) is already true
                    //if already true, same number found so return false
                    //else make that position true
                    if(check[board[i][j]-'1'])return false;
                    else check[board[i][j]-'1'] = true;
                }
            }
        }
        
        //check if repeat in column
        for(int j = 0; j < 9; j++) {
            //for each column create a new boolean check array
            //we make values position (index in check array) true for the values in the sudoku
            boolean [] check = new boolean [9];
            //iterate through the row one by one for each column
            for(int i = 0; i < 9; i++) {
                //if board has a value and is not "."
                if(board[i][j] != '.') {
                    //check if for that value (index position in boolean array) is already true
                    //if already true, same number found so return false
                    //else make that position true
                    if(check[board[i][j]-'1'])return false;
                    else check[board[i][j]-'1'] = true;
                }
            }
        }
        
        //check if repeat in subbox
        for(int subbox = 0; subbox < 9; subbox++) {
            //subboxes are 3*3 boxes 
            //see positions down
            //for each subbox create a new boolean check array
            //we make values position (index in check array) true for the values in the sudoku
            boolean [] check = new boolean [9];
            //calculate starting row and ending row index for each subbox
            for(int i = subbox/3*3; i < subbox/3*3+3; i++) {
                //calculate starting column and ending column index for each subbox
                for(int j = subbox%3*3; j < subbox%3*3+3; j++) {
                    //if board has a value and is not "."
                    if(board[i][j] != '.') {
                        //check if for that value (index position in boolean array) is already true
                        //if already true, same number found so return false
                        //else make that position true
                        if(check[board[i][j]-'1'])return false;
                        else check[board[i][j]-'1'] = true;
                    }
                }
            }
        } return true; //if no reps found in row/col/subbox return true    
    }
}



/*
row = i
column = j

subboxs : 
0 : i(0,3) ; j(0,3)
1 : i(0,3) ; j(3,6)
2 : i(0,3) ; j(6,9)
3 : i(3,6) ; j(0,3)
4 : i(3,6) ; j(3,6)
5 : i(3,6) ; j(6,9)
6 : i(6,9) ; j(0,3)
7 : i(6,9) ; j(3,6)
7 : i(6,9) ; j(6,9)

*/

////////////

// Time Complexity : O(9^3*3^3)
// Space Complexity : O(9*9*3) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null) return true; 
        
       //row 
        for(int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j])) return false; 
                    else {
                        set.add(board[i][j]);
                    }
                }
            }          
        }
        
        
        for(int j = 0; j < 9; j++) {
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j])) return false; 
                    else {
                        set.add(board[i][j]);
                    }
                }
            }          
        }
        
        
        for(int i = 0; i < 9; i+=3) { 
            for(int j = 0; j < 9; j+=3) {
                HashSet<Character> set = new HashSet<>();
                for(int k = i; k < i+3; k++) {
                    for(int l = j; l < j+3; l++) {
                        if(board[k][l] != '.') {
                            if(set.contains(board[k][l])) return false; 
                            else {
                                set.add(board[k][l]);
                            }
                        }                       
                    }
                }             
            }          
        } return true;      
    }
}


