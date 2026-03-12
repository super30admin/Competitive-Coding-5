// Time: O(N)
// Space: O(W)
// Ran on Leetcode successfully: yes
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            // take curr size snapshot for the curr level
            int size = q.size();
            // initialize max
            int max = q.peek().val;

            while(size-- > 0) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            // add max for each depth level
            ans.add(max);
        }
        return ans;
    }
}