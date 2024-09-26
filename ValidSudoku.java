import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Time Complexity : O(1)
//Space Complexity :O(1) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :



public class ValidSudoku {
	  List<Set<Character>> column = new ArrayList<>();
	    List<Set<Character>> row = new ArrayList<>();
	    List<Set<Character>> cube = new ArrayList<>();
	    
	    
	    public boolean isValidSudoku(char[][] board) {
	        for(int i=0;i<9;i++){
	             column.add(new HashSet<>());
	            row.add(new HashSet<>());
	            cube.add(new HashSet<>());
	            
	        }
	        
	        
	        for(int i=0;i<9;i++){
	         
	            for(int j=0;j<9;j++){
	               
	                char ch = board[i][j];
	             
	              if(Character.isDigit(ch)){
	                  // check row validity    
	                  if(row.get(i).contains(ch)){
	                      return false;
	                  }else{
	                      row.get(i).add(ch);
	                  }
	                 
	                  //check column validity 
	                     // check row validity    
	                  if(column.get(j).contains(ch)){
	                      return false;
	                  }else{
	                      column.get(j).add(ch);
	                  }
	                  // check cube validity
	                  int r = i/3;
	                  int c = j/3;
	                  int cubeIndex = r*3 + c;
	                   if(cube.get(cubeIndex).contains(ch)){
	                      return false;
	                  }else{
	                      cube.get(cubeIndex).add(ch);
	                  }
	                  
	              }  
	              
	                
	            }
	            
	        }
	        
	        return true;
	        
	    }
}
