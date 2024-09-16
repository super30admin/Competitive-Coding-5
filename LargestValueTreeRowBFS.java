import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(w), where w - width
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class LargestValueTreeRowBFS {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();
        if(root == null){
            return retVal;
        }
        
        Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            retVal.add(max);
        }
        
        return retVal;
    }
}