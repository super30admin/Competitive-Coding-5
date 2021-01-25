//Time Complexity: O(N) where N is the number of Tree nodes
//Space Complexity: O(h) where h is the height of the tree when we consider the recursive stack space

//Successfully runs on leetcode: 0 ms

//Approach: Here, we are using DFS traversal and add an element to the result if the depth is equal to the size of the result.
//Once we add the initial elements equal to the depth of the tree, we swap the existing node values with the max value in that
//depth when we encouter a larger value than the existing one.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        //base
        if(root == null){
            return;
        }
       
        //logic
        if(d == res.size()){
            res.add(root.val);
        }
        else{
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}


//Time Complexity: O(N) where N is the number of Tree nodes
//Space Complexity: O(N) 

//Successfully runs on leetcode: 1 ms

//Approach: Here, we are using BFS traversal in which we will keep a track of all the levels separately and find a max value
//in each level and just add it to the output list

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.val > maxVal)
                    maxVal = curr.val;

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(maxVal);
        }

        return res;
    }
}