// Time Complexity :O(n^2)
// Space Complexity :O(9 X 3 X elements in board)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] row= new HashSet[9];//row wise unique elemet 
        HashSet<Integer>[] col= new HashSet[9];//column wise unique element 
        HashSet<Integer>[] sub_board= new HashSet[9];//sub_board wise unique element 
        int board_num;
        
        for(int i=0;i<9;i++){
            row[i] = new HashSet<Integer>();
            col[i] = new HashSet<Integer>();
            sub_board[i] = new HashSet<Integer>();
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(row[i].contains((int)board[i][j]))//if already seen in that same row , not valid board
                        return false;
                    else
                        row[i].add((int)board[i][j]);

                    if(col[j].contains((int)board[i][j]))//if already seen in that same column , not valid board
                        return false;
                    else
                        col[j].add((int)board[i][j]);

                    board_num=((i/3)*3) + (j/3);//calculating board number
                    
                    if(sub_board[board_num].contains((int)board[i][j]))//if already seen in that same sub board , not valid board
                        return false;
                    else
                        sub_board[board_num].add((int)board[i][j]);
                }
            }
        }
        
        return true;
    }
}