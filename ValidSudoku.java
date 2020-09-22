// Time Complexity :O(n*n) here n is 9 a constant. Hence can be O(1) which is constant as we know the limit.
// Space Complexity : O(n+n+n=3n), but here we know n is fixed and is 9. Hence, O(1) constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// create 3 hashmap<Integer,Integer> arrays for storing the values of each row,column and box (3*3 block)
// create hashmaps at every index of the array.
// now start the iteration all over sudoku (9^2 = 81 moves), if the element is not '.', got and store at respective row and put (element,(count or 0) +1)
// deduct the index of the box by using a logic from indexes rows:i and columns:j. (i/3*3+j/3)
// if we find any of the counter more than 1 in any hashmap, it means that they are repeating and return false;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashMap<Integer, Integer> row[] = new HashMap[9];
        HashMap<Integer, Integer> col[] = new HashMap[9];
        HashMap<Integer, Integer> box[] = new HashMap[9];
        
        for(int i=0;i<9;i++){
            row[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            box[i] = new HashMap<Integer, Integer>();
        }
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num!='.'){
                    int n = (int)num;
                    int boxIndex=(i/3)*3+j/3;
                    
                    row[i].put(n,row[i].getOrDefault(n,0)+1);
                    col[j].put(n,col[j].getOrDefault(n,0)+1);
                    box[boxIndex].put(n,box[boxIndex].getOrDefault(n,0)+1);
                    
                    if(row[i].get(n)>1 || col[j].get(n)>1 || box[boxIndex].get(n)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}