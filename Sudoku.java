import java.util.HashMap;
import java.util.Map;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        //row check
        for(int i = 0 ; i< m ; i++)
        {
             Map<Character,Integer> map = new HashMap<>();
            for(int j = 0; j< n; j++)
            {
           
            if(board[i][j] != '.' && map.containsKey(board[i][j]))
            {
                return false;
            }
            map.put(board[i][j],1);
            }
        }
        for(int i = 0 ; i< m ; i++)
        {
            Map<Character,Integer> map = new HashMap<>();
            for(int j = 0; j< n; j++)
            {
            
            if(board[j][i] != '.' && map.containsKey(board[j][i]))
            {
                return false;
            }
            map.put(board[j][i],1);
            System.out.println(board[j][i]);
            }
              System.out.println("##");
        }
        for(int block = 0; block < 9; block++)
        {
            Map<Character,Integer> map = new HashMap<>();
             for(int i = block/3*3 ; i< block/3*3+3; i++)
            {
            for(int j = block%3*3; j< block%3*3+3; j++)
            {
            
            if(board[i][j] != '.' && map.containsKey(board[i][j]))
            {
                return false;
            }
            map.put(board[i][j],1);
     
            }
        }
        }
        
        return true;
    }
}
