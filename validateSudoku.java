// Each box should be validated.


class Solution {
    
    public boolean isValidSudoku(char[][] board) {
       
        Set<Character> rows[] = new HashSet[9];
        Set<Character> cols[] = new HashSet[9];
        Set<Character> boxes[] = new HashSet[9];
        
        for (int k=0; k<9; k++)
        {
            rows[k] = new HashSet<>();
            cols[k] = new HashSet<>();
            boxes[k] = new HashSet<>();
        }
        
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                char c = board[i][j];
                
                    if ( c == '.')
                    {
                        continue;   
                    }
                    
                    if (rows[i].contains(c)) 
                    {
                        return false;
                    }
                    
                    rows[i].add(c);
                
                    if (cols[j].contains(c)) 
                    {
                        return false;
                    }
                    
                    cols[j].add(c);
                
                    int box_index = (i / 3) * 3 + (j / 3);
                
                    if (boxes[box_index].contains(c))
                    {
                        return false;
                    }
                
                    boxes[box_index].add(c);
                    
            }
        }
        
        return true;
    }
}
