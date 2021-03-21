// Time Complexity : O(n), n = no. of nodes in tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            Integer max = null;
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if(max != null)
                    max = Math.max(max, node.val);
                else
                    max = node.val;
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
