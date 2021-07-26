Find Largest Value in Each Tree Row
        Given the root of a binary tree,return an array of the largest value in each row of the tree(0-indexed).

        Example 1:
        Input:root=[1,3,2,5,3,null,9]
        Output:[1,3,9]

        Example 2:

        Input:root=[1,2,3]
        Output:[1,3]

        Example 3:

        Input:root=[1]
        Output:[1]

        Approach1--------BFS--------------------------------

// Time Complexity : O(N) where N is number of nodes
// Space Complexity : O((N/2)+1) ~= O(N/2) where it is the total number of leaf nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// we get each level's highest value by getting the size of the queue and traversing about the size for each level of nodes.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            res.add(max);
        }
        return res;

    }
}

Approach 2----------------------------DFS-----------------------------------------------
// Time Complexity : O(N) where N is number of nodes
// Space Complexity : O(H) where H is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Depth First search where we add node's value to the list at each level's index and if current node is greater at that level of index then we replace it with greatest node's value at that index

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> res;

    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);
        return res;

    }

    private void helper(TreeNode root, int level) {
        //base
        if (root == null) return;

        //logic
        if (res.size() == level)
            res.add(root.val);
        else {
            if (root.val > res.get(level)) {
                res.set(level, root.val);
            }
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }
}