// Problem: Find Largest Value in Each Tree Row
// Time Complexity : O(n)
// Space Complexity : O(max width of the tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Recursive DFS appraoch
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
    
        
        List<Integer>  ls = new ArrayList<>();
        if(root == null) return ls;
        
        helper(root, 0, ls);
        return ls;
    }
    
    private List<Integer> helper(TreeNode root , int level, List<Integer> ls){
        //base
        if(root == null) return null;
        if(level == ls.size()){
            ls.add(root.val);
        }else{
            ls.set( level, Math.max(ls.get(level), root.val));
        }
        
       helper(root.left, level+1, ls);
       helper(root.right, level+1, ls);
       return ls;
        
    }
    
}
// Problem: Find Largest Value in Each Tree Row
// Time Complexity : O(n)
// Space Complexity : O(max width of the tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        //edge
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        q.add(root); // [5,3,9]
        
        while(!q.isEmpty()){
            
            int size = q.size();  //3       
            for(int i=0; i< size; i++){
                TreeNode cur = q.poll(); //[5]
                
                max = Math.max(cur.val, max); // 3
                
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            
            ans.add(max);
            max = Integer.MIN_VALUE; // resetting the max value
        }
        
        return ans;
    }
}

// Problem:2: Find Largest Value in Each Tree Row
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Using hashset to store unique values for each row, column and 3*3 block. Using set.add() method which returns true 
//if the value is not already in the set, false otherwise.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        for( int i=0; i<board.length; i++){ // iterating over each row and creating sets per col,row,and block
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> block = new HashSet<>();
            
            for(int j=0; j<board[0].length; j++){
                
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;
                
                // based on the row index: calculating which box the current element belongs to
                int rowIndx= 3*(i/3);
                int colIndx= 3*(i%3);
                
                if(board[rowIndx + j/3][colIndx+j%3] != '.' && !block.add(board[rowIndx + j/3][colIndx+j%3])) return false;
            }
        }
        
        return true;
        
    }
}
