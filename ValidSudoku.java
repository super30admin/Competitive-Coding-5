//time complexity : O(1)
// Space Complexity : O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hsBox = new HashSet<>();
        for(int i = 0;i<board.length;i++){
            HashSet<Character> hsCol = new HashSet<>();
            HashSet<Character> hsRow = new HashSet<>();
            for(int j =0; j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(!hsCol.contains(board[i][j])){
                        hsCol.add(board[i][j]);
                    }
                    else{
                        //System.out.println(i+" "+board[i][j]);
                        return false;
                    }
                    if(!hsBox.contains(board[i][j]+" "+Integer.toString(i/3)+" "+Integer.toString(j/3))){
                        hsBox.add(board[i][j]+" "+Integer.toString(i/3)+" "+Integer.toString(j/3));
                    }
                    else{
                        return false;
                    }
                }
                if(board[j][i] != '.'){
                    if(!hsRow.contains(board[j][i])){
                        hsRow.add(board[j][i]);
                    }
                    else{
                        System.out.println(j+" "+i+" "+board[j][i]);
                        return false;
                    }
                    
                }
                
            }  
        }
        
        return true;
        
    }
}
