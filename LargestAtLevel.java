// You need to find the largest value in each row of a binary tree.

// Example:
// Input: 

//           111
//          / \
//         3   21
//        / \   \  
//       5   311   91 
// Output: [111, 21, 311]

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class LargestAtLevel {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int maxAtLevel = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                maxAtLevel = Math.max(node.val, maxAtLevel);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(maxAtLevel);
        }
        return res;
    }
}