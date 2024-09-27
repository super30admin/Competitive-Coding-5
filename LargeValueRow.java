// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class LargeValueRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Base Condition to be checked.
        if(root == null) return new ArrayList<>();
        
        // Initialize queue for performing the level order traversal.
        Queue<TreeNode> q = new LinkedList<>();

        // Add the root node into the queue to initialize the traversal.
        q.add(root);
        
        // Run the traversal until the queue is empty.
        // When the queue is empty, then we have traversed all the nodes in the list.
        while(!q.isEmpty()){
            // Since we need to distinguish each level elements from the other level we use size variable.
            int size = q.size();

            // Use a temporary variable to keep track of the max element in the current level.
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                // Popping the top associated in the current level.
                TreeNode curr = q.poll();

                // Update the max variable.
                max = Math.max(max, curr.val);
                
                // Adding the left and right child's to the queue for next level processing.
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            // Once the level is processed, add the found max value to the result list.
            result.add(max);
        }
        
        return result;
    }

    public static void main(String[] args) {
        
    }
    
}
