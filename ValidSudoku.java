import java.util.HashSet;
//Time Complexity : O(n)= O(1); n=81 i.e.Total number of cells
//Space Complexity : O(n)

public class ValidSudoku {	
	 public static boolean isValidSudoku(char[][] board) {	        
        HashSet<Character>[] rows= new HashSet[9];
        HashSet<Character>[] cols= new HashSet[9];
        HashSet<Character>[] subGrids= new HashSet[9];        
        for(int i=0; i<9; i++) {
        	rows[i]= new HashSet<>();
        	cols[i]= new HashSet<>();
        	subGrids[i]= new HashSet<>();
        }
                
        for(int i=0; i<board.length; i++){
             for(int j=0; j<board[0].length; j++){                
                if(board[i][j]=='.'){
                	continue;
                }
                
            	//Check if char is not unique in row
            	if(rows[i].contains(board[i][j])) {
            		return false;
            	}
            	rows[i].add(board[i][j]);
            	
            	//Check if char is not unique in column                
            	if(cols[j].contains(board[i][j])) { 
                		return false;
                }
            	cols[j].add(board[i][j]);
                                 
                    
            	//Check if char is not unique in subgrid of 3*3
            	int idx= (i/3)*3 + j/3;
            	if(subGrids[idx].contains(board[i][j])) {
            		return false;
            	}  
            	subGrids[idx].add(board[i][j]);
            }
        }        
        return true;
    }
	
	public static void main (String[] args) {
		char[][] grid=new char[][] 
				{{'4','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};
		
		System.out.println("Is Sudoku Valid: "+ isValidSudoku(grid));				
	}
}
