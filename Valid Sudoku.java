//Time Complexity : O(1) as the size of the board is fixed(9*9)
//Space Complexity : O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length==0){
            return false;
        }
        //use a hashset to keep track of duplicates
        HashSet<String> set = new HashSet<>();
        //use a single hash set of type string instead o maintaing 3 for row,col and sub boxes
        //iterate through the board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //if the cell is not empty
                if(board[i][j]!='.'){
                    //check if the current element is not already present
                    //if its not possible to add the current element into the hash set then its a duplicate 
                    /*if(!set.add(board[i][j]+'ROW'+i)|| //the cur item is added to set if its not present before and this particular item is disstinguided by ROW indicating this is unique in this row
                       !set.add(board[i][j]+'COL'+j)|| // similarly for col
                      !set.add(board[i][j]+'BOX'+j/3+'OR'+i/3))// similarly for box.the box number is determined by currow/3 or curcol/3*/
                    if(!set.add(board[i][j]+ "ROW" +i)||
                       !set.add(board[i][j]+ "COL" +j) ||
                       !set.add(board[i][j]+ "BOX"+j/3+"OR"+i/3))
                    {//if its not possible to add then return false indicating a duplicate
                        return false;
                    }
                }
            }
        }
        //otherwise return true
        return true;
    }
}