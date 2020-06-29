/**
 * Time Complexity : O(1) 
 * Space Complexity : O(1) as we are using constant space 9x9=81
 */

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Map<Integer,Integer> rows[] = new HashMap[n];
        Map<Integer,Integer> columns[] = new HashMap[n];
        Map<Integer,Integer> blocks[] = new HashMap[n];
        
        for(int i=0;i<n;i++){
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            blocks[i] = new HashMap<>();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] != '.'){
                    char c = board[i][j];
                    int num = Integer.parseInt(String.valueOf(c));
                    int k = (i/3)*3+j/3;
                    
                    rows[i].put(num,rows[i].getOrDefault(num,0)+1);
                    columns[j].put(num,columns[j].getOrDefault(num,0)+1);
                    blocks[k].put(num,blocks[k].getOrDefault(num,0)+1);
                    
                    
                    if(rows[i].get(num) > 1 || columns[j].get(num) > 1 || blocks[k].get(num) > 1) return false;
                }
            }
        }
        return true;
        
    }
}