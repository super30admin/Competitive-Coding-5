// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(H), H = Height of the tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if(curr.val>max)
                    max = curr.val;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}