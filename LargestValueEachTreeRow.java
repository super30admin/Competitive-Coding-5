// Time Complexity : O(h) where h is the height of tree, O(n) 
//                   when tree is left or right skewed
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* I am using level order traversal to iterate over each level. 
Size of the queue gives information of the nodes present in that level,
I remove the elements at each level from queue and find out the max at each level
*/
class LargestValueEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(null == root) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode currNode = queue.remove();
                max = Math.max(max, currNode.val);

                if(null != currNode.left) {
                    queue.add(currNode.left);
                }
                
                if(null != currNode.right) {
                    queue.add(currNode.right);
                }
            }
            result.add(max);
        }
        return result;
        
    }
}