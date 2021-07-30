// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We perform a lvel order traversal using Queues to find the largest element in each of the tree row.

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()){
            int m = Integer.MIN_VALUE;
            int size = q.size();
            for (int i=0; i<size; i++){
                TreeNode node = q.remove();
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
                m = Math.max(m,node.val);
            }
            result.add(m);
        }
        return result;
    }
}