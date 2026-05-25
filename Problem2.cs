// Time Complexity : O(n)
// Space Complexity : O(n) where n = width of the tree (space taken up by the queue to perform BFS)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I initialize result to an empty list at first. If root equals null, I return the result else I enqueue the root to a queue. I start performing BFS on the tree and keep track of each level.
At each level I calculate the maximum element and add it to the result list. After visiting all nodes of the tree, I return the result.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    List<int> result;
    public IList<int> LargestValues(TreeNode root) {
        result = new();

        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> q = new();
        TreeNode temp = root;

        q.Enqueue(temp);

        while(q.Count != 0)
        {
            int size = q.Count;
            int currentRowMinValue = q.Peek().val;

            for(int i = 0; i < size; i++)
            {
                TreeNode currentNode = q.Dequeue();

                currentRowMinValue = Math.Max(currentRowMinValue, currentNode.val);

                if(currentNode.left != null)
                {
                    q.Enqueue(currentNode.left);
                }

                if(currentNode.right != null)
                {
                    q.Enqueue(currentNode.right);
                }
            }

            result.Add(currentRowMinValue);
        }

        return result;
    }
}