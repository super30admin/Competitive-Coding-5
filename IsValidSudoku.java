
class Solution {
    public boolean isValidSudoku(char[][] grid) {
        
        
        for(int i = 0; i < 9; i= i + 3) {
            for(int j = 0; j < 9; j = j + 3) {
                HashSet<Character> hset = new HashSet<>();
                for(int x = i; x < i + 3; x++) {
                    for(int y = j; y < j + 3; y++) {
	  //mat is the name of the sudoku matrix
                char currchar = grid[x][y];
	    //when current cell in sudoku is not "." empty
                if(currchar != '.') {
            //check if hashset already contains currchar, return false if it
	 //is already intialized in set
	     if (hset.contains(currchar))
                    return false;
                    //else add it to set
                    hset.add(currchar);
                    }
                }
            }
        }
    }
//rows
            for(int i = 0; i < 9; i ++) {
                HashSet<Character> hset = new HashSet<>();
             	 for(int j = 0; j < 9;  j ++) {
	  //mat is the name of the sudoku matrix
                char currchar = grid[i][j];
	    //when current cell in sudoku is not "." empty
                if(currchar != '.') {
            //check if hashset already contains currchar, return false if it
	 //is already intialized in set
	     if (hset.contains(currchar))
                    return false;
                    //else add it to set
                    hset.add(currchar);
                    }
                }
            }
//columns
            for(int i = 0; i < 9; i++) {
                HashSet<Character> hset = new HashSet<>();
             	 for(int j = 0; j < 9;  j ++) {
	  //mat is the name of the sudoku matrix
                char currchar = grid[j][i];
	    //when current cell in sudoku is not "." empty
                if(currchar != '.') {
            //check if hashset already contains currchar, return false if it
	 //is already intialized in set
	     if (hset.contains(currchar))
                    return false;
                    //else add it to set
                    hset.add(currchar);
                    }
                }
            }
                
             return true;   
            }
    }
    