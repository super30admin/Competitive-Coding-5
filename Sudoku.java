// Time Complexity : O(1) n is number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        
        if(board==null || board.length==0) return true;
        
        HashMap<Integer,Integer>[] row = new HashMap[9];
        HashMap<Integer,Integer>[] col = new HashMap[9];
        HashMap<Integer,Integer>[] box = new HashMap[9];
        
        for(int i=0;i<9;i++){
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char n = board[i][j];
                if(n!='.'){
                int n_i = (int)n;
                int box_ind = (i/3)*3 + j/3;
                
                row[i].put(n_i,row[i].getOrDefault(n_i,0)+1);
                col[j].put(n_i,col[j].getOrDefault(n_i,0)+1);
                box[box_ind].put(n_i,box[box_ind].getOrDefault(n_i,0)+1);
                
              //  System.out.println(n_i+","+row[i].get(n_i) + ","+col[j].get(n_i) + "," + box[box_ind].get(n_i));
                
                if(row[i].get(n_i)>1 || col[j].get(n_i)>1 || box[box_ind].get(n_i)>1)
                    return false;
                }
            }
        }
        return true;
    }
}