/*
  Time complexity: O(n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

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
    public IList<int> LargestValues(TreeNode root) {
        List<int> result = new List<int>();
        
        if(root==null)
            return result;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while(queue.Count>0)
        {
            int size = queue.Count;
            int max = int.MinValue;
            for(int i=0;i<size;i++)
            {
                var temp = queue.Dequeue();
                max = Math.Max(max, temp.val);

                if(temp.left!=null)
                {
                    queue.Enqueue(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.Enqueue(temp.right);
                }
            }
            result.Add(max);
        }
        return result;
    }
}
