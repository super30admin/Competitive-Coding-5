
import java.util.*;

class Sample {

    // Time Complexity : O(1) since size of the board is constant
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes


    /**
     * Approach:
     * 1. Maintain a hashset and check if if the string exists in it.
     */

    public boolean isValidSudoku(char[][] board) {
     
        if(board == null || board.length == 0)
            return false;
        
        Set<String> seen = new HashSet<>();
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                
                if(board[i][j] != '.') {
                    if(!seen.add(board[i][j] + " found in row " + i) || 
                      !seen.add(board[i][j] + " found in column " + j) || 
                      !seen.add(board[i][j] + " found in sub box " + i/3 + j/3)) {
                        return false;
                    }
                }
                
            }
        }
        
        return true;
        
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
     }


    // Time Complexity : O(N) where N is maximum size of the queue (max no of nodes in a level)
    // Space Complexity : O(H) height of the tree 
    // Did this code successfully run on Leetcode : Yes


    /**
     * Approach:
     * 1. Traverse levelwise and find the maximum element levelwise.
     */

    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            int max = Integer.MIN_VALUE;
            
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                
                //Find maximum
                if(node.val > max)
                    max = node.val;
                
                if(node.left!= null) {
                    q.add(node.left);
                }
                
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            
            result.add(max);
            
        }
        
        return result;
        
    }
}