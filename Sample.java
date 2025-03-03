// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Sets to keep track of the digits we've seen for rows, columns, and sub-grids
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                
                if (num == '.') {
                    continue; // Skip empty cells
                }
                
                // Check if the number has already been seen in the same row, column, or sub-grid
                String rowKey = "row" + i + num;
                String colKey = "col" + j + num;
                String subGridKey = "subGrid" + (i / 3) + (j / 3) + num;
                
                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(subGridKey)) {
                    return false; // Duplicate found
                }
                
                // Add the current number to the respective sets
                seen.add(rowKey);
                seen.add(colKey);
                seen.add(subGridKey);
            }
        }
        
        return true; // No duplicates found, valid Sudoku
    }
}


// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {

    public List<Integer> largestValues(TreeNode root) {
 
        List<Integer> result = new ArrayList<>();
 
        findMax(root,result,0);
 
        return result;
 
    }
 
    public void findMax(TreeNode root,List<Integer> result,int level){
 
        if(root==null) return;
 
        if(result.size()==level){
 
            result.add(root.val);
 
        }
 
        else result.set(level,result.get(level)<root.val?root.val:result.get(level));
 
        findMax(root.left,result,level+1);
 
        findMax(root.right,result,level+1);
 
    }
 
 }
 