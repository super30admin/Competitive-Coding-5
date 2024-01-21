/*
* Time Complexity: O(m*n)
* 
* Space Complexity: O(1)
* 
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
       int m = board.length, n = board[0].length;

      for(int rowIndex = 0; rowIndex<m; rowIndex++){
            for(int colIndex=0; colIndex<n; colIndex++){
                int i = rowIndex, j=colIndex;
                
                //cols
                boolean[] rowVisited = new boolean[10];
                while(i<m){
                    if(board[i][j]!='.'){
                        int index = board[i][j] - '0';
                       
                        if(rowVisited[index])
                            return false;
                        rowVisited[index] = true;
                    }
                    i++;
                }

                // rows
                i=rowIndex;
                j=colIndex;
                boolean[] colVisited = new boolean[10];
                while(j<n){
                    if(board[i][j]!='.'){
                        int index = board[i][j] - '0';
                        if(colVisited[index])
                            return false;
                        colVisited[index] = true;
                    }
                    j++;
                }
            }
        }

        for(int rowIndex = 0; rowIndex<m; rowIndex = rowIndex + 3){
            for(int colIndex=0; colIndex<n; colIndex = colIndex +3){
                boolean[] visited = new boolean[10];

                for(int i=rowIndex; i< rowIndex+3; i++){
                    for(int j=colIndex; j<colIndex+3; j++){
                        if(board[i][j]!='.'){
                            int index = board[i][j] - '0';
                            if(visited[index])
                                return false;
                            visited[index] = true;
                        }
                    }
                }
                
            }
        }

        return true;
       }
}